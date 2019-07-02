import java.util.Scanner;

class node{
    int data;
    node next;
    node(int data){
        this.data=data;
    }
}

class cLinkedList{
    public static node head;
    static void fnDisplay(){
        node cur;
        int count=0;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        cur=head;
        System.out.println("Elements of Circular Linked List are : ");
        do{
            System.out.println(cur.data);
            cur=cur.next;
            count++;
        }while(cur!=head);
        System.out.println("Total no of elements of List are : " + count);
    }

    static void fnInsertAtEnd(int data){
        node cur,newNode;
        newNode = new node(data);
        newNode.next=newNode;
        if(head==null){
            head=newNode;
            return;
        }
        cur=head;
        do{
            cur=cur.next;
        }while(cur.next!=head);
        cur.next=newNode;
        newNode.next=head;
    }

    static void fninsertAtFront(int data){
        node first,cur,newNode;
        newNode = new node(data);
        newNode.next=newNode;
        if(head==null){
            head=newNode;
            return;
        }
        first=head;
        cur=head;
        do{
            cur=cur.next;
        }while(cur.next!=head);
        cur.next=newNode;
        newNode.next=first;
        head=newNode;
    }

    static void fnDeleteLastNode(){
        node prev,cur;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        prev=head;
        cur=head;
        do{
            prev=cur;
            cur=cur.next;
        }while(cur.next!=head);
        if(prev==cur){
            head=null;
        }
        else{
            prev.next=head;
        }
    }

    static void fnDeleteFirstNode(){
        node cur;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        cur=head;
        do{
            cur=cur.next;
        }while(cur.next!=head);
        if(head.next!=head){
            head=head.next;
            cur.next=head;
        }
        else{
            head=null;
        }
    }

    public static void main(String[] args) {
        int data,choice;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Select operation : 1.Insert at front 2.Insert at rear 3.Delete at front 4.Delete at rear 5.Display 6.Exit");
            choice = scanner.nextInt();
            switch(choice){
                case 1: System.out.println("Enter data");
                        data=scanner.nextInt();
                        fninsertAtFront(data);
                        break;
                case 2: System.out.println("Enter data");
                        data=scanner.nextInt();
                        fnInsertAtEnd(data);
                        break;
                case 3: fnDeleteFirstNode();
                        break;
                case 4: fnDeleteLastNode();
                        break;
                case 5: fnDisplay();
                        break;
                case 6: System.exit(1);
                default:System.out.println("Invalid input");
                        break;

            }
        }
    }
}