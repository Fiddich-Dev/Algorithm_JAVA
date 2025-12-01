package saffy;

import java.util.*;

public class SWEA1206 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 10;
        for(int q = 1; q <= 10; q++) {
            int ret = 0;
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++) {
                if(a[i] == 0) {
                    continue;
                }
                int now = a[i];
                now = Math.min(now, a[i] - a[i-1]);
                now = Math.min(now, a[i] - a[i-2]);
                now = Math.min(now, a[i] - a[i+1]);
                now = Math.min(now, a[i] - a[i+2]);
                if(now > 0) {
                    ret += now;
                }
            }
            System.out.println("#" + q + " " + ret);
        }
    }

}

