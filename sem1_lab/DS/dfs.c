//dfs
#include<stdio.h>
#include<conio.h>
#define MAX 25
int stack[MAX];
int top=-1;
void push(int val)
{
    if(top==MAX-1)
    printf("full");
    else

    stack[++top]=val;
}
int pop()
{
    if(top==-1)
    return -1;
    else
    return stack[top--];
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
    push(start);
    visited[start]=1;
    printf("DFS:\n");
    while((i=pop())!=-1)
    {
        printf("%d ",i);
        for(j=n;j>=1;j--)
        {
            if(adj[i][j]==1 && visited[j]==0)
            {
                push(j);
                visited[j]=1;
            }
        }
    }
    return 0;
}