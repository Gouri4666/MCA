//circular queue
#include<stdio.h>
#include<stdlib.h>
#define MAX 25
int queue[MAX];
int f=-1;
int r=-1;
void enqueue()
{
    if((f==0 && r==MAX-1) || f==(r+1)%MAX)
    {
        printf("Full");
        return;
    }
    int value;
    printf("Enter value to insert: ");
    scanf("%d",&value);
    if(f==-1)
    {
        f=r=0;
        queue[r]=value;
    }
    else
    {   
        r=(r+1)%MAX;
        queue[r]=value;
    }
    printf("Value inserted");
}
void dequeue()
{
    int item;
    if(f==-1)
    {
        printf("Empty");
        return;
    }
    else
    {
        item=queue[f];

        if(f==r)
        {
            f=r=-1;
        }
        else
        {
            f=(f+1)%MAX;
        }
        printf("%d deleted",item);
    }
}
void display()
{
    if(f!=-1)
    {
        int i=f;
        printf("Elements: ");
        while(1)
        {
            printf("%d ",queue[i]);
            if(i==r)
            break;
            i=(i+1)%MAX;
        }
    }
    else
    printf("empty");
}
void count()
{
    int c=0;
    if(f!=-1)
    {
        if(r>=f)
        {
            c=r-f+1;
        }
        else
        c=MAX-f+r+1;
    }
    printf("Count: %d",c);
}
int main() 
{
    int choice, value, cont;
    do {
        printf("\n--Circular Queue MENU--\n");
        printf("1. Enqueu\n2. Dequeue\n3. Display\n4. Count\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:enqueue();
                break;
            case 2:
                dequeue();
                break;
            case 3:
                display();
                break;
            case 4:count();
                break;
            default:
                printf("Invalid choice\n");
        }

        printf("\nDo you want to continue? (1/0): ");
        scanf("%d", &cont);
    } while (cont == 1);
    return 0;
}
