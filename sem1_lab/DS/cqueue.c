#include<stdio.h>
#include<stdlib.h>
# define N 50
int cq[N];
int f=-1,r=-1;
void enqueue()
{
    int item;
    if((f==0 && r==N-1) || f==(r+1)%N)
    printf("Overflow");
    else
    {
        printf("Enter item to insert: ");
        scanf("%d",&item);
        if(f==-1)
        {
            f=r=0;
            cq[r]=item;
        }
        else
        {
            r=(r+1)%N;
            cq[r]=item;
        }
        printf("%d inserted",item);
    }
}
void dequeue()
{
    int item;
    if(f==-1)
    printf("Queue is empty");
    else
    {
         if(f==r)
        {
            item=cq[f];
            f=r=-1;
        }
        else
        {
            item=cq[f];
            f=(f+1)%N;
        }
        printf("%d deleted",item);
    }
}
void display()
{
    if(f==-1)
    printf("queue is empty");
    else
    {
        int i=f;
        printf("Queue elements: ");
        while(1)
        {
            printf("%d ",cq[i]);
            if(i==r)
            break;
            i=(i+1)%N;
        }
    }
}
void count()
{
    int c=0;
    if(f!=-1)
    {
        if(r>=f)
        c=r-f+1;
        else
        c=N-f+r+1;
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
}
