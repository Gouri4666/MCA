#include<stdio.h>
#define N 20
int queue[N];
int front=-1;
int rear=-1;
void enqueue(int value)
{
    if(rear==N-1)
    {
        printf("Overflow");
        return;
    }
    if(front==-1)
    front=0;
    queue[++rear]=value;
}

int dequeue()
{
    if(front==-1 || front>rear)
    return -1;
    else
    return queue[front++];
}
int main()
{
    int i,j,u,v,start;
    int adj[N][N]={0};
    int visited[N]={0};
    int n,e;
    printf("Enter number of vertex:");
    scanf("%d",&n);
    printf("Enter number of edges: ");
    scanf("%d",&e);
    printf("Enter u v:\n");
    for(i=0;i<e;i++)
    {
        scanf("%d%d",&u,&v);
        adj[u][v]=1;
        adj[v][u]=1;
    }
    printf("Enter start:");
    scanf("%d",&start);
    enqueue(start);
    visited[start]=1;
    printf("BFS traversal:");
    while((i=dequeue())!=-1)
    {
        printf("%d ",i);
        for(j=0;j<n;j++)
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