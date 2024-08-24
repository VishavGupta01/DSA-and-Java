public class assignment10 {
    public static void main(String[] args) {
        String[] arr = { "sun", "earth", "mars", "mercury"};
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
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
}
