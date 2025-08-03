/***********************************************************************/
/* File: hmi_dashboard.cpp */
/* Brief: HMI Dashboard functions */
/* Author: Raul Camacho */
/* Version: 1.0 */
/* Date: 09/Oct/2015 */
/***********************************************************************/
/***********************************************************************/
/* HEADER FILE INCLUDES */
/***********************************************************************/
#include <dlt/dlt.h>
#include "hmi_dashboard.h"
#include "hmi_shared_memory.h"
#include "hmi_states_values.h"
/***********************************************************************/
/***********************************************************************/
/* LOCAL VARIABLES */
/***********************************************************************/
/* HMI states */
HMI_STATES hmi_state;
/* Struct for valid data from Shared Memory - Can Protocol */
tshared_memory hmi_valid_data;
/***********************************************************************/
/***********************************************************************/
/* MACROS */
/***********************************************************************/
/* Import HMI context already registered on DLT */
DLT_IMPORT_CONTEXT(hmi_context)
/***********************************************************************/
/***********************************************************************/
/* LOCAL DEFINES */
/***********************************************************************/
#define HMI_VALIDATION_CTR 19
#define ENABLED 1
#define DISABLED 0
#define HMI_ANIMATION_CTR_LIMIT 21
/***********************************************************************/
/***********************************************************************/
/* FUNCTION DEFINITIONS */
/***********************************************************************/
/***********************************************************************/
/* Name: Window Object
* Brief: Declare Dashboard object
* Author: Raul Camacho
*/
Window::Window(QWindow *parent):
    QQuickView(parent)
{
//    Dashboard = new QtQuick2ApplicationViewer(this);
    Dashboard = new QtQuick2ApplicationViewer(this);
    /* Run shutdown event - Fist event on HMI Dashboard initialization */
    hmi_state_shutdown_event(Dashboard);
    /* Initial HMI state*/
    hmi_state = HMI_STATE_SHUTDOWN;
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("INITIAL HMI DASHBOARD STATE: HMI_STATE_SHUTDOWN"));
    /* Init all hmi_valid_data struct values to 0 */
    memset(&hmi_valid_data,0,sizeof(hmi_valid_data));
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("Init hmi_valid_data structure values to 0"));
    Dashboard->setMainQmlFile(QStringLiteral("qml/Dashboard/main.qml"));
    Dashboard->showExpanded();
}
/***********************************************************************/
/* Name: Update_Can_Data
* Brief: Funtion to be called every 100ms to update valid data from
shared memory (CAN).
* SLOT connected to timer SIGNAL.
* Author: Raul Camacho
* Param: void
* Return: void
*/
void Window::Update_Can_Data()
{
    /* Local variables*/
    char hmi_shmem_res;
    char hmi_cmp_data_res;
    static char hmi_validation_ctr =0;
    static char hmi_animation_ctr =0;
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING(__FUNCTION__),DLT_STRING("function called"));
    /* Init shared memory */
    hmi_shmem_res = hmi_init_shared_memory();
    if(hmi_shmem_res ==0){
        /* Compare valid_data with shared memory */
        hmi_cmp_data_res = hmi_compare_data(&hmi_valid_data);
        /* Check if at least one value was changed */
        if( hmi_cmp_data_res ==0){
            /* No value was changed */
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("No value was changed - Iqual structures (Shared memory and Valid data)"));
            hmi_validation_ctr++;
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("Increment HMI_VALIDATION_CTR:"),DLT_INT(hmi_validation_ctr));
            /* Check if a communication error occurs */
            if(hmi_validation_ctr > HMI_VALIDATION_CTR && hmi_state != HMI_STATE_ANIMATION){
                hmi_state = HMI_STATE_COMUNNICATION_ERROR;
                DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_COMUNNICATION_ERROR"));
                hmi_validation_ctr =0;
                DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("COMUNNICATION_ERROR occurs, HMI_VALIDATION_CTR:"),DLT_INT(hmi_validation_ctr));
            }else if(hmi_validation_ctr < HMI_VALIDATION_CTR && hmi_state == HMI_STATE_ANIMATION){
                /* Skip hmi_validation_ctr from HMI Animation */
                hmi_validation_ctr--;
                DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI_STATE_ANIMATION running, decrement HMI_VALIDATION_CTR:"),DLT_INT(hmi_validation_ctr));
            }
        }else{
            /* At least one shared memory value was changed */
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("Diferent structures (Shared memory and Valid data)"));
            /* Copy shared memory values to hmi_valid_data */

            hmi_copy_data(&hmi_valid_data);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("Copy values from Shared Memory to Valid data)"));
            hmi_validation_ctr =0;
        }
    }else{
        DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("Unable to read SHARED MEMORY - Stay on the same HMI_STATE"));
        return;
    }
    /* Deinit shared memory */
    hmi_deinit_shared_memory();
    /* HMI Dashboard states handler */
    switch(hmi_state)
    {
    case HMI_STATE_SHUTDOWN:
    {
        DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("ENTER TO HMI DASHBOARD STATE: HMI_STATE_SHUTDOWN"));
        if(hmi_valid_data.key_status == DISABLED){
            hmi_state = HMI_STATE_SHUTDOWN;
            hmi_state_shutdown_event(Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_SHUTDOWN"));
        }else if(hmi_valid_data.low_battery == ENABLED){
            hmi_state = HMI_STATE_DEFAULT;
            hmi_state_default_event(Dashboard);
            Dashboard->rootContext()->setContextProperty("low_battery", ENABLED);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_DEFAULT - Low Batery"));
        }else{
            hmi_state = HMI_STATE_ANIMATION;
            hmi_state_animation_event(Dashboard);
            hmi_animation_ctr++;
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_ANIMATION"));
        }
        break;
    }
    case HMI_STATE_ANIMATION:
    {
        DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("ENTER TO HMI DASHBOARD STATE: HMI_STATE_ANIMATION"));
        if(hmi_valid_data.key_status == DISABLED){
            hmi_state = HMI_STATE_SHUTDOWN;
            hmi_state_shutdown_event(Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_SHUTDOWN"));
        }else if(hmi_valid_data.low_battery == ENABLED){
            hmi_state = HMI_STATE_DEFAULT;
            hmi_state_default_event(Dashboard);
            Dashboard->rootContext()->setContextProperty("low_battery", ENABLED);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_DEFAULT - Low Batery"));
        }else if(hmi_animation_ctr <= HMI_ANIMATION_CTR_LIMIT){
            hmi_state = HMI_STATE_ANIMATION;
            hmi_state_animation_event(Dashboard);
            hmi_animation_ctr++;
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_ANIMATION"));
        }else{
            hmi_state = HMI_STATE_DEFAULT;
            hmi_animation_ctr =0;
            hmi_state_default_event(Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_DEFAULT"));
        }
        break;
    }
    case HMI_STATE_DEFAULT:
    {
        DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("ENTER TO HMI DASHBOARD STATE: HMI_STATE_DEFAULT"));
        if(hmi_valid_data.key_status == DISABLED){
            hmi_state = HMI_STATE_SHUTDOWN;
            hmi_state_shutdown_event(Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_SHUTDOWN"));
        }else if(hmi_valid_data.low_battery == ENABLED){
            hmi_state = HMI_STATE_DEFAULT;
            hmi_state_default_event(Dashboard);
            Dashboard->rootContext()->setContextProperty("low_battery", ENABLED);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_DEFAULT - Low Batery"));
        }else{
            hmi_state = HMI_STATE_RUNTIME;
            hmi_state_runtime_event(&hmi_valid_data, Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_RUNTIME"));
        }
        break;
    }
    case HMI_STATE_RUNTIME:
    {
        DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("ENTER TO HMI DASHBOARD STATE: HMI_STATE_RUNTIME"));
        if(hmi_valid_data.key_status == DISABLED){
            hmi_state = HMI_STATE_SHUTDOWN;
            hmi_state_shutdown_event(Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_SHUTDOWN"));
        }else if(hmi_valid_data.low_battery == ENABLED){
            hmi_state = HMI_STATE_DEFAULT;
            hmi_state_default_event(Dashboard);
            Dashboard->rootContext()->setContextProperty("low_battery", ENABLED);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_DEFAULT - Low Batery"));
        }else{
            hmi_state = HMI_STATE_RUNTIME;
            hmi_state_runtime_event(&hmi_valid_data, Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_RUNTIME"));
        }
        break;
    }
    case HMI_STATE_COMUNNICATION_ERROR:
    {
        DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("ENTER TO HMI DASHBOARD STATE: HMI_STATE_COMUNNICATION_ERROR"));
        if(hmi_valid_data.key_status == ENABLED && hmi_cmp_data_res ==1){
            hmi_state = HMI_STATE_DEFAULT;
            hmi_state_default_event(Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_DEFAULT"));
        }else if(hmi_valid_data.key_status == ENABLED){
            hmi_state = HMI_STATE_COMUNNICATION_ERROR;
            hmi_state_default_event(Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_COMUNNICATION_ERROR"));
        }else{
            hmi_state = HMI_STATE_SHUTDOWN;
            hmi_state_shutdown_event(Dashboard);
            DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI DASHBOARD CHANGE STATE TO: HMI_STATE_SHUTDOWN"));
        }
        break;
    }
    }
}
/***********************************************************************/
