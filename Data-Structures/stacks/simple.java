import java.util.Scanner;

    class simple{

        public static int[] arr = new int[5];
        public static int top;
    
    static void push(int elem){
        if((top+1)==5){
            System.out.println("Stack overflow!");
        }
        else{
            arr[++top]=elem;
            System.out.println("Element pushed");
        }
    }

    static void pop(){
        if(top==-1){
            System.out.println("Stack underflow!");
        }
        else{
            top--;
            System.out.println("Element popped");
        }
    }

    static void display(){ 
        int i;
        if(top==-1){
            System.out.println("Stack underflow!");
        }
        else{
            System.out.println("Elements of stack are : ");
            for(i=0;i<=top;i++){
                System.out.println(arr[i] + "\t");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        top=-1;
        int elem,choice;
        while(true){
            System.out.println("Choose operation : 1.Push 2.Pop 3.Display 4.Exit");
            elem=scanner.nextInt();
            switch(elem){
                case 1: System.out.println("Enter element : ");
                        elem=scanner.nextInt();
                        push(elem);
                        break;
                case 2: pop();
                        break;
                case 3: display();
                        break;
                case 4: System.exit(1);
                default:System.out.println("Invalid input");
                        break;
            }
        }
    }
}