public class MergeSortAlgorithm {

    private static void merge(int arr[], int l, int mid, int r) {

        int n1 = mid - l + 1;
        int n2 = r - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int x = 0; x < n1; x++) {
            L[x] = arr[l + x];
        }

        for (int x = 0; x < n2; x++) {
            R[x] = arr[mid + 1 + x];
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int arr[], int l, int r) {

        if (l < r) {

            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }

    }

    private static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        int arr[] = { 1, 3, 13, 10, 6, 7, 8, 2 };
        System.out.println("Before sorting");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("After sorting");
        printArray(arr);
    }

}
