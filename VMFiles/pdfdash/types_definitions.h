/***********************************************************************/
#ifndef TYPES_DEFINITIONS_H_
#define TYPES_DEFINITIONS_H_
#define ON 1
#define OFF 0
typedef struct{
float battery;
float env_temp;
float speed;
float fuel;
float efficiency;
unsigned int odometer;
unsigned short rpms;
unsigned char tire_presure_1;
unsigned char low_presure_1_warning;
unsigned char tire_presure_2;
unsigned char low_presure_2_warning;
unsigned char tire_presure_3;
unsigned char low_presure_3_warning;
unsigned char tire_presure_4;
unsigned char low_presure_4_warning;
unsigned char gear;
unsigned char compas;
unsigned char high_beam;
unsigned char low_beam;
unsigned char optical_horn;
unsigned char turn_right;
unsigned char turn_left;
unsigned char hazard_warning_light;
unsigned char abs_break;
unsigned char airbag;
unsigned char key_status;
unsigned char low_battery;
unsigned char low_fuel;
unsigned char check_engine;
unsigned char seat_belt;
unsigned char hand_break;
unsigned char satelital_notification;
unsigned char oil;
unsigned char door_warning_light;
unsigned char motor_temperature_warning;
} tshared_memory;
#endif /* TYPES_DEFINITIONS_H_ */
/***********************************************************************/
