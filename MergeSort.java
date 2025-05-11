public class MergeSort {

    public static void main(String args[]) {
        // Initial unsorted array
        int arr[] = { 4, 2, 8, 5, 9, 1, 3, 7 };

        System.out.println("original array");
        printArr(arr);

        // Call merge sort on the entire array
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("sorted array");
        printArr(arr);
    }

    public static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Recursive method to divide the array into subarrays and sort them
    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point of the array
            int m = (l + r) / 2;

            // Recursively sort the left half
            mergeSort(arr, l, m);

            // Recursively sort the right half
            mergeSort(arr, m + 1, r);

            // Merge the two sorted halves
            merge(arr, l, m, r);
        }
    }

    // Method to merge two sorted subarrays: arr[l..m] and arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r) {
        // Sizes of the two subarrays
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        // Copy data to temp arrays lArr[] and rArr[]
        for (int x = 0; x < n1; x++) {
            lArr[x] = arr[l + x];
        }
        for (int y = 0; y < n2; y++) {
            rArr[y] = arr[m + 1 + y];
        }

        // Merge the temp arrays back into arr[l..r]
        int i = 0; // Initial index of lArr
        int j = 0; // Initial index of rArr
        int k = l; // Initial index of merged subarray

        // Compare elements of lArr and rArr, and put the smaller one into arr
        while (i < n1 && j < n2) {
            if (lArr[i] < rArr[j]) {
                arr[k++] = lArr[i++];
            } else {
                arr[k++] = rArr[j++];
            }
        }

        // Copy remaining elements of lArr[] if any
        while (i < n1) {
            arr[k++] = lArr[i++];
        }
        // Copy remaining elements of rArr[] if any
        while (j < n2) {
            arr[k++] = rArr[j++];
        }
    }
}
