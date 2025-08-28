package implementation;

import java.util.*;
import java.io.*;

public class BOJ24060 {

    static int n, k;
    static int[] a = new int[500004];
    static int[] temp = new int[500004];
    static int ret = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, n-1);

        if(cnt < k) {
            System.out.println(-1);
        }
        else {
            System.out.println(ret);
        }

    }

    static void merge_sort(int l, int r) {
        if(l < r) {
            int mid = (l + r) / 2;
            merge_sort(l, mid);
            merge_sort(mid + 1, r);
            merge(l, r, mid);
        }
    }

    static void merge(int l, int r, int mid) {
        int now1 = l;
        int now2 = mid+1;
        int idx = 0;

        while(now1 <= mid && now2 <= r) {
            if(a[now1] < a[now2]) {
                temp[idx] = a[now1];
                now1++;
                idx++;
            }
            else {
                temp[idx] = a[now2];
                now2++;
                idx++;
            }
        }
        while(now1 <= mid) {
            temp[idx] = a[now1];
            now1++;
            idx++;
        }
        while(now2 <= r) {
            temp[idx] = a[now2];
            now2++;
            idx++;
        }

        for(int i = 0; i < idx; i++) {
            a[l+i] = temp[i];
            cnt++;
            if(cnt == k) {
                ret = a[l+i];
            }
        }

    }
}
