public class QuickSort2 {

    public static void main(String args[]) {
        int[] arr = { 9, 5, 7, 1, 6, 3, 4, 2 };
        printArr(arr);
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = partition(arr, l, h);

            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, h);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int pivot = h;

        int i = l - 1;
        for (int j = l; j < pivot; j++) {
            if (arr[j] < arr[pivot]) {
                i++;
                swap(arr, j, i);
            }
        }
        swap(arr, pivot, i + 1);

        return i + 1;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
