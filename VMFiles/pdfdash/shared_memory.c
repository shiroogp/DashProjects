/***********************************************************************/
#include "shared_memory.h"
tshared_memory can_data;
tshared_memory * ptr_can_data;
/* Data types for Semaphore and Shared Memory*/
key_t Key;
int Id_Shared_Memory;
int Id_Semaphore;
struct sembuf Operation;
#define FILEKEY "/bin/ls"
#define KEY 10
#define BYTES sizeof(can_data)
#define SEMAPHORES 1
void init_shared_memory(void){
    /* Calculate Key for Shared Memory and Semaphore */
    Key = ftok(FILEKEY, KEY);
    /* Check if error */
    if(Key ==-1)
    {
        printf ("Error with Key for Shared Memory and Semaphore \n");
        return;
    }
    /* Create the Semaphore */
    Id_Semaphore = semget (Key, SEMAPHORES,0777| IPC_CREAT);
    /* Check if error */
    if(Id_Semaphore ==-1)
    {
        printf ("Error with Shared Memory ID \n");
        return;
    }
    /* Create the Shared Memory */
    Id_Shared_Memory = shmget (Key, BYTES,0777| IPC_CREAT);
    /* Check if error */
    if(Id_Shared_Memory ==-1)
    {
        printf ("Error with Shared Memory ID \n");
        return;
    }
    /* Semaphore Initialization*/
    semctl(Id_Semaphore,0, SETVAL,1);
    /* Point to Shared Memory */
    ptr_can_data =(tshared_memory *)shmat
            (Id_Shared_Memory,(char*)0,0);
    /* Check if error */
    if(ptr_can_data ==NULL)
    {
        printf ("Error reserving shared memory \n");
        return;
    }
    /* Set values for Semaphore */
    Operation.sem_num =0;
    Operation.sem_flg =0;
    Operation.sem_op =1;
}
void deinit_shared_memory(void){
    /* Free the shared memory */
    shmdt ((char*)ptr_can_data);
    shmctl (Id_Shared_Memory, IPC_RMID,(struct shmid_ds *)NULL);
    return;
}
void write_uint8_value(char option,char value){
    switch(option){
    case'q':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->high_beam = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'w':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->low_beam = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'e':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->optical_horn = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'r':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->turn_right = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case't':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->turn_left = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'y':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->hazard_warning_light = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'u':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->abs_break = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'i':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->airbag = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'o':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /*Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->key_status = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'p':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->low_battery = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'a':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->low_fuel = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case's':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->check_engine = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'd':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->seat_belt = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'f':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->hand_break = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'g':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->satelital_notification = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'h':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->oil = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'j':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->door_warning_light = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'k':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->motor_temperature_warning = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'm':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->low_presure_1_warning = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'2':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->low_presure_2_warning = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'4':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->low_presure_3_warning = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'6':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->low_presure_4_warning = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    default:
        break;
    }
}
void write_int_value(char option,int value){
    switch(option){
    case'b':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->rpms =(short)value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'n':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->tire_presure_1 =(char)value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'1':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->tire_presure_2 =(char)value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'3':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->tire_presure_3 =(char)value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'5':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->tire_presure_4 =(char)value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'7':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->odometer =(int)value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'8':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->gear =(char)value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'9':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->compas =(char)value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    default:
        break;
    }
}
void write_float_value(char option,float value){
    switch(option){
    case'l':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->battery = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'z':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->env_temp = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'x':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->speed = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'c':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->fuel = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    case'v':
        /* Change Semaphore to RED */
        Operation.sem_op =-1;
        /* Set the Semaphore to RED */
        semop (Id_Semaphore,&Operation,1);
        /* Write Value */
        ptr_can_data->efficiency = value;
        /* Change Semaphore to GREEN */
        Operation.sem_op =1;
        /* Set Semaphore to GREEN */
        semop (Id_Semaphore,&Operation,1);
        break;
    default:
        break;
    }
}
/***********************************************************************/
