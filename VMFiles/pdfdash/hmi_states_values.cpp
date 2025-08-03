/***********************************************************************/
/* File: hmi_states_values.cpp */
/* Brief: HMI Dashboard states functions */
/* Author: Raul Camacho */
/* Version: 1.0 */
/* Date: 09/Oct/2015 */
/***********************************************************************/
/***********************************************************************/
/* HEADER FILE INCLUDES */
/***********************************************************************/
#include <QObject>
#include <QQmlContext>
#include <QtQuick/QQuickView>
#include "qtquick2applicationviewer.h"
#include <time.h>
#include <dlt/dlt.h>
#include "hmi_dashboard.h"
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
#define ENABLED 1
#define DISABLED 0.0
/***********************************************************************/
/***********************************************************************/
/* FUNCTION DEFINITIONS */
/***********************************************************************/
/***********************************************************************/
/* Name: hmi_state_shutdown_event
* Brief: Function to disable (no visible) all values and shows a black
screen when enter
* to HMI_STATE_SHUTDOWN.
* Author: Raul Camacho
* Param: QtQuick2ApplicationViewer*
* Return: void
*/
void hmi_state_shutdown_event(QtQuick2ApplicationViewer *hmi_dashboard){
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING(__FUNCTION__),DLT_STRING("function called"));
    /* Set values to Dashboard screen */
    hmi_dashboard->rootContext()->setContextProperty("battery",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("env_temp",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("speed",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("fuel",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("efficiency",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("odometer",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("rpms",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_1",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_1_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_2",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_2_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_3",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_3_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_4",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_4_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("gear",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("compass",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("high_beam",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_beam",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("optical_horn",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("turn_right",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("turn_left",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("hazard_warning_light",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("abs_break",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("airbag",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("key_status",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_battery",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_fuel",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("check_engine",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("seat_belt",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("hand_brake",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("sattelital_notification",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("oil",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("door_warning_light",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("motor_temperature_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("shutdown",ENABLED);
}
/***********************************************************************/
/* Name: hmi_state_animation_event
* Brief: Function to show an animation on Dashboard screen when enter
to
* HMI_STATE_ANIMATION.
* Author: Raul Camacho
* Param: QtQuick2ApplicationViewer*
* Return: void
*/
void hmi_state_animation_event(QtQuick2ApplicationViewer *hmi_dashboard){
    /* Local Counters */
    static char ctr =0;
    static char flag =0;
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING(__FUNCTION__),DLT_STRING("function called"));
    /* Set values to Dashboard screen */
    hmi_dashboard->rootContext()->setContextProperty("env_temp",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("efficiency",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("odometer",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_1",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_1_warning",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_2",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_2_warning",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_3",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_3_warning",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_4",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_4_warning",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("gear",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("compass",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("high_beam",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_beam",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("optical_horn",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("turn_right",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("turn_left",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("hazard_warning_light",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("abs_break",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("airbag",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("key_status",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_battery",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_fuel",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("check_engine",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("seat_belt",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("hand_brake",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("sattelital_notification",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("oil",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("door_warning_light",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("motor_temperature_warning",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("shutdown",DISABLED);
    /* Set the values for animation */
    if(ctr<190 && flag == 0){
        hmi_dashboard->rootContext()->setContextProperty("speed",ctr);
        hmi_dashboard->rootContext()->setContextProperty("rpms",ctr*52.63);
        hmi_dashboard->rootContext()->setContextProperty("fuel",ctr/2.99);
        hmi_dashboard->rootContext()->setContextProperty("battery",ctr/12.25);
        ctr+=19;
    }else if(ctr ==190 && flag == 0){
        flag =1;
        hmi_dashboard->rootContext()->setContextProperty("speed",ctr);
        hmi_dashboard->rootContext()->setContextProperty("rpms",ctr*52.63);
        hmi_dashboard->rootContext()->setContextProperty("fuel",ctr/2.99);
        hmi_dashboard->rootContext()->setContextProperty("battery",ctr/12.25);
        return;
    }
    if(ctr>0&& flag ==1){
        hmi_dashboard->rootContext()->setContextProperty("speed",ctr);
        hmi_dashboard->rootContext()->setContextProperty("rpms",ctr*52.63);
        hmi_dashboard->rootContext()->setContextProperty("fuel",ctr/2.99);
        hmi_dashboard->rootContext()->setContextProperty("battery",ctr/12.25);
        ctr-=19;
    }else if(ctr ==0&& flag ==1){
        flag =0;
        hmi_dashboard->rootContext()->setContextProperty("speed",ctr);
        hmi_dashboard->rootContext()->setContextProperty("rpms",ctr*52.63);
        hmi_dashboard->rootContext()->setContextProperty("fuel",ctr/2.99);
        hmi_dashboard->rootContext()->setContextProperty("battery",ctr/12.25);
    }
}
/***********************************************************************/
/* Name: hmi_state_default_event
* Brief: Function to set default vvalues on Dashboard screen when
enter to
* HMI_STATE_DEFAULT or others.
* Author: Raul Camacho
* Param: QtQuick2ApplicationViewer*
* Return: void
*/
void hmi_state_default_event(QtQuick2ApplicationViewer *hmi_dashboard){
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING(__FUNCTION__),DLT_STRING("function called"));
    /* Set values to Dashboard screen */
    hmi_dashboard->rootContext()->setContextProperty("battery",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("env_temp",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("speed",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("fuel",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("efficiency",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("odometer",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("rpms",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_1",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_1_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_2",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_2_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_3",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_3_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_4",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_4_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("gear",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("compass",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("high_beam",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_beam",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("optical_horn",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("turn_right",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("turn_left",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("hazard_warning_light",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("abs_break",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("airbag",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("key_status",ENABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_battery",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("low_fuel",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("check_engine",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("seat_belt",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("hand_brake",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("sattelital_notification",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("oil",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("door_warning_light",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("motor_temperature_warning",DISABLED);
    hmi_dashboard->rootContext()->setContextProperty("shutdown",DISABLED);
}
/***********************************************************************/
/* Name: hmi_state_runtime_event
* Brief: Function to show runtime values (hmi_valid_data - CAN) on
Dashboard screen when
* enter to HMI_STATE_RUNTIME.
* Author: Raul Camacho
* Param: QtQuick2ApplicationViewer*
* Return: void
*/
void hmi_state_runtime_event(tshared_memory* data,
                             QtQuick2ApplicationViewer *hmi_dashboard){
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING(__FUNCTION__),DLT_STRING("function called"));
    /* Set values to Dashboard screen */
    hmi_dashboard->rootContext()->setContextProperty("battery",data->battery);
    hmi_dashboard->rootContext()->setContextProperty("env_temp",data->env_temp);
    hmi_dashboard->rootContext()->setContextProperty("speed",data->speed);
    hmi_dashboard->rootContext()->setContextProperty("fuel",data->fuel);
    hmi_dashboard->rootContext()->setContextProperty("efficiency",data->efficiency);
    hmi_dashboard->rootContext()->setContextProperty("odometer",data->odometer);
    hmi_dashboard->rootContext()->setContextProperty("rpms",data->rpms);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_1",data->tire_presure_1);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_1_warning",data->low_presure_1_warning);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_2",data->tire_presure_2);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_2_warning",data->low_presure_2_warning);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_3",data->tire_presure_3);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_3_warning",data->low_presure_3_warning);
    hmi_dashboard->rootContext()->setContextProperty("tire_presure_4",data->tire_presure_4);
    hmi_dashboard->rootContext()->setContextProperty("low_presure_4_warning",data->low_presure_4_warning);
    hmi_dashboard->rootContext()->setContextProperty("gear",data->gear);
    hmi_dashboard->rootContext()->setContextProperty("compass",data->compass);
    hmi_dashboard->rootContext()->setContextProperty("high_beam",data->high_beam);
    hmi_dashboard->rootContext()->setContextProperty("low_beam",data->low_beam);
    hmi_dashboard->rootContext()->setContextProperty("optical_horn",data->optical_horn);
    hmi_dashboard->rootContext()->setContextProperty("turn_right",data->turn_right);
    hmi_dashboard->rootContext()->setContextProperty("turn_left",data->turn_left);
    hmi_dashboard->rootContext()->setContextProperty("hazard_warning_light",data->hazard_warning_light);
    hmi_dashboard->rootContext()->setContextProperty("abs_break",data->abs_break);
    hmi_dashboard->rootContext()->setContextProperty("airbag",data->airbag);
    hmi_dashboard->rootContext()->setContextProperty("key_status",data->key_status);
    hmi_dashboard->rootContext()->setContextProperty("low_battery",data->low_battery);
    hmi_dashboard->rootContext()->setContextProperty("low_fuel",data->low_fuel);
    hmi_dashboard->rootContext()->setContextProperty("check_engine",data->check_engine);
    hmi_dashboard->rootContext()->setContextProperty("seat_belt",data->seat_belt);
    hmi_dashboard->rootContext()->setContextProperty("hand_brake",data->hand_brake);
    hmi_dashboard->rootContext()->setContextProperty("sattelital_notification",data->sattelital_notification);
    hmi_dashboard->rootContext()->setContextProperty("oil",data->oil);
    hmi_dashboard->rootContext()->setContextProperty("door_warning_light",data->door_warning_light);
    hmi_dashboard->rootContext()->setContextProperty("motor_temperature_warning",data->motor_temperature_warning);
    hmi_dashboard->rootContext()->setContextProperty("shutdown",DISABLED);
}
/***********************************************************************/
