#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next;
};
struct  node *start=NULL,*ptr,*temp,*newnode;
void insertion();
void deletion();
void traversal();
int count();
void createnew();
int main()
{
    int ch,cont,n;
    printf("Enter n: ");
    scanf("%d",&n);
    for (int i = 0; i < n; i++)
    {
        printf("Enter element %d: ",i+1);
        newnode=(struct node *)malloc(sizeof(struct node));
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
        printf("\n1.Insertion\n2.Deletion\n3.Traversal\n4.Count\nEnter your choice: ");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:insertion();
                break;
            case 2:deletion();
                break;
            case 3:traversal();
                break;
            case 4:printf("Count: %d",count());
                break;
            default:printf("Invalid choice");
                break;
        }
        printf("\nDo you wnat to continue: "); 
        scanf("%d",&cont);
    } while (cont==1);
    
    
}
void createnew()
{
    printf("Enter item: ");
    newnode=(struct node *)malloc(sizeof(struct node));
    scanf("%d",&newnode->data);
    newnode->next=NULL;
}
void insertion()
{
    int pos,item;
    printf("Enter position to insert: ");
    scanf("%d",&pos);
    int c=count();
    if(pos>=1 && pos<=c+1)
    {
        createnew();
        int item=newnode->data;
        if(pos==1)
        {//insert at beg
          if(start==NULL)
          {
            start=newnode;
          }
          else
          {
            newnode->next=start;
            start=newnode;
          }
        }
        else if(pos==c+1)
        {
            if(start==NULL)
            printf("insertion not possible");
            else
            {
                ptr=start;
                while(ptr->next!=NULL)
                ptr=ptr->next;
                ptr->next=newnode;
            }
        }
        else
        {
            if(start==NULL)
            printf("Insertin not possible");
            else
            {
                ptr=start;
                for(int i=1;i<=pos-1;i++)
                {
                    temp=ptr;
                    ptr=ptr->next;
                }
                temp->next=newnode;
                newnode->next=ptr;
            }
        }
        printf("%d inserted",item);
    }
    else
    {
        printf("Invalid position!");
        return;
    }
}
void deletion()
{
    int item;
    printf("Enter item to delete: ");
    scanf("%d",&item);
    if(start==NULL)
    {
        printf("List is empty");
        return;
    }
    ptr=start;
    if(ptr->data==item)
        {
            start=start->next;
            printf("%d deleted",item);
            return;
        }
    while(ptr!=NULL && ptr->data!=item)
    {
        temp=ptr;
        ptr=ptr->next;
    }
    if(ptr==NULL)
    {
            printf("Item not found");
            return;
    }
    temp->next=ptr->next;
    printf("%d deleted",item);
}
void traversal()
{
    if(start==NULL)
    {
        printf("List is empty");
    }
    else
    {
        ptr=start;
        printf("Traversal of list: ");
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
            c+=1;
            ptr=ptr->next;
        }
    }
    return c;
}