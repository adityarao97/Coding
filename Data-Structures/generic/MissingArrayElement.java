/*package whatever //do not write package name here */

import java.util.*;

class MissingArrayElements {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
		for(int i=0;i<T;i++){
		    int n = scanner.nextInt();
            int[] arr = new int[n];
            int count = arr[0] = scanner.nextInt();
            count++;
            for(int k = 1;k<n;k++){
                arr[k]=scanner.nextInt();
                if(arr[k]!=count){
                    System.out.println(count);
                    break;
                }else{
                    count++;
                }
            }
        }
        scanner.close();
	}
}