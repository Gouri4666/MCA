#include<stdio.h>
#include<stdlib.h>
int n,uniondone=0;
int *setA,*setB,*setC,*unionset,nu;
void display()
{
    int i;
    printf("Display sets:\n");
    printf("Set A: ");
    for(i=0;i<n;i++)
    printf("%d ",setA[i]);
    printf("\nSet B: ");
    for(i=0;i<n;i++)
    printf("%d ",setB[i]);
    printf("\nSet C: ");
    for(i=0;i<n;i++)
    printf("%d ",setC[i]);
    
}
void unionsets()
{
    
    int i;
    nu=0;
    unionset=(int *)malloc((2*n)*sizeof(int));
    for(i=0;i<n;i++)
    {
        unionset[nu++]=setA[i];
    }
    for(i=0;i<n;i++)
    {
        unionset[nu++]=setB[i];
    }
    uniondone=1;
    printf("\nUnion set: ");
    printf("{ ");
    for(i=0;i<nu;i++)
    printf("%d ",unionset[i]);
    printf(" }");
    
}
void find()
{
    int elem, found = 0;

    printf("Enter element to find: ");
    scanf("%d", &elem);

    if(uniondone == 1)
    {
        for(int i = 0; i < nu; i++)
        {
            if(unionset[i] == elem)
            {
                found = 1;
                break;
            }
        }

        if(found)
            printf("Representative: %d\n", unionset[0]);
        else
            printf("Element not found\n");
    }
    else
    {
        /* Check in Set A */
        for(int i = 0; i < n; i++)
        {
            if(setA[i] == elem)
            {
                found = 1;
                break;
            }
        }

        if(found)
        {
            printf("Representative: %d\n", setA[0]);
            return;
        }

        /* Reset found before checking Set C */
        found = 0;

        for(int i = 0; i < n; i++)
        {
            if(setC[i] == elem)
            {
                found = 1;
                break;
            }
        }

        if(found)
            printf("Representative: %d\n", setC[0]);
        else
            printf("Element not found\n");
    }
}

int main()
{
    int i,j;
    //enter set a
    printf("Enter number of elements: ");
    scanf("%d",&n);
    setA=(int *)malloc(n*sizeof(int));
    printf("Enter %d elements of set A: ",n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&setA[i]);
    }

    //enter set b
    setB=(int *)malloc(n*sizeof(int));
    printf("Enter %d elements of set B: ",n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&setB[i]);
    }


    //display
    printf("Display sets:\n");
    printf("Set A: ");
    for(i=0;i<n;i++)
    printf("%d ",setA[i]);
    printf("\nSet B: ");
    for(i=0;i<n;i++)
    printf("%d ",setB[i]);

    //add setA and setB
    setC=(int *)malloc(n*sizeof(int));
    for(i=0;i<n;i++)
    {
        setC[i]=setA[i]+setB[i];
    }

    //display set C
    printf("\nset C: ");
    for(i=0;i<n;i++)
    {
        printf("%d ",setC[i]);
    }
    
    //main
    int cont,ch;
    do
    {
        printf("\n\tMENU\n");
        printf("\t1.Display\n\t2.Union\n\t3.Find\n");
        printf("Enter choice: ");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:display();
                break;
            case 2:unionsets();
                break;
            case 3:find();
                break;
            default:printf("Invalid choice");
                break;
        }
        printf("\nContinue: ");
        scanf("%d",&cont);
    }while(cont==1);
    return 0;
}