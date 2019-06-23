#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

void fnDisplay(struct node *head){
    struct node *cur;
    int count=0;
    if(head==NULL){
        printf("List is empty\n");
        return;
    }
    cur=head;
    printf("Elements of linked list are : ");
    do{
        printf("%d\t",cur->data);
        cur=cur->next;
        count++;
    }while(cur!=head);
    printf("\nTotal no of elements are : %d\n",count);
}

void insertAtEnd(struct node **head,int data){
    struct node *newNode,*cur;
    newNode=(struct node *)malloc(sizeof(struct node));
    if(!newNode){
        printf("Memory Error\n");
        return;
    }
    newNode->data=data;
    newNode->next=newNode;
    if(*head){  
        cur=*head;
        while(cur->next!=*head)
                cur=cur->next;
        cur->next=newNode;
        newNode->next=*head;
    }
    else
        *head=newNode;
}

void insertAtFront(struct node **head,int data){
    struct node *cur,*newNode;
    newNode=(struct node *)malloc(sizeof(struct node));
    if(!newNode){
        printf("Memory error\n");
        return;
    }
    newNode->data=data;
    newNode->next=newNode;
    if(*head){
        cur=*head;
        while(cur->next!=*head)
            cur=cur->next;
        newNode->next=*head;
        cur->next=newNode;
    }
        *head=newNode;
}

void deleteLastNode(struct node **head){
    struct node *cur,*prev;
    if(*head==NULL){
        printf("List is empty\n");
        return;
    }
    if(*head){
        prev=*head;
        cur=*head;
        while(cur->next!=*head){
            prev=cur;
            cur=cur->next;
        }
        prev->next=*head;
        free(cur);
    }
}

void deleteFirstNode(struct node **head){
    struct node *first,*cur;
    if(*head==NULL){
        printf("List is empty\n");
        return;
    }
    if(*head){
        first=*head;
        cur=*head;
        while(cur->next!=*head)
            cur=cur->next;
        cur->next=first->next;
        *head=first->next;
        free(first);
    }
}

int main()
{
    int data,choice;
    struct node *head=malloc(sizeof(struct node));
    if(!head){
        printf("Memory error \n");
        return 0;
    }
    head=NULL;
    while(1){
        printf("Choose operation : 1.Insert at end 2.Insert at front 3.Delete at end 4.Delete at front 5.Display\n");
        scanf("%d",&choice);
        switch (choice)
        {
        case 1: printf("Enter data : ");
                scanf("%d",&data);
                insertAtEnd(&head,data);
                break;
        case 2: printf("Enter data : ");
                scanf("%d",&data);
                insertAtFront(&head,data);
                break;
        case 3: deleteLastNode(&head);
                break;
        case 4: deleteFirstNode(&head);
                break;
        case 5: fnDisplay(head);
                break;
        default: printf("Invalid input\n");
                 break;
        }
    }
    return 0;
}