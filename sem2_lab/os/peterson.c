#include <stdio.h>
#include <pthread.h>

int flag[2] = {0, 0};
int turn;

// Critical Section
void critical_section(int process) 
{
    printf("Process %d is in critical section\n", process);
}

// Process 0
void *process0(void *arg) {
    for (int i = 0; i < 5; i++) {
        flag[0] = 1;
        turn = 1;

        while (flag[1] && turn == 1);

        critical_section(0);

        flag[0] = 0;
    }
    return NULL;
}

// Process 1
void *process1(void *arg) {
    for (int i = 0; i < 5; i++) {
        flag[1] = 1;
        turn = 0;

        while (flag[0] && turn == 0);

        critical_section(1);

        flag[1] = 0;
    }
    return NULL;
}

int main() {
    pthread_t t1, t2;

    pthread_create(&t1, NULL, process0, NULL);
    pthread_create(&t2, NULL, process1, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    return 0;
}

// output
// Process 0 is in critical section
// Process 0 is in critical section
// Process 1 is in critical section
// Process 0 is in critical section
// Process 1 is in critical section
// Process 0 is in critical section
// Process 1 is in critical section
// Process 0 is in critical section
// Process 1 is in critical section
// Process 1 is in critical section
