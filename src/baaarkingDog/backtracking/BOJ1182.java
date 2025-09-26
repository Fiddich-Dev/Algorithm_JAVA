package baaarkingDog.backtracking;

import java.util.*;

public class BOJ1182 {

    static int n, s;
    static int[] a;
    static int ret = 0;
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        go(0, 0);

        if(s == 0) {
            ret--;
        }
        System.out.println(ret);
    }

    static void go(int now, int sum) {
        if(now == n) {
            if(sum == s) {
                ret++;
            }
            return;
        }

        go(now+1, sum);

        go(now+1, sum+a[now]);
    }
}
