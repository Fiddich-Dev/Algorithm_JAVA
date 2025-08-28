package dp;

import java.util.*;

public class BOJ11659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] psum = new int[n+1];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            psum[i+1] = sum;
        }



        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int ret = psum[e] - psum[s-1];
            System.out.println(ret);
        }

    }
}
