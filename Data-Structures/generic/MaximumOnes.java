import java.util.*;

class MaximumOnes{
//fnTraverse is used to obtain the maximum no of adjacent ones for each location in matrix
    static int fnTraverse(int arr[][],int n){
        int maxCount=arr[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int count=fnGetMaxOnes(arr,i,j,n);
                if(count>maxCount){
                    maxCount=count;
                } 
            }
        }
        return maxCount;
    }
//fnGetMaxOnes is used to obtain the no of ones present for each location in matrix
    static int fnGetMaxOnes(int arr[][],int i,int j,int n){
        int count=0;
        if(arr[i][j]==0){
            return count; 
        }
        else if((i+1)<n){
            return count+=fnGetMaxOnes(arr, i+1, j,n);
        }
        else if((i+1)<n && (j+1)<n){
            return count+=fnGetMaxOnes(arr, i+1, j+1, n);
        }
        else if((j+1)<n){
            return count+=fnGetMaxOnes(arr, i, j+1, n);
        }
        else if((i-1)>0){
            return count+=fnGetMaxOnes(arr, i-1, j, n);
        }
        else if((j-1)>0){
            return count+=fnGetMaxOnes(arr, i, j-1, n);
        }
        else if((j-1)>0 && (i-1)>0){
            return count+=fnGetMaxOnes(arr, i-1, j-1, n);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of matrix");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        int max=fnTraverse(arr,n);
        System.out.println("Maximum value of ones is : " + max);
    }
}