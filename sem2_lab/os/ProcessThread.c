#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
void* fun1(void* arg) {
    printf("Thread 1 is running in PID = %d\n", getpid());
    return 0;
}
void* fun2(void* arg) {
    printf("Thread 2 is running in PID = %d\n", getpid());
    return 0;
}
int main() {
    pthread_t t1, t2;
    int pid;
    pid = fork();  // Create a new process
    if (pid == 0) {
        printf("Child process created. PID = %d\n", getpid());
        pthread_create(&t1, NULL, fun1, NULL);
        pthread_create(&t2, NULL, fun2, NULL);
        pthread_join(t1, NULL);
        pthread_join(t2, NULL);
        printf("Child process ends\n");
    } 
    else {
        printf("Parent process created. PID = %d\n", getpid());
        pthread_create(&t1, NULL, fun1, NULL);
        pthread_create(&t2, NULL, fun2, NULL);
        pthread_join(t1, NULL);
        pthread_join(t2, NULL);
        printf("Parent process ends\n");
    }

    return 0;
}
