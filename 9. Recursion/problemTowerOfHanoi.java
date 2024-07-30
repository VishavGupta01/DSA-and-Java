public class problemTowerOfHanoi {
    public static void main(String[] args) {
        hanoiTower(3, "A", "B", "C");
    }

    public static void hanoiTower(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("Transfer disc " + n + " from " + src + " to " + dest);
            return;
        }

        //Transferring  n-1 discs from Src to Helper
        hanoiTower(n-1, src, dest, helper);
        //Transferring the last disc from Src to Dest
        System.out.println("Transfer disc " + n + " from " + src + " to " + dest);
        //Transferring the n-1 disc from Helper to Dest
        hanoiTower(n-1, helper, src, dest);
    }
}
