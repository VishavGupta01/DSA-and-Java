public class rotatedSortedArray {
    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,1,2};
        int key = 0;
        System.out.println(rotatedSortedArraySearch(array, 0, array.length-1, 0));
    }

    public static int rotatedSortedArraySearch(int[] arr, int si, int ei, int key) {
        //Base Case
        if (si > ei) {
            return -1;
        }

        //Work
        int mid = si + (ei - si) / 2;

        //Recursive Calls
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= key && key <= arr[mid]) {
                return rotatedSortedArraySearch(arr, si, mid-1, key);
            } else {
                return rotatedSortedArraySearch(arr, mid+1, ei, key);
            }
        } else {
            if (arr[mid] <= key && key <= arr[ei]) {
                return rotatedSortedArraySearch(arr, mid+1, ei, key);
            } else {
                return rotatedSortedArraySearch(arr, si, mid-1, key);
            }
        }
    }
}