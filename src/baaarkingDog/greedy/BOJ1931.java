package baaarkingDog.greedy;

import java.util.*;

public class BOJ1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) {
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        int s = 0;
        int e = -1;
        Arrays.sort(a, (p1, p2) -> {
            if(p1.e == p2.e) {
                return p2.s - p1.s;
            }
            return p1.e - p2.e;
        });

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(a[i].s >= e) {
                s = a[i].s;
                e = a[i].e;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static class Pair {
        int s;
        int e;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
