#include <stdio.h>
#include <stdlib.h>

// #define SIZE=5;

void fnPush(int arr[],int *top,int elem){
    if(*top==4){
        printf("\nStack overflow");
    }
    else{
        arr[++*top]=elem;
        printf("\nElement pushed!");
    }
}

void fnPop(int arr[],int *top){
    int elem;
    if(*top==-1){
        printf("\nStack underflow");
    }
    else{
        *top=*top-1;
        printf("\nElement popped");
    }
}

void fnDisplay(int arr[],int top){
    int i;
    if(top==-1){
        printf("\nStack is empty");
    }
    else{
        printf("\nElements of stack are :");
        for(i=0;i<=top;i++){
            printf("%d\t",arr[i]);
        }
    }
}

int main(){
    int elem,choice,arr[5],top=-1;
    while(1){
        printf("\nChoose your operation : 1.Push 2.Pop 3.Display 4.Exit : ");
        scanf("%d",&choice);
        switch(choice){
            case 1: printf("Enter element : ");
                    scanf("%d",&elem);
                    fnPush(arr,&top,elem);
                    break;
            case 2: fnPop(arr,&top);
                    break;
            case 3: fnDisplay(arr,top);
                    break;
            case 4: exit(1);
            default:printf("Invalid input");
                    break;
        }
    }
    return 0;
}