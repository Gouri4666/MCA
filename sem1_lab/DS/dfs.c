#include <stdio.h>
#define MAX 20

int stack[MAX];
int top = -1;

void push(int value) 
{
    if (top == MAX - 1) 
    {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = value;
}

int pop() 
{
    if (top == -1)
        return -1;
    return stack[top--];
}

int main() 
{
    int n, edges;
    int adj[MAX][MAX] = {0};
    int visited[MAX] = {0};
    int start, u, v, i, j;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &edges);

    printf("Enter edges (format: u v):\n");
    for (i = 0; i < edges; i++) {
        scanf("%d %d", &u, &v);
        adj[u][v] = 1;   // For undirected graph
        adj[v][u] = 1;   // Remove this line if directed
    }

    printf("Enter starting vertex (0 to %d): ", n - 1);
    scanf("%d", &start);

    push(start);
    visited[start] = 1;

    printf("\nDFS Traversal: ");

    while ((i = pop()) != -1) {
        printf("%d ", i);

        for (j = n - 1; j >= 0; j--) { 
            if (adj[i][j] == 1 && visited[j] == 0) {
                push(j);
                visited[j] = 1;
            }
        }
    }

    return 0;
}
