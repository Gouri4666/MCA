#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int parent[MAX];

// Function to find the parent (with path compression)
int find(int i) {
    while (parent[i] != i)
        i = parent[i];
    return i;
}

// Function to perform union of two sets
void unionSets(int i, int j) {
    int a = find(i);
    int b = find(j);
    parent[a] = b;
}

int main() 
{
    int u[MAX], v[MAX], cost[MAX];
    int n, e; // n = number of vertices, e = number of edges
    int costMatrix[MAX][MAX] = {0};
    int i, j, k;
    int mincost = 0;

    printf("Enter the number of vertices: ");
    scanf("%d", &n);
    printf("Enter the number of edges: ");
    scanf("%d", &e);

    printf("Enter edges (u v cost):\n");
    for (i = 0; i < e; i++) 
    {
        scanf("%d%d%d", &u[i], &v[i], &cost[i]);
        // Build adjacency matrix
        costMatrix[u[i]][v[i]] = cost[i];
        costMatrix[v[i]][u[i]] = cost[i];
    }

    // Sort edges by cost (Simple bubble sort)
    for (i = 0; i < e - 1; i++) 
    {
        for (j = 0; j < e - i - 1; j++) 
        {
            if (cost[j] > cost[j + 1])
            {
                // Swap cost
                int temp = cost[j];
                cost[j] = cost[j + 1];
                cost[j + 1] = temp;

                // Swap u
                temp = u[j];
                u[j] = u[j + 1];
                u[j + 1] = temp;

                // Swap v
                temp = v[j];
                v[j] = v[j + 1];
                v[j + 1] = temp;
            }
        }
    }

    // Initialize each vertex as its own parent
    for (i = 1; i <= n; i++)
        parent[i] = i;

    printf("\nAdjacency Matrix:\n");
    for (i = 1; i <= n; i++) 
    {
        for (j = 1; j <= n; j++) 
        {
            printf("%d\t", costMatrix[i][j]);
        }
        printf("\n");
    }

    printf("\nEdges in the Minimum Cost Spanning Tree:\n");

    int edgeCount = 0;
    i = 0;
    while (edgeCount < n - 1 && i < e) {
        int setU = find(u[i]);
        int setV = find(v[i]);

        if (setU != setV) 
        {
            printf("Edge %d: (%d -> %d) cost = %d\n", edgeCount + 1, u[i], v[i], cost[i]);
            mincost += cost[i];
            edgeCount++;
            unionSets(setU, setV);
        }
        i++;
    }

    printf("\nMinimum cost of spanning tree = %d\n", mincost);

    return 0;
}
