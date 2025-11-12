#include <stdio.h>
#include <stdlib.h>
void insert_beg();
void insert_pos();
void insert_end();
void delete_beg();
void delete_pos();
void delete_end();
void traversal();
int count();
void item();
struct node
{
    int data;
    struct node *next;
};
struct node *newnode,*start,*ptr;

int main()
{//singly list list
    int ch,cont,n,i;
    start=NULL,ptr=NULL;
    printf("Enter n: ");
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
        newnode=(struct node *)malloc(sizeof(struct node));
        printf("Enter element %d: ",i);
        scanf("%d",&newnode->data);
        newnode->next=NULL; 
        if(start==NULL)
        {
            start=newnode;
            ptr=newnode;
        }
        else
        {
            ptr->next=newnode;
            ptr=ptr->next;
        }
    }
    printf("List created");
    do
    {
        
        printf("\n\t--Singly Linked LIst-MENU\n\t1.Insertion at beginning\n\t2.Insertion at position\n\t3.Insertion at end\n\t4.Delete from beginning\n\t5.Delete from a position\n\t6.Delete from end\n\t7.Traversal\n\t8.Count\n\t9.Delete from item\n");
        printf("Enter choice: ");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:insert_beg();
                break;
            case 2:insert_pos();
                break;
            case 3:insert_end();
                break;
            case 4:delete_beg();
                break;
            case 5:delete_pos();
                break;
            case 6:delete_end();
                break;
            case 7:traversal();
                break;
            case 8:printf("Count: %d",count());
                break;
            case 9:item();
                break;
            default:printf("Invalid choicw!");
        }
        printf("\nContinue or exit (Yes-1 / No-0): ");
        scanf("%d",&cont);
    } 
    while (cont==1);
    return 0;
}

void insert_beg()
{
    newnode=(struct node *)malloc(sizeof(struct node));
    printf("Enter element: ");
    scanf("%d",&newnode->data);
    newnode->next=NULL;
    newnode->next=start;
    start=newnode;
    ptr=start;

}
void insert_pos()
{
    int pos;
   
    if(start!=NULL)
    {
        printf("Enter position to insert: ");
        scanf("%d",&pos);
        int c=count();
        if(pos>=1 && pos<=c+1)
        {
            if(pos==1)
            insert_beg();
            else
            {
            newnode=(struct node *)malloc(sizeof(struct node));
            printf("Enter element: ");
            scanf("%d",&newnode->data);
            newnode->next=NULL;
            ptr=start;

            for(int i=1;i<=pos-2;i++)
            {
                ptr=ptr->next;
            }
            newnode->next=ptr->next;
            ptr->next=newnode;
            ptr=start;   
        }
        }
        else
        printf("Insertion not possible, invalid position");
    }
    else{
        printf("list empty");
    }
}
void insert_end()
{
        newnode=(struct node *)malloc(sizeof(struct node));
        printf("Enter element to insert: ");
        scanf("%d",&newnode->data);
        newnode->next=NULL;
        ptr=start;
        while(ptr->next!=NULL)
        ptr=ptr->next;
        ptr->next=newnode;
        ptr=start;
}
void delete_beg()
{
    if(start==NULL)
    {
        printf("List is empty");
        return;
    }
    ptr=start;
    start=start->next;
    printf("First node deleted");    
}
void delete_pos()
{
    struct node *prev;
    int pos;
    int c=count();
    if(start==NULL)
    {
    printf("List is empty");
    return;
    }
    printf("Enter position to delete: ");
    scanf("%d",&pos);
    if(pos>=1 && pos<=c)
    {
        ptr=start;
        for(int i=1;i<=pos-1;i++)
        {
            prev=ptr;
            ptr=ptr->next;
        }
        prev->next=ptr->next;
        free(ptr);
    }
    else
    printf("Invalid position!");
}

void delete_end()
{
    struct node *prev;
    if(start==NULL)
    {
        printf("Empty");
        return;
    }
    if(start->next==NULL)
    {
    start=NULL;
    free(start);
    return;
    }
    ptr=start;
    while(ptr->next!=NULL)
    {
        prev=ptr;
        ptr=ptr->next;
    }
    prev->next=NULL;
    free(ptr);
    printf("Node deleted");
}
void item()
{
    int item,found=0;
    struct node *prev;
    if(start==NULL)
    {
        printf("list is empty");
        return;
    }
    printf("Enter item to delete: ");
    scanf("%d",&item);
    ptr=start;
    if(start->data==item)
    {
        start=start->next;
        found=1;
        free(ptr);
    }
     prev=start;
    ptr=start->next;
    while(ptr!=NULL)
    {
       
        if(ptr->data==item)
        {
        found=1;
        prev->next=ptr->next;
        ptr=ptr->next;
        continue;
        }
        prev=ptr;
        ptr=ptr->next;
    }
    if(found)
    printf("item deleted");
    else
    printf("item not found");
}
void traversal()
{
    ptr=start;
    printf("Traversal of list: ");
        while(ptr!=NULL)
        {
         printf("%d ",ptr->data);
         ptr=ptr->next;
        }   
}
int count()
{
    int count=0;
    ptr=start;
    while(ptr!=NULL)
    {
        count++;
        ptr=ptr->next;
    }
    return count;
}