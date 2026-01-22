#include<stdio.h>
#include<stdlib.h>
void printbitstring(int bitset[],int size)
{
    for(int i=0;i<size;i++)
    printf("%d ",bitset[i]);
    printf("\n");
}
void printdecimalset(int bitset[],int size)
{
    printf("{ ");
    for(int i=0;i<size;i++)
    {
        if(bitset[i]==1)
        printf("%d ",i);
    }
    printf("}\n");
}
int main()
{
    int na,nb,maxelements=-1,i;

    //enter first set

    printf("Enter na:");
    scanf("%d",&na);
    int *setAelements=(int *)malloc(na*sizeof(int));
    printf("Enter %d elements: ",na);
    for(i=0;i<na;i++)
    {

        scanf("%d",&setAelements[i]);
        //calculate max boundary
        if(setAelements[i]>maxelements)
        maxelements=setAelements[i];
    }

    //enter second set
    printf("Enter nb:");
    scanf("%d",&nb);
    int *setBelements=(int *)malloc(nb*sizeof(int));
    printf("Enter %d elements: ",nb);
    for(i=0;i<nb;i++)
    {
        scanf("%d",&setBelements[i]);
        //calculate max boundary
        if(setBelements[i]>maxelements)
        maxelements=setBelements[i];
    }

    //allocate bit string
    int size=maxelements+1;

    int *bitA=(int *)calloc(size,sizeof(int));
    int *bitB=(int *)calloc(size,sizeof(int));
    int *bitDifference=(int *)calloc(size,sizeof(int));
    int *bitUnion=(int *)calloc(size,sizeof(int));
    int *bitIntersection=(int *)calloc(size,sizeof(int));

    //set bit
    for(int i=0;i<na;i++)
    bitA[setAelements[i]]=1;
    for(int i=0;i<nb;i++)
    bitB[setBelements[i]]=1;
    
    int ch,cont;
    do
    {
        printf("\n\tMenu\n\t1.Display\n\t2.Union\n\t3.Intersection\n\t4.Difference\n");
        printf("Enter choice: ");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:
            
                printf("SetA elements: ");
                printdecimalset(bitA,size);
                printf("SetB elements: ");
                printdecimalset(bitB,size);
                printf("SetA bit representation: ");
                printbitstring(bitA,size);
                printf("SetB bit representation: ");
                printbitstring(bitB,size);
                
                break;
            case 2:

                for(int i=0;i<size;i++)
                bitUnion[i]=bitA[i]|bitB[i];
                printf("Union of set: ");
                printdecimalset(bitUnion,size);

                break;
            case 3:

                for(int i=0;i<size;i++)
                bitIntersection[i]=bitA[i]&bitB[i];
                printf("Intersection of set: ");
                printdecimalset(bitIntersection,size);

                    break;
            case 4:
                //A-B
                for(int i=0;i<size;i++)
                bitDifference[i]=bitA[i]&(~bitB[i]);
                printf("Difference of set(a-b): ");
                printdecimalset(bitDifference,size);
                //B-A
                for(int i=0;i<size;i++)
                bitDifference[i]=bitB[i]&(~bitA[i]);
                printf("Difference of set(b-a): ");
                printdecimalset(bitDifference,size);
                                
                break;
            default:printf("Invalid choice!");
                break;
        }
        printf("\nContinue or exit(1/0) : ");
        scanf("%d",&cont);
    }while(cont==1);
    
    return 0;

}