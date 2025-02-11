package Algorithms_II;

public class MergeSort {
    public static void main(String args[]) {

        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        // Print the original array
        System.out.println("Original array:");
        printArray(arr, n);

        // Perform Merge Sort
        mergeSort(arr, 0, n - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        printArray(arr, n);
    }

    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {

            // Calculate the middle index
            int m = l + (r - l) / 2;

            // Recursively sort the first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    static void merge(int arr[], int l, int m, int r) {

        // Find sizes of the two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[m + 1 + j];
        }

        // Merge the temporary arrays back into arr[l...r]
        int i = 0, j = 0, k = l;

        // Compare elements of both subarrays and merge them in sorted order
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArray, if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArray, if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
