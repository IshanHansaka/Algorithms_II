public class MergeSort {

    public static void main(String args[]) {
        int arr[] = { 6, 5, 9, 12, 1, 2 };

        int length = arr.length;
        printArray(arr);

        mergeSort(arr, 0, length - 1);

        printArray(arr);
    }

    public static void printArray(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void merge(int arr[], int l, int m, int r) {

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
                arr[k] = lArr[i];
                i++;
                k++;
            } else {
                arr[k] = rArr[j];
                j++;
                k++;
            }
        }
        while (i < n1) {
            arr[k] = lArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }
}