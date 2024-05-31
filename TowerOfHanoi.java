public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // number of discs
        String fromRod = "A";
        String toRod = "C";
        String auxRod = "B";
 
        // call the recursive function
        towerOfHanoi(n, fromRod, toRod, auxRod);
    }
 
    static void towerOfHanoi(int n, String fromRod, String toRod, String auxRod) {
        if (n == 1) {
            System.out.println("Move disc 1 from rod " +  fromRod + " to rod " + toRod);
            return;
        }
        towerOfHanoi(n-1, fromRod, auxRod, toRod);
        System.out.println("Move disc " + n + " from rod " +  fromRod + " to rod " + toRod);
        towerOfHanoi(n-1, auxRod, toRod, fromRod);
    }
}