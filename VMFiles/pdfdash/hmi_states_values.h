/***********************************************************************/
/* File: hmi_states_values.h */
/* Brief: HMI definitions to use on hmi_states_values.c */
/* Author: Raul Camacho */
/* Version: 1.0 */
/* Date: 09/Oct/2015 */
/***********************************************************************/
#ifndef HMI_STATES_VALUES_H /* Prevent duplicated includes */
#define HMI_STATES_VALUES_H
/***********************************************************************/
/* FUNCTION PROTOTYPES */
/***********************************************************************/
void hmi_state_shutdown_event(QtQuick2ApplicationViewer *hmi_dashboard);
void hmi_state_animation_event(QtQuick2ApplicationViewer *hmi_dashboard);
void hmi_state_runtime_event(tshared_memory* data,
                             QtQuick2ApplicationViewer *hmi_dashboard);
void hmi_state_default_event(QtQuick2ApplicationViewer *hmi_dashboard);
/***********************************************************************/
#endif /* HMI_STATES_VALUES_H */
/***********************************************************************/
