package dp;

import java.util.*;

public class BOJ11054 {

    static int n;
    static int[] a = new int[1004];
    static int[] a_temp = new int[1004];
    static int[] cnt1 = new int[1004];
    static int[] cnt2 = new int[1004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.fill(cnt1, 1);
        Arrays.fill(cnt2, 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j]) {
                    cnt1[i] = Math.max(cnt1[i], cnt1[j]+1);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            a_temp[i] = a[n-1-i];
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a_temp[i] > a_temp[j]) {
                    cnt2[i] = Math.max(cnt2[i], cnt2[j]+1);
                }
            }
        }

        int ret = -1;
        for(int i = 0; i < n; i++) {
            ret = Math.max(ret, cnt1[i] + cnt2[n-1-i] - 1);
        }

        System.out.println(ret);

    }

}




