package implementation;

import java.util.*;
import java.io.*;

public class BOJ8979 {

    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        List<Status> a = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int q = sc.nextInt();
            int w = sc.nextInt();
            int e = sc.nextInt();
            int r = sc.nextInt();

            a.add(new Status(q, w, e, r));
        }

        a.sort((s1, s2) -> {
            if(s1.g == s2.g) {
                if(s1.s == s2.s) {
                    return s2.b - s1.b;
                }
                return s2.s - s1.s;
            }
            return s2.g - s1.g;
        });

        // 등수
        List<Integer> rank = new ArrayList<>();
        int now = 1;
        rank.add(now);
        for(int i = 1; i < n; i++) {
            if(isEqual(a.get(i-1), a.get(i))) {
                rank.add(now);
            }
            else {
                now = i+1;
                rank.add(now);
            }
        }

        for(int i = 0; i < n; i++){
            if(a.get(i).num == k) {
                System.out.println(rank.get(i));
                return;
            }
        }
    }

    static boolean isEqual(Status s1, Status s2) {
        if(s1.g == s2.g && s1.s == s2.s && s1.b == s2.b) {
            return true;
        }
        return false;
    }

    static class Status {
        int num;
        int g;
        int s;
        int b;

        public Status(int num, int g, int s, int b) {
            this.num = num;
            this.g = g;
            this.s = s;
            this.b = b;
        }
    }
}
