public class assignment10 {
    public static void main(String[] args) {
        // String[] arr = { "sun", "earth", "mars", "mercury"};
        // mergeSort(arr, 0, arr.length-1);
        // printArray(arr);

        // int[] array = {2,2,1,1,1,2,2,1};
        // System.out.println(majority(array, 0, array.length-1));

        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, 0, arr.length-1));
    }

    public static void printArray1(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printArray(String[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    //Question1: Apply Merge sort to sort an array of Strings. (Assume that all the characters in all the Strings are in lowercase).
    public static void mergeSort(String[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + ((end - start) / 2);
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        merge(array, start, mid, end);
    }

    public static void merge(String[] array, int start, int mid, int end) {
        String temp[] = new String[end - start + 1];
        int i = start;
        int j = mid+1;
        int k = 0; //Temp Array Iterator

        while (i <= mid && j <= end) {
            int m = 0;
            while(m < array[i].length() && m < array[j].length() && (int)array[i].charAt(m) == (int)array[j].charAt(m)) {
                m++;
            }
            if (m >= array[i].length()) {
                temp[k] = array[j];
                j++;
            } else if (m >= array[j].length()) {
                temp[k] = array[i];
                i++;
            } else if (array[i].charAt(m) < array[j].charAt(m)) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = array[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = array[j];
            j++;
            k++;
        }

        for(i=start, k=0; k < temp.length; k++, i++) {
            array[i] = temp[k];
        }
    }

    //Question 2 :Given an array nums of size n, return the majority element. The majority element is the element that appears more than ⌊ n / 2 ⌋ times. You may assume that the majority element always exists in the array.
    public static int majority(int[] array,int start, int end) {
        //Base Case
        if (start == end) {
            return array[start];
        }

        //Merging
        int mid = start + (end - start)/2;
        int leftMajority = majority(array, start, mid);
        int rightMajority = majority(array, mid+1, end);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int leftCount = countInRange(array, start, mid, leftMajority);
        int rightCount = countInRange(array, mid+1, end, rightMajority);

        if (leftCount > rightCount) {
            return leftMajority;
        } else if (rightCount > leftCount) {
            return rightMajority;
        } else {
            return -1;
        }
    }

    public static int countInRange(int[] array, int start, int end, int candidate) {
        int count = 0;
        for(int i = start; i <= end; i++) {
            if (array[i] == candidate) {
                count++;
            }
        }
        return count;
    }

    //Question 3 :Given an array of integers. Find the Inversion Count in the array.
    // Inversion Count:For an array, inversion count indicates how far (or close) the array is from being sorted.If the array is already sorted then the inversion count is 0.If an array is sorted in the reverse order then the inversion count is the maximum.Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.Sample Input 1: N = 5, arr[ ] = {2, 4, 1, 3, 5}Sample Output 1: 3, because it has 3 inversions -(2, 1), (4, 1), (4, 3).
    // Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
    public static int inversionCount(int[] arr, int start, int end) {
        if (start >=  end) {
            return 0;
        }
        int count = 0;

        int mid = start + (end - start)/2;
        count += inversionCount(arr, start, mid);
        count += inversionCount(arr, mid+1, end);
        count += merge1(arr, start, mid, end);
        return count;
    }

    public static int merge1(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid+1;
        int k = 0;
        int count = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                count += (mid - i + 1);
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(i = start, k = 0; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
        return count;
    }
}
