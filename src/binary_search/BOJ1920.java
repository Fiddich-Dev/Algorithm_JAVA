package binary_search;

import java.util.*;
import java.io.*;

public class BOJ1920 {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            System.out.println(binary_search(num, n, a));
        }
    }

    static int binary_search(int num, int n, int[] a) {
        int l = 0;
        int r = n-1;

        while(l <= r) {
            int mid = (l + r) / 2;
            if(a[mid] > num) {
                r = mid - 1;
            }
            else if(a[mid] < num) {
                l = mid + 1;
            }
            else if(a[mid] == num) {
                return 1;
            }
        }

        return 0;
    }
}

