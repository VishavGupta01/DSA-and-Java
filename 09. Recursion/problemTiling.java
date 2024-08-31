public class problemTiling {
    public static void main(String[] args) {
        System.out.println(tiling(3));
    }

    public static int tiling(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        //Vertical Choice
        int vertical = tiling(n-1);

        //Horizontal Choice
        int horizontal = tiling(n-2);

        return vertical + horizontal;
    }
}
