#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

void fnLength(struct node *head){
    struct node *temp;
    int count=0;
    if(head==NULL){
        printf("List is empty");
        return;
    }
    temp=head;
    while(temp!=NULL){
        temp=temp->next;
        count++;
    }
    printf("No of elements are %d \n",count);
}

void fnInsertAtPosition(struct node **head,int data,int position){
    int k=1;
    struct node *cur=*head,*prev,*newNode;
    newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data=data;
    if(!newNode){
        printf("Memory error\n");
        return;
    }
    if(position==1){
        newNode->next=cur;
        *head=newNode;
        return;
    }
    else{
        while(cur!=NULL && k<position){
            k++;
            prev=cur;
            cur=cur->next;
    }
    if(k!=position){
        printf("Position doesn't exist\n");
        return;
    }
    prev->next=newNode;
    newNode->next=cur;
    return;
    }
}

void fnDeleteAtPosition(struct node **head,int position){
    struct node *prev,*cur=*head;
    int k=1;
    if(*head==NULL){
        printf("List is empty\n");
        return;
    }
    if(position==1){
        *head=cur->next;
        free(cur);
        return;
    }
    else{
        while(k<position && cur!=NULL){
            k++;
            prev=cur;
            cur=cur->next;
        }
        if(cur==NULL){
            printf("position doesn't exist\n");
            return;
        }
        else{
            prev->next=cur->next;
            free(cur);
        }
    }
}

void fnDisplay(struct node *head){
    struct node *cur=head;
    if(head==NULL){
        printf("List is empty\n");
        return;
    }
    printf("Content of linked list are : \n");
    while(cur!=NULL){
        printf("%d\n",cur->data);
        cur=cur->next;
    }
}

int main()
{
    int choice,position,data;
    struct node *head=malloc(sizeof(struct node));
    head=NULL;
    while(1){
        printf("Choose an operation : 1.Insert element at position 2.Delete element at position 3.Count no of elements 4.Display elements 5.exit \n");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1: printf("enter position and data\n");
                    scanf("%d %d",&position,&data);
                    fnInsertAtPosition(&head,data,position);
                    break;
            case 2: printf("Enter position\n");
                    scanf("%d",&position);
                    fnDeleteAtPosition(&head,position);
                    break;
            case 3: fnLength(head);
                    break;
            case 4: fnDisplay(head);
                    break;
            case 5: exit(0);
            default: printf("Invalid argument\n");
                     break;
        }
    }
    return 1;
}