#include<stdio.h>
#define MAX 20
#define INF 9999
int main()
{
    int i,j,k,l,n,e,u,v,w;
    int t[MAX][2],cost[MAX][MAX],mincost=0,min,near[MAX];
    printf("Enter vertices: ");
    scanf("%d",&n);
    printf("Enter edges: ");
    scanf("%d",&e);

    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
        {
            if(i==j)
            cost[i][j]=0;
            else
            cost[i][j]=INF;
        }
    }
    printf("Enter u v w:\n");
    for(i=1;i<=e;i++)
    {
        scanf("%d %d %d",&u,&v,&w);
        cost[u][v]=w;
        cost[v][u]=w;
    }

    min=INF;
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
        {
            if(cost[i][j]!=0 && cost[i][j]<min)
            {
                min=cost[i][j];
                k=i;
                l=j;
            }
        }
    }
    t[1][1]=k;
    t[1][2]=l;
    mincost=cost[k][l];

    for(i=1;i<=n;i++)
    {
        if(cost[i][l]<cost[i][k])
        near[i]=l;
        else
        near[i]=k;
    }
    near[k]=near[l]=0;

    for(i=2;i<=n-1;i++)
    {
        min=INF;
        for(j=1;j<=n;j++)
        {
            if(near[j]!=0 && cost[j][near[j]]<min)
            {
                min=cost[j][near[j]];
                k=j;
            }
        }
        t[i][1]=k;
        t[i][2]=near[k];
        mincost+=cost[k][near[k]];
        near[k]=0;
        for(j=1;j<=n;j++)
        {
            if(near[k]!=0 && cost[j][near[j]]>cost[j][k])
            {
                near[j]=k;
            }
        }

    }
    printf("Min cost edges:\n");
    for(i=1;i<=n-1;i++)
    {
        printf("%d-%d:%d",t[i][1],t[i][2],cost[t[i][1]][t[i][2]]);
    }
    printf("Min cost=%d",mincost);
    return 0;
}