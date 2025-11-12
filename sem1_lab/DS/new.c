#include <stdio.h>
#include <stdlib.h>

// Node structure
struct node 
{
    int data;
    struct node *left;
    struct node *right;
};

struct node *root = NULL;

// Function declarations
void insertion();
void deleteN();
void preorder();
void inorder();
void postorder();
void inorderTraversal(struct node* node);
void preorderTraversal(struct node* node);
void postorderTraversal(struct node* node);

// Main function
int main()
{
    int choice, cont;

    do {
        printf("\n--- Binary Tree Operations ---\n");
        printf("1. Insertion\n");
        printf("2. Deletion\n");
        printf("3. Inorder Traversal\n");
        printf("4. Preorder Traversal\n");
        printf("5. Postorder Traversal\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
            case 1: insertion(); break;
            case 2: deleteN(); break;
            case 3: inorder(); break;
            case 4: preorder(); break;
            case 5: postorder(); break;
            default: printf("Invalid choice!\n");
        }

        printf("\nDo you want to continue? (1 = Yes / 0 = No): ");
        scanf("%d", &cont);
    } while (cont == 1);

    printf("Exiting program!\n");
    return 0;
}

void insertion()
{
    int item;
    int parent,found=0,direction;
    struct node *newnode,*temp;
    printf("Enter item to insert: ");
    newnode=(struct node *)malloc(sizeof(struct node));
    scanf("%d",&newnode->data);
    newnode->right=NULL;
    newnode->left=NULL;

    if(root==NULL)
    {
        root=newnode;
        printf("%d inserted as rooot node",root->data);
        return;
    }
    printf("Enter parnet node: ");
    scanf("%d",&parent);
    struct node *queue[50];
    int f=0,r=0;
    queue[r]=root;
    while(f<=r)
    {
        temp=queue[f++];
        if(temp->data==parent)
        {
            found=1;
            printf("where to insert\n\t1.Left\n\t2.Right\nEnter choice: ");
            scanf("%d",&direction);
            if(direction==1)
            {
                if(temp->left==NULL)
                {
                    temp->left=newnode;
                   printf("%d inserted to left of %d",newnode->data,temp->data);
                   return;
                }
                else
                {
                    printf("%d is already filled",temp->data);
                    free(newnode);
                }
            }
            else if(direction==2)
            {
                if(temp->right==NULL)
                {
                    temp->right=newnode;
                    printf("%d inserted to right of %d",newnode->data,temp->data);
                }
                else
                {
                    printf("right of %d is filled",temp->data);
                    free(newnode);
                }
            }
            else
            {
                printf("Invalid choice!");
                return;
            }
        }
        if(temp->left)
        queue[++r]=temp->left;
        if(temp->right)
        queue[++r]=temp->right;
    }
    if(!found)
    {
        printf("SUch parent doesn't exist");
        return;
    }
}
void deleteN()
{
    int key;
    if(root==NULL)
    {
        printf("Tree is empty");
        return;
    }
    printf("Enter item to delete: ");
    scanf("%d",&key);
    int found=0;
    while(1)
    {
        if(root==NULL)
        break;
        struct node *queue[25];
        int f=0,r=0;
        queue[r]=root;

        struct node *temp = NULL;
        struct node *keyNode = NULL;
        struct node *lastNode = NULL;
        struct node *parentOfLast = NULL;
        while(f<=r)
        {
            temp=queue[f++];
            if(temp->data==key && keyNode==NULL)
            keyNode=temp;
            if(temp->left)
            {
                parentOfLast=temp;
                queue[++r]=temp->left;
            }
            if(temp->right)
            {
                parentOfLast=temp;
                queue[++r]=temp->right;
            }
            lastNode=temp;
        }
        if(keyNode==NULL)
        break;
        keyNode->data=lastNode->data;
        printf("Deleted");
        if(lastNode==root)
        {
            free(root);
            root=NULL;
        }
        else if(parentOfLast)
        {
            if(parentOfLast->left==lastNode)
            {
                parentOfLast->left=NULL;
            }
            else if(parentOfLast->right==lastNode)
            {
                parentOfLast->right=NULL;
            }
            free(lastNode);
        }
        found=1;
    }
    if(!found)
    printf("Deletion not posiible");
    else
    printf("Deleted sucesfully");
}
void preorder()
{
        if(root==NULL) 
        printf("Empty");
        else
        {
            printf("Preorder: ");
            preorderTraversal(root);
        }
}
void inorder()
{
        if(root==NULL) 
        printf("Empty");
        else
        {
            printf("inorder: ");
            inorderTraversal(root);
        }
}
void postorder()
{
        if(root==NULL) 
        printf("Empty");
        else
        {
            printf("inorder: ");
            postorderTraversal(root);
        }   
}
void inorderTraversal(struct node* node)
{
    if(node==NULL) return;
    printf("%d ",node->data);
    inorderTraversal(node->left);
    inorderTraversal(node->right);    
}
void preorderTraversal(struct node* node)
{
    if(node==NULL) return;
    preorderTraversal(node->left);
    printf("%d ",node->data);
    preorderTraversal(node->right);
}
void postorderTraversal(struct node* node)
{
    if(node==NULL) return;
    postorderTraversal(node->left);
    postorderTraversal(node->right);  
    printf("%d ",node->data);
 
}
