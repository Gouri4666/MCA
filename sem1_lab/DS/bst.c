#include<stdio.h>
#include<stdlib.h>

struct node{
    int data;
    struct node *right;
    struct node *left;
};

void insertion();
void deletion();
void preorder();
void inorder();
void postorder();
void preorderTraversal(struct node *node);
void inorderTraversal(struct node *node);
void postorderTraversal(struct node *node);

struct node *root;

int main()
{
    int ch,cont;
    do
    {
    printf("1.insertion\n2.Deletion\n3.Preorder\n4.Inorder\n5.postorder\n");
    printf("Enter choice: ");
    scanf("%d",&ch);
    switch(ch)
    {
        case 1:insertion();
            break;
        case 2:deletion();
            break;
        case 3:preorder();
            break;
        case 4:inorder();
            break;
        case 5:postorder();
            break;
        default:printf("Invalid choice");
    }
    printf("\n1 / 0: ");
    scanf("%d",&cont);
    }
    while(cont==1);
    return 0;
}
void insertion()
{
    struct node *newnode=NULL,*parent=NULL,*current=NULL;
    int value;

    printf("Enter value to insert: ");
    scanf("%d",&value);
    newnode=(struct node *)malloc(sizeof(struct node));
    newnode->data=value;
    newnode->right=newnode->left=NULL;

    if(root==NULL)
    {//insert as root node
        root=newnode;
        printf("%d inserted as root node",value);
        return;
    }

    parent=NULL;
    current=root;
    while(current!=NULL)
    {
        parent=current;

        if(value<parent->data)
        {
            current=parent->left;
        }
        else
        current=parent->right;
    }
    //inserting

    if(value<parent->data)//left of parent
    {
    parent->left=newnode;
    printf("%d inserted to the left of %d",value,parent->data);
    }

    else
    {
    parent->right=newnode;//right of parent
    printf("%d inserted to the right of %d",value,parent->data);
    }
}
void deletion()
{
    struct node *current=NULL,*parent=NULL,*child=NULL;
    if(root==NULL)
    {
        printf("Deletion not possible");
        return;
    }

    int value;
    printf("Enter value to delete: ");
    scanf("%d",&value);

    parent=NULL;
    current=root;
    while(current!=NULL && current->data!=value)//***IMP***/
    {
        parent=current;
        if(value<parent->data)
        current=parent->left;
        else
        current=parent->right;
    }


    if(current==NULL)
    {
        printf("Value not found");
        return;
    }

    //case 1:no child
    if(current->left==NULL && current->right==NULL)
    {
        if(current==root)
        {
            root=NULL;
            printf("Node deleted");
            return;
        }
        if(parent->left==current)
        {
            parent->left=NULL;
        }
        else
        parent->right=NULL;
        printf("Node deleted");
        free(current);
    }


    //case 2:1 child
    else if(current->left==NULL || current->right==NULL)
    {
        if(current->left!=NULL)
        child=current->left;//child in left

        else
        child=current->right;//child in tight

        if(current==root)//if root node to delete
        {
            root=child;//replace root with child
            free(current);
        }

        else
        {
            if(parent->left==current)
            parent->left=child;
            else
            parent->right=child;
            printf("node deleted");
            free(current);
        }
    }


    //case 3 :both child
    else
    {
        struct node *s=current->right;
        struct node *sp=current;
        while(s->left!=NULL)
        {
            sp=s;
            s=s->left;
        }

        //replace
        current->data=s->data;
        
        //delete sucessor
        if(sp->left==s)
        sp->left=s->right;
        else
        sp->right=s->right;
        printf("Node deleted");
        free(s);
    }
}
void preorder()
{
    if(root==NULL)
    {
        printf("Empty");
        return;
    }
    printf("Preorder Traversal: ");
    preorderTraversal(root);
}
void inorder()
{
    if(root==NULL)
    {
        printf("Empty");
        return;
    }
    printf("Inorder Traversal: ");
    inorderTraversal(root);
}
void postorder()
{
    if(root==NULL)
    {
        printf("Empty");
        return;
    }
    printf("Postorder Traversal: ");
    postorderTraversal(root);
}
void preorderTraversal(struct node *node)
{
    if(node ==NULL)
    return;
    else
    {
        printf("%d ",node->data);
        preorderTraversal(node->left);
        preorderTraversal(node->right);
    }
}
void inorderTraversal(struct node *node)
{
    if(node ==NULL)
    return;
    else
    {
        inorderTraversal(node->left);
        printf("%d ",node->data);
        inorderTraversal(node->right);
    }
}
void postorderTraversal(struct node *node)
{
    if(node ==NULL)
    return;
    else
    {
        postorderTraversal(node->left);
        postorderTraversal(node->right);
        printf("%d ",node->data);
    }
}