public class backtrackingBasics {
    public static void main(String[] args) {
        int[] array = new int[5];
        // basic(array, 0);
        // printArray(array);

        // stringSubsets("abc", "", 0);
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void basic(int[] array, int i) {
        // Base Case
        if (i == array.length) {
            printArray(array);
            return;
        }

        // Work
        array[i] = i+1;

        //Recursive Call
        basic(array, i+1);

        array[i] = array[i] - 2; //BackTracking
    }

    public static void stringSubsets(String str, String ans, int i) { // TC: O(n*2^n) {Cuz there are 2^n Subsets and it takes n time to get 1 subset} || SC: O(n)
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        stringSubsets(str, ans+str.charAt(i), i+1);
        stringSubsets(str, ans, i+1); // BackTracking
    }

    public static void permutations(String str, String ans, int i) {
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }

        permutations(str.substring(0, i) + str.substring(i+1,str.length()-1), ans + str.charAt(i), i+1);
    }
}
