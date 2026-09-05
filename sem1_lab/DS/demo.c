#include <stdio.h>
#include <stdlib.h>

struct node 
{
	int data;
	struct node *left;
	struct node *right;
};

struct Queue
{
    int front,rear;
    struct node *data[100];
};


struct node *root=NULL;
void insertion();
void deleteN();
void preorder();
void inorder();
void postorder();
void inorderTraversal(struct node* node);
void preorderTraversal(struct node* node);
void postorderTraversal(struct node* node);

int main() {
    int choice, cont;

    do {
        printf("\n--- Binary Tree Operations ---\n");
        printf("1. insertion\n");
        printf("2. Delete\n");
        printf("3. Inorder Traversal\n");
        printf("4. Preorder Traversal\n");
        printf("5. Postorder Traversal\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
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
    int parent,direction,found=0;
    struct node *temp=NULL,*newnode=NULL;

    printf("Enter value to insert: ");
    newnode=(struct node *)malloc(sizeof(struct node));
    scanf("%d",&newnode->data);
    newnode->left=newnode->right=NULL;

    if(root==NULL)
    {
        root=newnode;
        printf("%d inserted as root",newnode->data);
        return;
    }
    printf("Enter parent value: ");
    scanf("%d",&parent);

    struct node *queue[100];
    int front=0,rear=0;
    queue[rear]=root;
    while(front<=rear)
    {
        temp=queue[front++];
        if(temp->data==parent)
        {
            found=1;
            printf("Where to insert\n\t1.Left\n\t2.Right\nEnter choice: ");
            scanf("%d",&direction);
            if(direction==1)
            {
                if(temp->left==NULL)
                {
                    temp->left=newnode;
                    printf("%d inserted to the left of %d",newnode->data,parent);
                    return;
                }
                printf("Left node of %d is occupied",parent);
                return;
            }
            else if(direction==2)
            {
                if(temp->right==NULL)
                {
                    temp->right=newnode;
                    printf("%d inserted to the right of %d",newnode->data,parent);
                    return;
                }
                printf("Right node of %d is occupied",parent);
                return;
            }
            else
            {
                printf("Invalid choice");
                free(newnode);
            }    
        }
        if(temp->left)
        queue[++rear]=temp->left;
        if(temp->right)
        queue[++rear]=temp->right;
    }
    if(!found)
        {
            printf("parent not found");
            free(newnode);
        }
}
void deleteN()
{

}

void inorder()
 {
	if (root == NULL)
 	{
        	printf("Tree is empty.\n");
        	return;
  	}
    	printf("Inorder: ");
	inorderTraversal(root);
	printf("\n");
}

void preorder() 
{
	if (root == NULL) 
	{
        	printf("Tree is empty.\n");
	        return;
    	}
	printf("Preorder: ");
	preorderTraversal(root);
	printf("\n");
}

void postorder() 
{
	if (root == NULL)
 	{
        	printf("Tree is empty.\n");
	        return;
    	}
	printf("Postorder: ");
	postorderTraversal(root);
	printf("\n");
}

// Traversals
void inorderTraversal(struct node* node) 
{
    	if (node == NULL) return;
	inorderTraversal(node->left);
	printf("%d ", node->data);
	inorderTraversal(node->right);
}
void preorderTraversal(struct node* node) 
{
    if (node == NULL) return;
    printf("%d ", node->data);
    preorderTraversal(node->left);
    preorderTraversal(node->right);
}
void postorderTraversal(struct node* node) 
{
    if (node == NULL) return;
    postorderTraversal(node->left);
    postorderTraversal(node->right);
    printf("%d ", node->data);
}