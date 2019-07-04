import java.io.*;
import java.util.*;



public class URLSort {
    
        public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int maxIndex;
        List<String> urls = new ArrayList<String>();
        List<Integer> count = new ArrayList<Integer>();
        int N = scanner.nextInt();
        String text="";
        //adding unique strings to list and count each occurences
        for(int i=0;i<N;i++){
            text=scanner.next();
            if(!(urls.contains(text))){
                urls.add(text);
                count.add(1);
            }
            else{
                int newCount=count.get(urls.indexOf(text));
                count.set(urls.indexOf(text),++newCount);
            }
        }
        //sort urls on the basis of their occurences in decreasing order
        for(int i=0;i<(urls.size()-1);i++){
            maxIndex=i;
            for(int j=i+1;j<urls.size();j++){
                if(count.get(j)>count.get(maxIndex)){
                    maxIndex=j;
                }
            }
                Collections.swap(count, i, maxIndex);
                Collections.swap(urls, i, maxIndex);
        }
        System.out.println("\n\n");
        for(int i=0;i<urls.size();i++){
            System.out.println(urls.get(i) + "\t" + count.get(i));
        }
        //if urls have same occurences order them in increasing order of alphabet
        System.out.println("\n\n");
        for(int i=0;i<(urls.size()-1);i++){
            int commonCount=i;
            int j=i+1;
            for(;j<urls.size();j++){
                if(count.get(j)!=count.get(commonCount)){
                    break;
                }
            }
            Collections.sort(urls.subList(commonCount, j));
        }
        //print no of unique URL count and each URL in order
        System.out.println(urls.size());
        for(int i=0;i<urls.size();i++){
            System.out.println(urls.get(i));
        }
        scanner.close();
    }
}