#include<stdio.h>
#define MAX 25
int parent[MAX],n;

//find
int find(int i)
{
    while(parent[i]!=i)
    i=parent[i];
    return i;
}

//union
void unionset(int a,int b)
{
    int rootA=find(a);
    int rootB=find(b);
    if(rootA==rootB)
    {
        printf("Already in same set");
        return;
    }
    else
    {
        parent[rootB]=rootA;
        printf("Union done between %d and %d",a,b);
    }
}

//make set
int makeset()
{
    for(int i=0;i<n;i++)
    parent[i]=i;
}

//Display
void display()
{
    printf("Elements      : ");
    for(int i=0;i<n;i++)
    printf("%d ",i);
    printf("\nRepresntatives: ");
    for(int i=0;i<n;i++)
    printf("%d ",parent[i]);
    
}


int main()
{
    int a,b,i,ch;
    printf("Enter number of elements: ");
    scanf("%d",&n);

    //creating set
    makeset();

    do
    {
        printf("\n1.find\n2.union\n3.display\n4.exit\nEnter choice: ");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:printf("Enter element to find(0 to %d):",n-1);
                    scanf("%d",&a);
                    printf("Representative of %d is %d",a,find(a));
                    break;
            case 2:printf("Enter 2 elements to union: ");
                    scanf("%d%d",&a,&b);
                    unionset(a,b);
                    break;
            case 3:display();
                    break;
            case 4:printf("Exiting...");
                    break;
            default:printf("Invalid input");
        }
    }while(ch!=4);
    return 0;
}
