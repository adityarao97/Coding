import java.util.*;

class Bubble{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        for(int i = 0;i<n;i++){
            boolean flag=false;
            for(int j = 0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(flag==false){
                break;
            }
        }
        for(int i = 0;i<n;i++){
            System.out.println(arr[i]);
        }
        scanner.close();
    }
}