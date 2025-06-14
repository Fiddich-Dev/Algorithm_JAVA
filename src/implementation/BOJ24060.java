package implementation;

import java.util.*;

public class BOJ24060 {

    static int cnt = 0;
    static int stop;
    static int ret = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        stop = k;

        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        mergeSort(a, 0, n-1);

        System.out.println(ret);

    }

    static void mergeSort(int[] a, int l, int r) {
        if(l < r) {
            int mid = (l + r) / 2;

            mergeSort(a, l, mid);
            mergeSort(a, mid+1, r);

            merge(a, l, mid, r);
        }
    }

    static void merge(int[] a, int l, int mid, int r) {

        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= r) {
            if(a[i] <= a[j]) {
                temp[k] = a[i];
                k++;
                i++;
            }
            else {
                temp[k] = a[j];
                k++;
                j++;
            }
        }

        while(i <= mid) {
            temp[k] = a[i];
            k++;
            i++;
        }

        while(j <= r) {
            temp[k] = a[j];
            k++;
            j++;
        }

        for(int t = 0; t < temp.length; t++) {
            a[l+t] = temp[t];
            cnt++;
            if(cnt == stop) {
                ret = a[l+t];
            }
        }

    }
}
