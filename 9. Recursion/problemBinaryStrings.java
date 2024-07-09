public class problemBinaryStrings {
    public static void main(String[] args) {
        binaryStrings(3, 0, "");
    }

    public static void binaryStrings(int n, int LastPlaceValue, String result) {
        //Base Case
        if (n == 0) {
            System.out.println(result);
            return;
        }

        //Work
        // if (LastPlaceValue == 0) { // 0 at lastPlace
        //     binaryStrings(n-1, 0, result.append("0"));
        //     binaryStrings(n-1, 1, result.append("1"));
        // } else { // 1 at Last Place
        //     binaryStrings(n-1, 0, result.append("0"));
        // }
        binaryStrings(n-1, 0, result + "0");
        if (LastPlaceValue == 0) {
            binaryStrings(n-1, 1, result + "1");
        }
    }
}
