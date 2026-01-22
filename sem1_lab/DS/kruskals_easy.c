#include <stdio.h>
#include <stdlib.h>
#define MAX 10

int parent[MAX];
int cost[MAX][MAX];

int find(int i)
{
    while (parent[i] != i)
        i = parent[i];
    return i;
}

int uni(int i, int j)
{
    if (i != j)
    {
        parent[j] = i;
        return 1;
    }
    return 0;
}

int main()
{
    int i, j, n;
    int v1, v2, u, v;
    int edge = 1;
    int c = 0, mincost = 0;

    printf("Enter total number of vertices: ");
    scanf("%d", &n);

    printf("Enter the cost adjacency matrix:\n");
    for (i = 1; i <= n; i++)
    {
        for (j = 1; j <= n; j++)
        {
            scanf("%d", &cost[i][j]);
            if (cost[i][j] == 0)
                cost[i][j] = 9999;  // replace 0 edges with large value
        }
    }

    // Initialize parent array
    for (i = 1; i <= n; i++)
        parent[i] = i;

    printf("\nEdges in MST:\n");

    while (edge < n)
    {
        c = 9999;

        // Find the smallest cost edge
        for (i = 1; i <= n; i++)
        {
            for (j = 1; j <= n; j++)
            {
                if (cost[i][j] < c)
                {
                    c = cost[i][j];
                    v1 = i;
                    v2 = j;
                }
            }
        }

        u = find(v1);
        v = find(v2);

        if (uni(u, v))
        {
            printf("%d -> %d  cost = %d\n", v1 - 1, v2 - 1, c);
            edge++;
            mincost += c;
        }

        cost[v1][v2] = cost[v2][v1] = 9999; // Remove selected edge
    }

    printf("\nMinimum cost = %d\n", mincost);

    return 0;
}