/***********************************************************************/
/* File: hmi_shared_memory.h */
/* Brief: HMI definitions to use on hmi_shared_memory */
/* Author: Raul Camacho */
/* Version: 1.0 */
/* Date: 09/Oct/2015 */
/***********************************************************************/
#ifndef HMI_SHARED_MEMORY_H /* Prevent duplicated includes */
#define HMI_SHARED_MEMORY_H
/***********************************************************************/
/* TYPES */
/***********************************************************************/
typedef struct{
    float battery;
    float env_temp;
    float speed;
    float fuel;
    float efficiency;
    int odometer;
    short rpms;
    char tire_presure_1;
    char low_presure_1_warning;
    char tire_presure_2;
    char low_presure_2_warning;
    char tire_presure_3;
    char low_presure_3_warning;
    char tire_presure_4;
    char low_presure_4_warning;
    char gear;
    char compass;
    char high_beam;
    char low_beam;
    char optical_horn;
    char turn_right;
    char turn_left;
    char hazard_warning_light;
    char abs_break;
    char airbag;
    char key_status;
    char low_battery;
    char low_fuel;
    char check_engine;
    char seat_belt;
    char hand_brake;
    char sattelital_notification;
    char oil;
    char door_warning_light;
    char motor_temperature_warning;
} tshared_memory;
/***********************************************************************/
/***********************************************************************/
/* FUNCTION PROTOTYPES */
/***********************************************************************/
char hmi_init_shared_memory(void);
void hmi_deinit_shared_memory(void);
char hmi_compare_data(tshared_memory* valid_data);
void hmi_copy_data(tshared_memory* valid_data);
/***********************************************************************/
#endif /* HMI_SHARED_MEMORY_H */
/***********************************************************************/
