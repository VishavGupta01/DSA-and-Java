public class quickSort {
    public static void main(String[] args) {
        int[] array = {2,4,1,5,2,1};
        quickSort(array, 0, array.length-1);
        printArray(array);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int temp = start + 1;
        int itr = end;
        while (temp <= itr) {
            if (array[temp] > pivot) {
                int k = array[temp];
                array[temp] = array[itr];
                array[itr] =  k;
                itr--;
            }
            temp++;
        }
        int k = pivot;
        array[start] = array[itr];
        array[itr] = k;
        return itr;
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex-1);
        quickSort(array, pivotIndex + 1, end);
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
