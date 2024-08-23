import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) 
            return;
      
        int mid = s + (e - s) / 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s, j = m, k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) 
                mix[k++] = arr[i++];      
            else 
                mix[k++] = arr[j++];
        }

        // copy the remaining elements
        for( ; i < m; i++) 
            mix[k++] = arr[i];

        for (; j < e; j++) 
            mix[k++] = arr[j];
        
        for (int l = 0; l < mix.length; l++) 
            arr[s+l] = mix[l];   
    }
}
