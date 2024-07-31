public class mergeSort { //Time Complexity => O(n log n) , Space Complexity => o(n)
    public static void main(String[] args) {
        int[] input = {2,4,1,4,5,-1};
        mergeSort(input, 0, input.length-1);
        printArray(input);
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void mergeSort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) / 2);
        mergeSort(input, start, mid); //left Array
        mergeSort(input, mid+1, end); //Right Array
        merge(input, start, mid, end); // Merging the Sorted Arrays

    }

    public static void merge(int[] input, int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (input[i] <= input[j]) {
                temp[k] = input[i];
                i++;
            } else {
                temp[k] = input[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = input[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = input[j];
            j++;
            k++;
        }
        for(k = 0, i = start; k < temp.length; k++, i++) {
            input[i] = temp[k];
        }
    }
}
