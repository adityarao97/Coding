import java.util.*;

class Test {
    
    public static void main(String args[] ) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        String[] temp = x.split(" ");
        System.out.println(Integer.parseInt(temp[0]));
    }
}
