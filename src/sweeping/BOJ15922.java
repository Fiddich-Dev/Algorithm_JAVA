package sweeping;

import java.util.*;
import java.io.*;

public class BOJ15922 {

    static int n;
    static List<Pair> a = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            a.add(new Pair(s, e));
        }

        int start = a.get(0).s;
        int end = a.get(0).e;
        int ret = end - start;
        for(int i = 1; i < n; i++) {
            if(a.get(i).e <= end) {
                continue;
            }

            int s = Math.max(end, a.get(i).s);
            int e = a.get(i).e;
            ret += e - s;
            end = e;
        }

        System.out.println(ret);
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
