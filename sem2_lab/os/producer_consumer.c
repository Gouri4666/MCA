#include <stdio.h>

int main() {
    int size, in = 0, out = 0;
    int empty, full = 0, mutex = 1;
    int buffer[20];   // max size
    int choice, item;
    printf("Enter buffer size: ");
    scanf("%d", &size);
    empty = size;
    while (1) {
        printf("\n1. Produce  2. Consume  3. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);
        if (choice == 1) 
        {
            if (mutex == 1 && empty != 0) 
            {
                printf("Enter item: ");
                scanf("%d", &item);
                buffer[in] = item;
                printf("Produced %d\n", item);
                in = (in + 1) % size;
                empty--;
                full++;
            } 
            else 
            {
                printf("Buffer Full!\n");
            }
        }
        else if (choice == 2) {
            if (mutex == 1 && full != 0) {
                item = buffer[out];
                printf("Consumed %d\n", item);

                out = (out + 1) % size;
                full--;
                empty++;
            } else {
                printf("Buffer Empty!\n");
            }
        }
        else 
            break;
    }
    return 0;
}

// output
// Enter buffer size: 2

// 1. Produce  2. Consume  3. Exit
// Enter choice: 1
// Enter item: 10
// Produced 10

// 1. Produce  2. Consume  3. Exit
// Enter choice: 1
// Enter item: 20
// Produced 20

// 1. Produce  2. Consume  3. Exit
// Enter choice: 1
// Buffer Full!

// 1. Produce  2. Consume  3. Exit
// Enter choice: 3
