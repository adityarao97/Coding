class Test{
    public static void main(String[] args) {
        String text = "Hello";
        for(int i=0;i!=(text.length()+1);i++){
            System.out.println(text.substring(0,i));
        }
        // System.out.println(text.substring(1,1));
    }
}