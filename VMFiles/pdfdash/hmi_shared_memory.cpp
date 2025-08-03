/***********************************************************************/
/* File: hmi_shared_memory.cpp */
/* Brief: HMI Shared Memory functions */
/* Author: Raul Camacho/Rafael Cabrera */
/* Version: 1.0 */
/* Date: 09/Oct/2015 */
/***********************************************************************/
/***********************************************************************/
/* HEADER FILE INCLUDES */
/***********************************************************************/
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <dlt/dlt.h>
#include "hmi_shared_memory.h"
#include "hmi_dashboard.h"
/***********************************************************************/
/***********************************************************************/
/* LOCAL VARIABLES */
/***********************************************************************/
tshared_memory Can_Data;
tshared_memory *ptr_Can_Data;
key_t Key;
int Id_Shared_Memory;
int Id_Semaphore;
struct sembuf Operation;
/***********************************************************************/
/***********************************************************************/
/* LOCAL DEFINES */
/***********************************************************************/
#define FILEKEY "/bin/ls"
#define KEY 10
#define BYTES sizeof(Can_Data)
#define SEMAPHORES 1
/***********************************************************************/
/***********************************************************************/
/* MACROS */
/***********************************************************************/
/* Import HMI context already registered on DLT */
DLT_IMPORT_CONTEXT(hmi_context)
/***********************************************************************/
/***********************************************************************/
/* FUNCTION DEFINITIONS */
/***********************************************************************/
/***********************************************************************/
/* Name: hmi_init_shared_memory
* Brief: Function to initialize Shared Memory - IPC
* Author: Raul Camacho
* Param: void
* Return: char
*/
char hmi_init_shared_memory(void){
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING(__FUNCTION__),DLT_STRING("fun ction called"));
    /* Get Key */
    Key = ftok (FILEKEY, KEY);
    if(Key ==-1)
    {
        DLT_LOG(hmi_context,DLT_LOG_ERROR,DLT_STRING("Error with Key for Shared Memory and Semaphore"));
        return 1;
    }
    /* Get Semaphore Id */
    Id_Semaphore = semget(Key, SEMAPHORES,0777| IPC_CREAT);
    if(Id_Semaphore ==-1)
    {
        DLT_LOG(hmi_context,DLT_LOG_ERROR,DLT_STRING("Error with Semaphore ID, SHARED_MEMORY_ERROR"));
        return 1;
    }
    /* Get Shared Memory Id */
    Id_Shared_Memory = shmget (Key, BYTES,0777);
    if(Id_Shared_Memory ==-1)
    {
        DLT_LOG(hmi_context,DLT_LOG_ERROR,DLT_STRING("Error with Shared Memory ID, SHARED_MEMORY_ERROR"));
        return 1;
    }
    /* Get pointer to Shared Memory*/
    ptr_Can_Data =(tshared_memory *)shmat (Id_Shared_Memory,(char*)0,0);
    if(ptr_Can_Data ==NULL)
    {
        DLT_LOG(hmi_context,DLT_LOG_ERROR,DLT_STRING("Error getting shared memory, SHARED_MEMORY_ERROR"));
        return 1;
    }
    /* Init semaphore values */
    Operation.sem_num =0;
    Operation.sem_flg =0;
    Operation.sem_op =1;
    return 0;
}
/***********************************************************************/
/* Name: hmi_deinit_shared_memory
* Brief: Function to deinitialize Shared Memory - IPC
* Author: Raul Camacho
* Param: void
* Return: void
*/
void hmi_deinit_shared_memory(void){
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING(__FUNCTION__),DLT_STRING("function called"));
    /* Free the shared memory */
    shmdt ((char*)ptr_Can_Data);
    return;
}
/***********************************************************************/
/* Name: hmi_compare_data
* Brief: Function to compare data structures (valid data vs shared
memory)
* Author: Raul Camacho
* Param: tshared_memory*
* Return: void
*/
char hmi_compare_data(tshared_memory* valid_data){
    /* Local variables */
    char cmp_res;
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING(__FUNCTION__),DLT_STRING("function called"));
    /* Change Semaphore to RED */
    Operation.sem_op =-1;
    /* Set the Semaphore to RED */
    semop (Id_Semaphore,&Operation,1);
    if(memcmp(ptr_Can_Data, valid_data,sizeof(tshared_memory))==0){
        cmp_res =0;
    }else{
        cmp_res =1;
    }
    /* Change Semaphore to GREEN */
    Operation.sem_op =1;
    /* Set the Semaphore to GREEN */
    semop (Id_Semaphore,&Operation,1);
    return cmp_res;
}
/***********************************************************************/
/* Name: hmi_copy_data
* Brief: Function to copy data structures (shared memory to valid
data)
* Author: Raul Camacho
* Param: tshared_memory*
* Return: void
*/
void hmi_copy_data(tshared_memory* valid_data){
    DLT_LOG(hmi_context,DLT_LOG_INFO,DLT_STRING(__FUNCTION__),DLT_STRING("function called"));
    /* Change Semaphore to RED */
    Operation.sem_op =-1;
    /* Set the Semaphore to RED */
    semop (Id_Semaphore,&Operation,1);
    /* update Can values - shared memory values to valid data struct */
    memcpy(valid_data, ptr_Can_Data,sizeof(tshared_memory));
    /* Change Semaphore to GREEN */
    Operation.sem_op =1;
    /* Set the Semaphore to GREEN */
    semop (Id_Semaphore,&Operation,1);
}
/***********************************************************************/
