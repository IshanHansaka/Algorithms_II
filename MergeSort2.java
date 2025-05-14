public class MergeSort2 {

    public static void main(String args[]) {
        int[] arr = { 5, 6, 4, 8, 7, 1, 3 };
        printArr(arr);
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for (int x = 0; x < n1; x++) {
            lArr[x] = arr[l + x];
        }

        for (int y = 0; y < n2; y++) {
            rArr[y] = arr[m + 1 + y];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (lArr[i] < rArr[j]) {
                arr[k++] = lArr[i++];
            } else {
                arr[k++] = rArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = lArr[i++];
        }

        while (j < n2) {
            arr[k++] = rArr[j++];
        }
    }
}