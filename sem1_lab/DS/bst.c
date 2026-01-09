//bst
#include<stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node *right;
    struct node *left;
};
struct node *root=NULL;
void insertion();
void deletion();
void preorder();
void inorder();
void postorder();
void preorderTraversal(struct node *node);
void inorderTraversal(struct node *node);
void postorderTraversal(struct node *node);

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
    int value;
    struct node *current,*parent,*newnode;
    printf("Enter value to insert: ");
    scanf("%d",&value);
    newnode=(struct node *)malloc(sizeof(struct node));
    newnode->data=value;
    newnode->right=newnode->left=NULL;
    if(root==NULL)
    {
        root=newnode;
        printf("Value inserted as root node");
        return;
    }
    parent=NULL;
    current=root;
    while(current!=NULL)
    {
        parent=current;
        if(value<current->data)
        current=current->left;
        else
        current=current->right;
    }
    if(value<parent->data)
    parent->left=newnode;
    else
    parent->right=newnode;
    printf("Value inserted");
}
void deletion()
{
    int value;
    struct node *current,*parent,*child;
    printf("Enter value to delete:");
    scanf("%d",&value);
    if(root==NULL)
    {
        printf("Tree is empty");
        return;
    }
   current=root;
   parent=NULL;
   while(current!=NULL && current->data!=value)
   {
        parent=current;
        if(value<current->data)
        current=current->left;
        else
        current=current->right;
   }
   if(current==NULL)
   {
    printf("Value not found");
    return;
   }
   //case:1
   if(current->left==NULL && current->right==NULL)
   {
        if(current==root)
        {
            root=NULL;
        }
        else
        {
        if(current==parent->left)
        parent->left=NULL;
        else
        parent->right=NULL;
        free(current);
        }
   }
   else if(current->left==NULL || current->right==NULL)
   {
        if(current->left!=NULL)
        child=current->left;
        else
        child=current->right;
        if(current==root)
        {
            root=child;
        }
        else
        {
            if(parent->left==current)
            parent->left=child;
            else
            parent->right=child;
        }
   }
   else
   {
        struct node *s=current->right;
        struct node *sp=current;
        while(s->left!=NULL)
        {
            sp=s;
            s=s->left;
        }
        current->data=s->data;
        if(sp->left==s)
        sp->left=current->right;
        else
        sp->right=current->right;
        free(s);
   }
   printf("node deleted");

}
void preorder()
{
    if(root==NULL)
    {
        printf("Empty");
        return;
    }
    printf("Preorder Traversal:");
    preorderTraversal(root);
}
void inorder()
{
    if(root==NULL)
    {
        printf("Empty");
        return;
    }
    printf("Inorder Traversal:");
    inorderTraversal(root);
}
void postorder()
{
    if(root==NULL)
    {
        printf("Empty");
        return;
    }
    printf("Postorder Traversal:");
    postorderTraversal(root);
}
void preorderTraversal(struct node *node)
{
    if(node==NULL)
    return;
    printf("%d ",node->data);
    preorderTraversal(node->left);
    preorderTraversal(node->right);
}
void inorderTraversal(struct node *node)
{
    if(node==NULL)
    return;
    inorderTraversal(node->left);
    printf("%d ",node->data);
    inorderTraversal(node->right);
}
void postorderTraversal(struct node *node)
{
    if(node==NULL)
    return;
    postorderTraversal(node->left);
    postorderTraversal(node->right);
    printf("%d ",node->data);
}
