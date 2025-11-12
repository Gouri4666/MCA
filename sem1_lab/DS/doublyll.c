#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next;
    struct node *prev;
};
struct node *newnode,*ptr,*temp,*start=NULL,*tail;
struct node* create()
{
    printf("Enter item to insert: ");
    newnode=(struct node *)malloc(sizeof(struct node));
    scanf("%d",&newnode->data);
    newnode->prev=newnode->next=NULL;
    return newnode;
}
void display()
{
    if(start==NULL)
    printf("List is empty");
    else
    {
        ptr=start;
        printf("Display forward: ");
        while(ptr!=NULL)
        {
            printf("%d ",ptr->data);
            ptr=ptr->next;
        }
        printf("\nDisplay backward: ");
        ptr=tail;
        while(ptr!=NULL)
        {
            printf("%d ",ptr->data);
            ptr=ptr->prev;
        }
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
            c++;
            ptr=ptr->next;
        }
    }
    return c;
}
void insert_beg()
{
    create();
    if(start==NULL)//insert as first node
    {
        start=newnode;
        tail=newnode;
    }
    else
    {
        newnode->next=start;
        start->prev=newnode;
        start=newnode;
        printf("%d inserted at beginning",start->data);
    }
}
void insert_end()
{
    create();
    if(tail==NULL)
    start=tail=newnode;
    else
    {
        newnode->prev=tail;
        tail->next=newnode;
        tail=newnode;
    }
    printf("%d inserted at end",tail->data);
}

void insert_pos()
{
    int pos;
    int c=count();
    printf("Enter position to insert: ");
    scanf("%d",&pos);
    if(start!=NULL)
    {
    if(pos==c+1)
    insert_end();
    else if(pos==1)
    insert_beg();
    else if(pos>1 && pos<=c)
        {
            create();
            ptr=start;
            temp=start;
            for(int i=1;i<=pos-1;i++)
            {
                temp=ptr;
                ptr=ptr->next;
            }
            temp->next=newnode;
            newnode->prev=temp;
            newnode->next=ptr;
            ptr->prev=newnode;
            printf("%d inserted",newnode->data);
        }
        else
        {
            printf("Invalid position");
        }
    }
    else
    printf("Insertion not possible");
}
void delete_beg()
{
    if(start==NULL)
    printf("List is empty");
    else{
        int item=start->data;
        if(start==tail)
        {
            start->next=start->prev=NULL;
            start=tail=NULL;
        }
        ptr=start;
        start=start->next;
        ptr->next=ptr->prev=NULL;
        start->prev=NULL;
        free(ptr);
        printf("%d deleted at beginning",item);
    }
}
void delete_end()
{
    if(tail==NULL)
    {
        printf("Deletion not possible");
    }
    else
    {
        ptr=tail;
        int item=tail->data;
        if(start==tail)
        {
            start->prev=start->next=NULL;
            free(start);
            start=tail=NULL;
        }
        else
        {
            ptr=tail;
            tail=tail->prev;
            tail->next=NULL;
            ptr->prev=ptr->next=NULL;
            free(ptr);
        }
        printf("%d deleted",item);
        
    }
}
void delete_pos()
{
    int pos,item;
    struct node *ptr,*temp;
    if(start==NULL)
    printf("Deletion not possible");
    else
    {
        printf("Enter position of node to delete: ");
        scanf("%d",&pos);
        int c=count();
        if(pos==1)
        delete_beg();
        else if(pos==c)
        delete_end();
        else
        {
            if(pos>1 && pos<c)
            {
                ptr=start;
                for(int i=1;i<=pos-1;i++)
                {
                    temp=ptr;
                    ptr=ptr->next;
                }
                temp->next=ptr->next;
                ptr->next->prev=temp;
                free(ptr);
                printf("node delted");
            }
            else
            {
                printf("Invalid position");
                return;
            }
        }
    }
}
int main()
{
    int val,n;
    printf("Enter n: ");
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        printf("Enter element %d: ",i+1);
        scanf("%d",&val);
        newnode=(struct node *)malloc(sizeof(struct node));
        newnode->data=val;
        newnode->next=newnode->prev=NULL;
        if(start==NULL)
        {
            start=newnode;
            tail=newnode;
            ptr=newnode;
        }
        else
        {
            tail=newnode;
            newnode->prev=ptr;
            ptr->next=newnode;
            ptr=ptr->next;
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
    
}