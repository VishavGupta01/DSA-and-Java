import java.util.*;

public class sortsAssignment {
    public static void main(String args[]) {
        int[] array = {3,6,2,1,8,7,4,5,3,1};
        insertionSort(array);
    }

public static void printArray(int[] array) {
    for(int i = 0; i < array.length; i++) {
        System.out.print(array[i]);
    }
}


    //Question: Use the following sorting algorithms to sort an array in DESCENDING order :Bubble Sort, Selection Sort, Insertion Sort, Counting Sort. You can use this array as an example : [3,6,2,1,8,7,4,5,3,1]
    public static void bubbleSort(int[] array) {
        for(int pass = 0; pass < array.length-1; pass++) {
            for(int j = 0; j < array.length-pass-1; j++) {
                if (array[j] < array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        printArray(array);
    }

    public static void selectionSort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for(int j = i+1; j < array.length; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
        printArray(array);
    }

    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int current = array[i];
            int prev = i-1;
            while (prev >= 0 && array[prev] < current) {
                array[prev+1] = array[prev];
                prev--;
            }
            array[prev+1] = current;
        }
        printArray(array);
    }

    public static void countingSort(int[] array) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int[] count = new int[max];
        for(int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        for(int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[i] = i;
                count[i]--;
            }
        }
        printArray(array);
    }

}
