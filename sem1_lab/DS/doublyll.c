//doublt ll
#include<stdio.h>
#include<stdlib.h>
struct node 
{
    int data;
    struct node *left;
    struct node *right;
};
struct node *start=NULL,*tail=NULL,*ptr=NULL,*prev=NULL,*temp=NULL,*newnode=NULL;
void insert_beg();
void insert_pos();
void insert_end();
void display();
void delete_beg();
void delete_pos();
void delete_end();
int count();
int main()
{
    int i,n,value;
    printf("enter n:");
    scanf("%d",&n);
    printf("Enter %d elemenst: ",n);
    for(i=1;i<=n;i++)
    {
        scanf("%d",&value);
        newnode=(struct node *)malloc(sizeof(struct node));
        newnode->data=value;
        newnode->left=NULL;
        newnode->right=NULL;
        if(start==NULL)
        {
            start=newnode;
            ptr=newnode;
            tail=newnode;
        }
        else
        {
            ptr->right=newnode;
            newnode->left=ptr;
            ptr=ptr->right;
            tail=newnode;
        }
    }
    printf("List created");
    int ch,cont;
    do
    {
        printf("\n--Doubly Linked List Menu--\n\t1. Insert at beginnig\n\t2. Insert at position\n\t3. Insert at end\n\t4.Display\n\t5.Delete at beginning\n\t6.Delete at position\n\t7.Delete at end\n\t8.Count\n");
        printf("Enter choice: ");
        scanf("%d",&ch);
        switch (ch)
        {
        case 1:
            insert_beg();
            break;
        case 2:
            insert_pos();
            break;
        case 3:
            insert_end();
            break;
        case 4:display();
            break;
        case 5:delete_beg();
            break;
        case 6:delete_pos();
            break;
        case 7:delete_end();
            break;
        case 8:printf("Count: %d",count());
            break;
            
        default:printf("Invalid choice!");
            break;
        }
        printf("\nDo you want to continue(Yes-1 / No-0): ");
        scanf("%d",&cont);
    }
    while(cont==1);
    return 0;
}

void insert_beg()
{
    int value;
    printf("enter value to insert:");
    scanf("%d",&value);
    newnode=(struct node *)malloc(sizeof(struct node));
    newnode->data=value;
    newnode->left=NULL;
    newnode->right=NULL;
    if(start==NULL)//insert as start
    {
        start=newnode;
        tail=newnode;
    }
    else
    {
        newnode->right=start;
        start->left=newnode;
        start=newnode;
    }
    printf("%d inserted at beginning",value);
}
void insert_pos()
{
    int pos, value, i;
    int c = count();
    struct node *newnode, *temp;

    printf("Enter position to insert: ");
    scanf("%d", &pos);

    printf("Enter value to insert: ");
    scanf("%d", &value);

    if(pos < 1 || pos > c + 1)
    {
        printf("Invalid position\n");
        return;
    }

    /* Insert at beginning */
    if(pos == 1)
    {
        insert_beg();
        return;
    }

    /* Insert at end */
    if(pos == c + 1)
    {
        insert_end();
        return;
    }

    /* Insert at middle */
    newnode = (struct node *)malloc(sizeof(struct node));
    if(newnode == NULL)
    {
        printf("Memory allocation failed\n");
        return;
    }

    newnode->data = value;

    temp = start;
    for(i = 1; i < pos - 1; i++)
    {
        temp = temp->right;
    }

    newnode->right = temp->right;
    newnode->left = temp;

    temp->right->left = newnode;
    temp->right = newnode;

    printf("%d inserted at position %d\n", value, pos);
}

void insert_end()
{
    int value;
    printf("enter value to insert:");
    scanf("%d",&value);
    newnode=(struct node *)malloc(sizeof(struct node));
    newnode->data=value;
    newnode->left=NULL;
    newnode->right=NULL;
    if(start==NULL)
    {
        start=newnode;
        tail=newnode;
    }
    else
    {
        tail->right=newnode;
        newnode->left=tail;
        tail=newnode;
    }
    printf("%d inserted at end",value);

}
void display()
{
    if(start==NULL)
    {
        printf("empty");
    }
    else
    {
        ptr=start;
        printf("Forward Traversal: ");
        while(ptr!=NULL)
        {
            printf("%d ",ptr->data);
            ptr=ptr->right;
        }
        ptr=tail;
        printf("\nBackward Traversal: ");
        while(ptr!=NULL)
        {
            printf("%d ",ptr->data);
            ptr=ptr->left;
        }
    }
}
void delete_beg()
{
    int value;
    if(start==NULL)
    printf("Deletion not possible");
    else
    {
        value=start->data;
        if(start==tail)//one only element
        {
            start=NULL;
            tail=NULL;
        }
        else
        {
            ptr=start;
            start=start->right;
            start->left=NULL;
            ptr->right=NULL;
            free(ptr);
        }
    }
    printf("%d deleted from beginnng",value);
}
void delete_pos()
{
    int pos, value, i;
    int c = count();
    struct node *temp;

    if(start == NULL)
    {
        printf("Deletion not possible\n");
        return;
    }

    printf("Enter position to delete: ");
    scanf("%d", &pos);

    if(pos < 1 || pos > c)
    {
        printf("Invalid position\n");
        return;
    }

    /* delete first node */
    if(pos == 1)
    {
        delete_beg();
        return;
    }

    /* delete last node */
    if(pos == c)
    {
        delete_end();
        return;
    }

    /* delete middle node */
    temp = start;
    for(i = 1; i < pos; i++)
    {
        temp = temp->right;
    }

    value = temp->data;

    temp->left->right = temp->right;
    temp->right->left = temp->left;

    free(temp);

    printf("%d deleted from position %d\n", value, pos);
}

void delete_end()
{
    int value;
    if(tail==NULL)
    printf("Deletion not possible");
    else
    {
        value=tail->data;
        if(start==tail)//one only element
        {
            start=NULL;
            tail=NULL;
        }
        else
        {
            ptr=tail;
            tail=tail->left;
            tail->right=NULL;
            ptr->left=NULL;
            free(ptr);

        }
        printf("%d deleted from end",value);

    }
}
int count()
{
    int c=0;
    if(start!=NULL)
    {
        ptr=start;
        while(ptr!=NULL)
        {
            ptr=ptr->right;
            c++;
        }
    }
    return c;
}