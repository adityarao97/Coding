import java.util.*;

class Selection{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minIndex,i,j;
        int n=scanner.nextInt();
        int[] arr = new int[n];
        for(i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        for(i=0;i<n-1;i++){
            minIndex=i;
            for(j=i+1;j<n;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];   
            arr[i]=temp;
        }
        for(i=0;i<n;i++){
            System.out.println(arr[i]);
        }
        scanner.close();
    }
}