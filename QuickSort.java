public class QuickSort {

    public static void main(String args[]) {

        int arr[] = { 2, 6, 5, 9, 12, 1, 3 };

        printArr(arr);

        quickSort(arr, 0, arr.length - 1);

        printArr(arr);
    }

    public static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int arr[], int low, int high) {
        int pivot = high;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < arr[pivot]) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, pivot, i + 1);

        return i + 1;
    }

    public static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
