#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

sem_t mutex;   // semaphore

// Critical Section
void critical_section(int thread) {
    printf("Thread %d is in critical section\n", thread);
    sleep(1);  // delay for visibility
}

// Thread function
void *process(void *arg) {
    int thread = *((int *)arg);

    sem_wait(&mutex);   // wait (enter CS)

    critical_section(thread);

    sem_post(&mutex);   // signal (exit CS)

    return NULL;
}

int main() {
    pthread_t t1, t2;
    int a = 1, b = 2;

    sem_init(&mutex, 0, 1);  // initialize semaphore (1 = free)

    pthread_create(&t1, NULL, process, &a);
    pthread_create(&t2, NULL, process, &b);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    sem_destroy(&mutex);  // destroy semaphore

    return 0;
}

// output
// Thread 2 is in critical section
// Thread 1 is in critical section
