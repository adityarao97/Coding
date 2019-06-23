import java.util.Scanner;
class node{
    public int data;
    public node next;
    node(int data){
        this.data=data;
        this.next=null;
    }
}

class sLinkedList{ 

static void fnInsertAtPosition(node head,int data,int position){
    node newNode,cur,prev;
    newNode = new node(data);
    int k=1;
    if(position==1){
        newNode.next=head;
        head=newNode;
        return;
    }
    else{
        cur=head;
        prev=head;
        while(k<position && cur!=null){
            k++;
            prev=cur;
            cur=cur.next;
        }
        if(k!=position){
            System.out.println("Position doesn't exist");
            return;
        }
        prev.next=newNode;
        newNode.next=cur;
    }
}

static void fnDeleteAtPosition(node head,int position){
    node cur,prev;
    int k=1;
    if(head==null){
        System.out.println("List is empty");
        return;
    }
    if(position==1){
        cur=head;
        head=head.next;
        return;
    }
    else{
        cur=head;
        prev=head;
        while(position<k && cur!=null){
            k++;
            prev=cur;
            cur=cur.next;
        }
        if(position!=k){
            System.out.println("Position doesn't exist");
            return;
        }
        if(cur.next!=null){
            prev.next=cur.next;
        }
        else{
            prev.next=null;
        }
    }
}

static void fnDisplay(node head){
    node cur;
    int count=0;
    if(head==null){
        System.out.println("List is empty");
        return;
    }
    cur=head;
    System.out.println("Elements of linked list are : ");
    while(cur!=null){
        System.out.println(cur.data);
        cur=cur.next;
        count++;
    }
    System.out.println("Total no.of elements in linked list are : " + count);
}

    public static void main(String[] args) {
        int data,position,choice;
        node head=null;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Choose an operation : 1.Insert element at position 2.Delete element at position 3.Display elements 4.exit \n");
            choice=scanner.nextInt();
            switch(choice){
                case 1: System.out.println("Enter position and data");
                        position=scanner.nextInt();
                        data=scanner.nextInt();
                        fnInsertAtPosition(head,data,position);
                        break;
                case 2:System.out.println("Enter position");
                        position=scanner.nextInt();
                        fnDeleteAtPosition(head, position);
                        break;
                case 3:fnDisplay(head);
                        break;
                case 4:System.exit(1);
                default:System.out.println("Invalid input");
                        break;
            }
        }
    }
}
