#include <stdio.h>
#include <stdlib.h>

struct node{
    int data;
    struct node *left;
    struct node *right;
};

void fnInsertAtPosition(struct node **head,int data,int position){
    struct node *cur,*prev,*newNode;
    int k=1;
    newNode=(struct node *)malloc(sizeof(struct node));
    if(!newNode){
        printf("Memory error\n");
        return;
    }
    newNode->data=data;
    if(position==1){
        newNode->left=NULL;
        if(*head){
            newNode->right=*head;
            newNode->right->left=newNode;
        }
            *head=newNode;
        return;
    }
    cur=*head;
        while(k<position && cur!=NULL){
            k++;
            prev=cur;
            cur=cur->right;
        }
        if(k!=position){
            printf("position doesn't exist\n");
            return;
        }
        prev->right=newNode;
        newNode->left=prev;
        if(cur){
            newNode->right=cur;
            cur->left=newNode;
        }
        else{
            newNode->right=NULL;
        }
        return;
}

void fnDeleteAtPosition(struct node **head,int position){
    struct node *cur,*prev;
    int k=1;
    if(*head==NULL){
        printf("List is empty\n");
        return;
    }
    cur=*head;
    if(position==1){
        *head=cur->right;
        if(*head!=NULL)
            cur->right->left=NULL;
        free(cur);
        return;
    }
        while(k<position && cur!=NULL){
            k++;
            prev=cur;
            cur=cur->right;
        }
        if(k!=position){
            printf("Position doesn't exist\n");
            return;
        }
        prev->right=cur->right;
        if(cur->right)
            cur->right->left=prev;
        free(cur);
        return;
}

void fnDisplay(struct node *head){
    struct node *cur=head;
    int count=0;
    if(head==NULL){
        printf("List is empty\n");
        return;
    }
    printf("Elements of Doubly linked list are : \n");
    while(cur!=NULL){
        printf("%d\t",cur->data);
        cur=cur->right;
        count++;
    }
    printf("\n Total no of elements are : %d\n",count);
    return;
}

int main(){
    int choice,position,data;
    struct node *head;
    head=(struct node *)malloc(sizeof(struct node));
    if(!head){
        printf("Memory error\n");
        return 0;
    }
    head=NULL;
    while(1){
        printf("Choose your operation 1.Insert at position 2.Delete at position 3.Display elements\n");
        scanf("%d",&choice);
        switch (choice)
        {
        case 1: printf("Insert element and position\n");
                scanf("%d %d",&data,&position);
                fnInsertAtPosition(&head,data,position);
                break;
        case 2: printf("Insert position to delete\n");
                scanf("%d",&position);
                fnDeleteAtPosition(&head,position);
                break;
        case 3: fnDisplay(head);
                break;
        default:printf("Invalid entry\n");
                break;
        }
    }
    return 0;
}