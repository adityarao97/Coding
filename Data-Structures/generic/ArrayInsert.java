import java.util.*;


class ArrayInsert {
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i]=scanner.nextInt();
            // System.out.println(arr[i]);
        }
        scanner.nextLine();
        for(int i=0;i<Q;i++){
            String query=scanner.nextLine();
            String[] temp = query.split(" ");
            // System.out.println(query);
            int sum=0;
            int a = Integer.parseInt(temp[1]);
            int b = Integer.parseInt(temp[2]);
            switch(query.charAt(0)){
                case '1' :  arr[a]=b;
                            break;
                case '2' :  for(int j=a;j<=b;j++){
                                sum+=arr[j];
                            }
                            System.out.println(sum);
                            break;
            }
        }
    }
}
