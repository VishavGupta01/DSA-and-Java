public class problemFriendsPairing {
    public static void main(String[] args) {
        System.out.println(pairing(4));
    }

    public static int pairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int single = pairing(n-1);
        int pair = (n-1) * pairing(n-2);
        return single + pair;
    }
}