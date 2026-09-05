//sll
#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
     struct node *next;
};
struct node *start=NULL,*ptr=NULL,*newnode=NULL,*prev=NULL;


void insert_beg();
void insert_pos();
void insert_end();
void delete_beg();
void delete_pos();
void delete_end();
void display();
int count();
int main()
{
    int ch,cont,i,n,val;
    printf("Enter n: ");
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
        printf("Enter element %d: ",i);
        scanf("%d",&val);
        newnode=(struct node *)malloc(sizeof(struct node));
        newnode->data=val;
        newnode->next=NULL;
        if(start==NULL)
        {
            start=newnode;
            ptr=newnode;
        }
        else
        {
            ptr->next=newnode;
            ptr=newnode;
        }
    }
    printf("Elements inserted\n");

    do
    {
        printf("\n\t1.Insert at beginnimg\n\t2.Insert at position\n\t3.Insert at end\n\t4.Delete at beginning\n\t5.Delete at position\n\t6.Delete at end\n\t7.Display\n\t8.count\n");
        printf("\nEnter your choice:");
        scanf("%d",&ch);
        switch(ch)
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
            case 4:
                delete_beg();
                break;
            case 5:
                delete_pos();
                break;
            case 6:
                delete_end();
                break;
            case 7:
                display();
                break;
            case 8:
                count();
                break;
            default:
                printf("\nInvalid choice");
    
        }
        printf("\nDo you want to continue(1/0):");
        scanf("%d",&cont);
    }while(cont==1);
    return 0;
}
void insert_beg()
{
    int value;
    printf("Enter value to insert: ");
    scanf("%d",&value);
    newnode=(struct node *)malloc(sizeof(struct node));
    newnode->data=value;
    newnode->next=NULL;
    if(start==NULL)
    {
        start=newnode;
        ptr=newnode;
    }
    else
    {
        newnode->next=start;
        start=newnode;
    }
    printf("%d inserted at beginning",start->data);
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
            printf("\nEnter element: ");
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
            printf("Inserted at position %d",pos);
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
    int value;
    printf("Enter value to insert: ");
    scanf("%d",&value);
    newnode=(struct node *)malloc(sizeof(struct node));
    newnode->data=value;
    newnode->next=NULL;
    if(start==NULL)
    {
        start=newnode;
    }
    else
    {
        ptr=start;
        while(ptr->next!=NULL)
        {
            ptr=ptr->next;
        }
        ptr->next=newnode;
    }
    printf("%d inserted as end",newnode->data);
}
void delete_beg()
{
    int value;
    if(start==NULL)
    {
        printf("deletion not possible");
    }
    else
    {
        value=start->data;
        if(start->next==NULL)
        {
            start=NULL;
        }
        else
        {
            ptr=start;
            start=start->next;
            ptr->next=NULL;
            free(ptr);
        }
    printf("%d deleted from beginning",value);
    }
}
void delete_pos()
{
    struct node *prev;
    int pos,val;
    int c=count();
    if(start==NULL)
    {
    printf("List is empty");
    return;
    }
    printf("\nEnter position to delete: ");
    scanf("%d",&pos);
    if(pos>=1 && pos<=c)
    {
        ptr=start;
        for(int i=1;i<=pos-1;i++)
        {
            prev=ptr;
            ptr=ptr->next;
        }
        val=ptr->data;
        prev->next=ptr->next;
        free(ptr);
        printf("%d deleted from position %d",val,pos);
    }
    else
    printf("Invalid position!");

}
void delete_end()
{
    int val;
    if(start==NULL)
    {
        printf("Deletion not possible");
    }
    else
    {
        if(start->next==NULL)
        {
            val=start->data;
            start=NULL;
        }
        else
        {
            ptr=start;
            prev=ptr;
            while(ptr->next!=NULL)
            {
                prev=ptr;
                ptr=ptr->next;
            }
            val=ptr->data;
            prev->next=NULL;
            free(ptr);
        }
        printf("%d deleted from end",val);
    }
}
void display()
{
    if(start==NULL)
    {
        printf("E,pty list");
    }
    else
    {
        ptr=start;
        printf("Elements in the list are: ");
        while(ptr!=NULL)
        {
            printf("%d ",ptr->data);
            ptr=ptr->next;
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
            ptr=ptr->next;
            c++;
        }
        printf("\nNumber of elements in the list: %d",c);
    }
    return c;

}