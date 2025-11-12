#include <stdio.h>

#define MAX 100

int parent[MAX];

// Function to find parent (with path compression)
int find(int i) 
{
    while (parent[i] != i)
        i = parent[i];
    return i;
}

// Function to unite two sets
void unionSets(int i, int j) 
{
    parent[i] = j;
}

int main() 
{
    int u[MAX], v[MAX], w[MAX];
    int n, e, i, j;
    int mincost = 0;

    printf("Enter number of vertices: ");
    scanf("%d", &n);
    printf("Enter number of edges: ");
    scanf("%d", &e);

    printf("Enter edges (u v cost):\n");
    for (i = 0; i < e; i++)
        scanf("%d%d%d", &u[i], &v[i], &w[i]);

    // Sort edges by cost (simple bubble sort)
    for (i = 0; i < e - 1; i++) 
    {
        for (j = 0; j < e - i - 1; j++) 
        {
            if (w[j] > w[j + 1]) 
            {
                int temp = w[j]; w[j] = w[j + 1]; w[j + 1] = temp;
                temp = u[j]; u[j] = u[j + 1]; u[j + 1] = temp;
                temp = v[j]; v[j] = v[j + 1]; v[j + 1] = temp;
            }
        }
    }

    // Initialize parent array
    for (i = 1; i <= n; i++)
        parent[i] = i;

    printf("\nEdges in Minimum Spanning Tree:\n");

    int count = 0;
    i = 0;
    while (count < n - 1 && i < e) 
    {
        int a = find(u[i]);
        int b = find(v[i]);

        if (a != b) 
        {
            printf("%d - %d : %d\n", u[i], v[i], w[i]);
            mincost += w[i];
            count++;
            unionSets(a, b);
        }
        i++;
    }

    printf("\nTotal Minimum Cost = %d\n", mincost);
    return 0;
}
