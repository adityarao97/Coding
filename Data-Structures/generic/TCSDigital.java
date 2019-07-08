import java.util.*;

class TCSDigital{
    public static void main(String[] args) {
        int N;
        boolean flag=false;
        List<String> contacts = new ArrayList<String>();
        Scanner scanner  = new Scanner(System.in);
        // int minLength=9999;
        N=scanner.nextInt();
        for(int i = 0;i<N;i++){
            contacts.add(scanner.next());
            // if(contacts.get(i).length()<minLength){
            //     minLength=contacts.get(i).length();
            // }
        }
        for(int i = 0;i<N;i++){
            String str = contacts.get(i);
            for(int j = 0;j<N && j!=i;j++){
                if(str.length()<=contacts.get(j).length()){
                    if(str.equals(contacts.get(j).substring(0,str.length()))){
                        System.out.println("Inconsistent at " + str);   
                        flag=true;
                        System.exit(0);
                    }
                    else{
                        flag=false;
                    }
                }
            }
        }
        if(flag==false){
            System.out.println("Consistent");
        }
        scanner.close();
    }
}