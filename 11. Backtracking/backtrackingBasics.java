public class backtrackingBasics {
    public static void main(String[] args) {
        int[] array = new int[5];
        basic(array, 0);
        printArray(array);
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
}
