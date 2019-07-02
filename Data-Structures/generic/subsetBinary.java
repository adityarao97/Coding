class subsetBinary{

    static void binary(int digits,String prefix){
        // System.out.println("digits value : " + digits + " " + "prefix value : " + prefix);
        if(digits==0){ 
            System.out.println(prefix);
        }
        else{
            binary(digits-1, prefix + "0");
            binary(digits-1, prefix + "1");
        }
    }

    public static void main(String[] args) {
        binary(3,"");
    }
}