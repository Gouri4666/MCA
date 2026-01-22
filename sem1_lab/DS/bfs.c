//bfs
#include<stdio.h>
#include<conio.h>
#define MAX 25
int queue[MAX];
int f=-1;
int r=-1;
void enqueue(int val)
{
    if(r==MAX-1)
    {
    printf("FUll");
    return;
    }
    else
    {
        if(f==-1)
        f=0;
        queue[++r]=val;
    }
}
int dequeue()
{
    if(f==-1 || f>r)
    return -1;
    else
    return queue[f++];
}
int main()
{
    int i,j,n,e,u,v,adj[MAX+1][MAX+1]={0},visited[MAX+1]={0},start;
    printf("Enter number of vertices: ");
    scanf("%d",&n);
    printf("Enter number of edges: ");
    scanf("%d",&e);
    printf("Enter edges(u-v):\n");
    for(i=0;i<e;i++)
    {
        scanf("%d%d",&u,&v);
        adj[u][v]=1;
        adj[v][u]=1;
    }
    printf("Enter starting vertex: ");
    scanf("%d",&start);
    enqueue(start);
    visited[start]=1;
    printf("BFS:\n");
    while((i=dequeue())!=-1)
    {
        printf("%d ",i);
        for(j=1;j<=n;j++)
        {
            if(adj[i][j]==1 && visited[j]==0)
            {
                enqueue(j);
                visited[j]=1;
            }
        }
    }
    return 0;
}
