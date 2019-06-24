import java.util.Scanner;

import com.sun.org.apache.xpath.internal.SourceTree;

class node{
    int data;
    node left;
    node right;
    node(int data){
        this.data=data;
        this.right=null;
        this.left=null;
    }    
}

class dLinkedList{
    public static node head;

    static void fnInsertAtPosition(int data,int position){
        node prev,cur,newNode;
        int k=1;
        newNode = new node(data);
        if(head==null){
            head=newNode;
            return;
        }
        if(position==1){
            newNode.right=head;
            head.left=newNode;
            head=newNode;
        }
        else{
            cur=head;
            prev=head;
            while(k<position && cur!=null){
                k++;
                prev=cur;
                cur=cur.right;
            }
            if(k!=position){
                System.out.println("Position doesn't exist");
                return;
            }
            prev.right=newNode;
            newNode.left=prev;
            if(cur!=null){
                newNode.right=cur;
                cur.left=newNode;
            }
        }
    }

    static void fnDeleteAtPosition(int position){
        node cur,prev;
        int k=1;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(position==1){
            head=head.right;
        }
        else{
            cur=head;
            prev=head;
            while(k<position && cur!=null){
                k++;
                prev=cur;
                cur=cur.right;
            }
            if(k!=position){
                System.out.println("Position doesn't exist");
                return;
            }
            if(cur.right!=null){
                prev.right=cur.right;
                cur.right.left=prev;
            }
            else{
                prev.right=null;
            }
        }
    }

    static void fnDisplay(){
        node cur;
        int count=0;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        cur=head;
        System.out.println("Elements of doubly linked list are : ");
        while(cur!=null){
            System.out.println(cur.data);
            cur=cur.right;
            count++;
        }
        System.out.println("Total no of elements in List are : " + count);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice,data,position;
        while(true){
            System.out.println("Select operation 1:Insert at position 2.Delete at position 3.Display 4.Exit");
            choice = scanner.nextInt();
            switch(choice){
                case 1: System.out.println("Enter element and position");
                        data = scanner.nextInt();
                        position = scanner.nextInt();
                        fnInsertAtPosition(data, position);
                        break;
                case 2: System.out.println("Enter position");
                        position = scanner.nextInt();
                        fnDeleteAtPosition(position);
                        break;
                case 3: fnDisplay();
                        break;
                case 4: System.exit(1);
                default:System.out.println("Invalid input");
                        break;
            }
        }
    }
}