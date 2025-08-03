/***********************************************************************/
/* File: main.cpp */
/* Brief: HMI Dashboard main function */
/* Author: Raul Camacho */
/* Version: 1.0 */
/* Date: 30/Aug/2015 */
/***********************************************************************/
/***********************************************************************/
/* HEADER FILE INCLUDES */
/***********************************************************************/
#include <QtGui/QGuiApplication>
#include "qtquick2applicationviewer.h"
#include <QTimer>
#include <dlt/dlt.h>
#include "hmi_dashboard.h"
#include "hmi_shared_memory.h"
#include "hmi_states_values.h"
/***********************************************************************/
/***********************************************************************/
/* MACROS */
/***********************************************************************/
/* Creating logging context - DLT logs */
DLT_DECLARE_CONTEXT(hmi_context);
/***********************************************************************/
/***********************************************************************/
/* FUNCTION DEFINITIONS */
/***********************************************************************/
/***********************************************************************/
/* Name: main
* Brief: Main HMI Dashboard function
* Author: Raul Camacho
* Param: void
* Return: int
*/
int main(int argc,char*argv[])
{
    /* Register the application and the context to DLT */
    DLT_REGISTER_APP("CPI","Cluster PI");
    DLT_REGISTER_CONTEXT(hmi_context,"HMI","HMI Context");
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING("HMI Dashboard Initialization"));
    QGuiApplication app(argc, argv);
    /* Declare Window Object */
    Window Dashboard;
    /* Declare Timer Object */
    QTimer Timer;
    /* Set 100 ms timeout */
    Timer.start(10000);
    /* Connect timeout signal to Update_Can_Data function - call function
every 100 ms */
    app.connect(&Timer, SIGNAL(timeout()),&Dashboard,
                SLOT(Update_Can_Data()));
    return app.exec();
    /* Unregister the application and the context - DLT */
    DLT_UNREGISTER_CONTEXT(hmi_context);
    DLT_UNREGISTER_APP();
}
/***********************************************************************/
