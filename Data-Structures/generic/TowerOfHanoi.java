class TowerOfHanoi{
    static void TowerOfHanoi(int n,int fromPeg,int toPeg,int auxPeg){
        if(n==1){
            System.out.println("Move disk 1 from " + fromPeg + " to " + toPeg);
        }
        else{
            TowerOfHanoi(n-1, fromPeg, auxPeg, toPeg);
            System.out.println("Move disk " + n + " from " + fromPeg + " to " + toPeg);
            TowerOfHanoi(n-1, auxPeg, toPeg, fromPeg);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi(3, 1, 3, 2);
    }
}

