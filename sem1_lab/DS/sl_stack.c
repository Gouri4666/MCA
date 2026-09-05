#include <stdio.h>
#include <stdlib.h>

// Node structure
struct Node {
    int data;
    struct Node* next;
};

// Top pointer of stack
struct Node* top = NULL;

// Push function
void push(int value) 
{
    struct Node* newNode;
    newNode = (struct Node*)malloc(sizeof(struct Node));

    newNode->data = value;
    newNode->next = top; // new node points to current top
    top = newNode;       // update top
    printf("%d pushed\n", value);
}

// Pop function
void pop() 
{
    struct Node* temp;
    if (top == NULL) 
    {
        printf("Stack is empty\n");
        return;
    }
    temp = top;
    int item = temp->data;
    top = top->next;   // move top to next node
    free(temp);        // free popped node
    printf("%d popped\n", item);
}

// Display stack
void display() {
    if (top == NULL) {
        printf("Stack is empty\n");
        return;
    }
    struct Node* ptr = top;
    printf("Stack elements (top to bottom): ");
    while (ptr != NULL) {
        printf("%d ", ptr->data);
        ptr = ptr->next;
    }
    printf("\n");
}

// Main function
int main() {
    int choice, value, cont;
    do {
        printf("\n--Singly Linked Stack MENU--\n");
        printf("1. Push\n2. Pop\n3. Display\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to push: ");
                scanf("%d", &value);
                push(value);
                break;
            case 2:
                pop();
                break;
            case 3:
                display();
                break;
            default:
                printf("Invalid choice\n");
        }

        printf("Do you want to continue? (1/0): ");
        scanf("%d", &cont);
    } while (cont == 1);

    return 0;
}
