#include <stdio.h>
#define MAX 100

int parent[MAX];
int elements[MAX];
int n;

// Function to create n disjoint sets
void makeSet() 
{
    for (int i = 0; i < n; i++)
        parent[i] = i; // each element is its own parent
}


// Function to find the index of an element in the elements array
int getIndex(int x) {
    for (int i = 0; i < n; i++) {
        if (elements[i] == x)
            return i;
    }
    return -1; // element not found
}


// Function to find the representative of the set containing x
int find(int x) 
{
    if (parent[x] == x)
        return x;
    else
        return find(parent[x]); // recursive call
}

// Function to unite two sets
void unionSets(int x, int y) 
{
    int rootX = find(x);
    int rootY = find(y);

    if (rootX == rootY) 
    {
        printf("Both elements are already in the same set.\n");
        return;
    }

    parent[rootY] = rootX; // make one root parent of another
    printf("Union done: %d and %d are now in the same set.\n", elements[x], elements[y]);
}

// Function to display the current parent relationships
void displaySets() 
{
    printf("\nElement : ");
    for (int i = 0; i < n; i++)
        printf("%d ", elements[i]);

    printf("\nParent  : ");
    for (int i = 0; i < n; i++)
        printf("%d ", elements[parent[i]]);
    printf("\n");
}

// Main function
int main() 
{
    int choice, a, b, idxA, idxB;
    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++)
        scanf("%d", &elements[i]);

    makeSet();

    do {
        printf("\n--- Disjoint Set Operations ---\n");
        printf("1. Union\n");
        printf("2. Find\n");
        printf("3. Display Sets\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter two elements to union: ");
                scanf("%d %d", &a, &b);
                idxA = getIndex(a);
                idxB = getIndex(b);
                if (idxA == -1 || idxB == -1)
                    printf("One or both elements not found!\n");
                else
                    unionSets(idxA, idxB);
                break;

            case 2:
                printf("Enter element to find its set representative: ");
                scanf("%d", &a);
                idxA = getIndex(a);
                if (idxA == -1)
                    printf("Element not found!\n");
                else
                    printf("Representative of %d is: %d\n", a, elements[find(idxA)]);
                break;

            case 3:
                displaySets();
                break;

            case 4:
                printf("Exiting...\n");
                break;

            default:
                printf("Invalid choice!\n");
        }
    } while (choice != 4);

    return 0;
}
