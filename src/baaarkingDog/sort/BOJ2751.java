package baaarkingDog.sort;

import java.util.*;

public class BOJ2751 {

    static int n;
    static int[] a;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        temp = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        merge_sort(0, n);
        for(int i: a) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    static void merge_sort(int start, int end) {
        if(start+1 == end) {
            return;
        }

        int mid = (start+end) / 2;
        merge_sort(start, mid);
        merge_sort(mid, end);
        merge(start, end);
    }

    static void merge(int start, int end) {

        int mid = (start+end) / 2;
        int s1 = start;
        int s2 = mid;
        int idx = start;

        while(s1 < mid && s2 < end) {
            if(a[s1] < a[s2]) {
                temp[idx] = a[s1];
                s1++;
                idx++;
            }
            else {
                temp[idx] = a[s2];
                s2++;
                idx++;
            }
        }

        for(int i = s1; i < mid; i++) {
            temp[idx] = a[i];
            idx++;
        }
        for(int i = s2; i < end; i++) {
            temp[idx] = a[i];
            idx++;
        }

        for(int i = start; i < end; i++) {
            a[i] = temp[i];
        }

    }

}
