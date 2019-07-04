// the given program accepts no of test case and strings to calculate the sum of total no of vowels present in its subsets
import java.util.*;

class VowelFinder {
    
    public static int vowelCount;

    static void findCount(String str){
        int localVowel;
        for(int i=0;i<str.length();i++){
            localVowel=0;
            for(int j=i;j<str.length();j++){
                if(isVowel(str.charAt(j))){
                    localVowel++;
                }
                vowelCount+=localVowel;
            }
        }
    }
    
    static boolean isVowel(char ch){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                return true;
            }
            return false;
        }
    
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t,i;
        String[] str = new String[100000];
        t = scanner.nextInt();
        for(i=0;i<t;i++){
            vowelCount = 0;
            str[i] = scanner.next();
            findCount(str[i]);
            System.out.println(vowelCount);
        }
        scanner.close();
    }
}
