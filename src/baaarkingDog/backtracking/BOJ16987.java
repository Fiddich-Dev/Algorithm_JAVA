package baaarkingDog.backtracking;

import java.util.*;

public class BOJ16987 {

    static int n;
    static Pair[] a;
    static boolean[] isBreak;
    static int cnt = 0;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new Pair[n];
        isBreak = new boolean[n];

        for(int i = 0; i < n; i++) {
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
            isBreak[i] = false;
        }

        go(0);

        System.out.println(ret);

    }

    static void go(int now) {
        if(now == n) {
            ret = Math.max(ret, cnt);
            return;
        }
        if(a[now].s <= 0) {
            go(now+1);
            return;
        }

        boolean hit = false;
        for(int i = 0; i < n; i++) {
            if(i == now) {
                continue;
            }
            if(a[i].s <= 0) {
                continue;
            }

            a[now].s -= a[i].w;
            a[i].s -= a[now].w;
            if(a[now].s <= 0) {
                cnt++;
            }
            if(a[i].s <= 0) {
                cnt++;
            }

            hit = true;
            go(now+1);

            if(a[now].s <= 0) {
                cnt--;
            }
            if(a[i].s <= 0) {
                cnt--;
            }
            a[now].s += a[i].w;
            a[i].s += a[now].w;
        }
        if(!hit) {
            go(now+1);
        }
    }

    static class Pair {
        int s;
        int w;

        public Pair(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
}
