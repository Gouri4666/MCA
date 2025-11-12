#include <stdio.h>
#define MAX 20

int queue[MAX];
int front = -1, rear = -1;

void enqueue(int value) {
    if (rear == MAX - 1) 
    {
        printf("Queue Overflow\n");
        return;
    }
    if (front == -1)
        front = 0;
    queue[++rear] = value;
}

int dequeue() {
    if (front == -1 || front > rear) 
        return -1;
    return queue[front++];
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
    for (i = 0; i < edges; i++) 
    {
        scanf("%d %d", &u, &v);
        adj[u][v] = 1;    // For undirected graph
        adj[v][u] = 1;    // Remove this line if directed
    }

    printf("Enter starting vertex (0 to %d): ", n - 1);
    scanf("%d", &start);

    enqueue(start);
    visited[start] = 1;

    printf("\nBFS Traversal: ");

    while ((i = dequeue()) != -1) 
    {
        printf("%d ", i);

        for (j = 0; j < n; j++) 
        {
            if (adj[i][j] == 1 && visited[j] == 0) 
            {
                enqueue(j);
                visited[j] = 1;
            }
        }
    }

    return 0;
}
