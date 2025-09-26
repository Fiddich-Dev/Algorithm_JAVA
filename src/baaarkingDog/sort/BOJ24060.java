package baaarkingDog.sort;

import java.util.*;

public class BOJ24060 {

    static int n, k;
    static int[] a;
    static int[] temp;
    static int cnt = 0;
    static int ret = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n];
        temp = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        merge_sort(0, n-1);

        System.out.println(ret);

    }

    static void merge_sort(int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            merge_sort(start, mid);
            merge_sort(mid+1, end);
            merge(start, mid, end);
        }
    }

    static void merge(int start, int mid, int end) {
        int p1 = start;
        int p2 = mid+1;

        int now = start;
        while(p1 <= mid && p2 <= end) {
            if(a[p1] <= a[p2]) {
                temp[now++] = a[p1++];
            }
            else {
                temp[now++] = a[p2++];
            }
        }

        while(p1 <= mid) {
            temp[now++] = a[p1++];
        }
        while(p2 <= end) {
            temp[now++] = a[p2++];
        }

        now = start;
        while(now <= end) {
            a[now] = temp[now];
            cnt++;
            if(cnt == k) {
                ret = a[now];
            }
            now++;
        }
    }
}