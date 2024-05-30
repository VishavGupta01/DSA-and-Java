import java.util.Arrays;
import java.util.Collections;

public class sorts {
    public static void main(String args[]) {
        int[] array = {5,4,1,3,2};
        Integer[] arrays = {1,6,3,5,2};
        countingSort(array);
    }

    public static void printArray(int[] array) {
        int len = array.length;
        for(int i = 0; i < len; i++) {
            System.out.print(array[i]);
        }
    }

    public static void bubbleSort(int[] array) {// Time Complexity => O(n^2)
        int len = array.length;
        for(int i = 0; i < len-1; i++) {
            int counter = 0;
            for(int j = 0; j < len-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    counter++;
                }
            }
            if (counter==0) {
                break;
            }
        }
        printArray(array);
    }

    public static void selectionSort(int[] array) {// Time Complexity => O(n^2)
        int len = array.length;
        for(int i = 0; i < len-1; i++) {
            int min = array[i];
            boolean flag = false;
            for(int j = i+1; j < len; j++) {
                if(min > array[j]) {
                    min = array[j];
                    flag = true;
                }
            }
            if (flag == true) {
                array[i] = min;
            }
        }
        printArray(array);
    }

    public static void insertionSort(int[] array) { // Time Complexity => O(n^2)
        int len = array.length;
        for(int i = 1; i < len; i++) {
            int currentVal = array[i]; // Saved the Current Value
            int prevIndex = i-1;
            while (prevIndex >= 0 && array[prevIndex] > currentVal) { // Added Limit to check for sorted array by 1st condition & correct position for current value by 2nd condition.
                array[prevIndex + 1] = array[prevIndex]; // Pushed the Sorted Array Value to next Position
                prevIndex--;
            }
            array[prevIndex+1] = currentVal; // Passed the Current Value of the pass in the correct Position, We added 1 in PreviousIndex because we subtracted 1 from it in the While loop end.
        }
        printArray(array);
    }

    public static void inbuiltSort(int[] array , Integer[] arrays) { // Time Complexity => O(n log n)
        //Basic Sort
        Arrays.sort(array);
        Arrays.sort(array,0,array.length);
        System.out.println(Arrays.toString(array));

        //Reverse Sort
        Arrays.sort(arrays,Collections.reverseOrder());
        Arrays.sort(arrays,0,arrays.length,Collections.reverseOrder());
        System.out.println(Arrays.toString(arrays));
    }

    public static void countingSort(int[] array) { // Time Complexity => O(n + range) 
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            largest = Math.max(largest, array[i]);
        }
        int[] count = new int[largest+1];
        for(int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        int j = 0;
        for(int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[j] = i;
                j++;
                count[i]--;
            }
        }
        printArray(array);
    }
}