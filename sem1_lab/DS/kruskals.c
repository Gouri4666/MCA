//kruskals
#include<stdio.h>
#include<conio.h>
#define MAX 25
int parent[MAX];

int find(int i)
{
    while(parent[i]!=i)
    i=parent[i];
    return i;
}

void union_set(int i,int j)
{
    parent[i]=j;
}

int main()
{
    int i,j,u[MAX],v[MAX],w[MAX],e,n,mincost=0;
    printf("Enter number of vertices: ");
    scanf("%d",&n);
    printf("Enter number of edges: ");
    scanf("%d",&e);


    //enter all u v w
    printf("Enter u-v-w:\n");
    for(i=0;i<e;i++)
    {
        scanf("%d%d%d",&u[i],&v[i],&w[i]);
    }


    //buble sort
    for(i=0;i<e-1;i++)
    {
        for(j=0;j<e-i-1;j++)
        {
            if(w[j]>w[j+1])
            {
                int temp=w[j];w[j]=w[j+1];w[j+1]=temp;
                temp=u[j];u[j]=u[j+1];u[j+1]=temp;
                temp=v[j];v[j]=v[j+1];v[j+1]=temp;
            }
        }
    }


    //initialise parent array
    for(i=1;i<=n;i++)
    parent[i]=i;


    int count=0;
    i=0;
    printf("MCST:\n");
    while(i<e && count<n-1)
    {
        int a=find(u[i]);
        int b=find(v[i]);
        if(a!=b)
        {
            printf("%d - %d : %d\n",u[i],v[i],w[i]);
            mincost+=w[i];
            count++;
            union_set(a,b);
        }
        i++;
    }
    printf("Mincost: %d",mincost);
}