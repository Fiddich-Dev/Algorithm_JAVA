package saffy;

import java.util.*;

public class SWEA1244 {

    static String s;
    static int[] a;
    static int n;
    static int ret;
    static List<Pair> arr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 1; q <= t; q++) {
            s = sc.next();
            n = sc.nextInt();
            a = new int[s.length()];
            for(int i = 0; i < s.length(); i++) {
                a[i] = s.charAt(i) - '0';
            }

            arr = new ArrayList<>(); // 바꿀 쌍들의 집함
            // 이중 n개를 중복해서 뽑으면됩
            List<Integer> v = new ArrayList<>();
            combi(-1, v);



            ret = calc();
            go(0, 0);

            System.out.println("#" + q + " " + ret);

        }
    }

    static void combi(int start, List<Integer> b) {
        if(b.size() == 2) {
            arr.add(new Pair(b.get(0), b.get(1)));
            return;
        }
        for(int i = start+1; i < s.length(); i++) {
            b.add(i);
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    static void go(int start, int cnt) {
//        System.out.println("asd");

        if (cnt == n) {
            ret = Math.max(ret, calc());
            return;
        }


        for (int i = start; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                swap(i, j);
                go(i, cnt + 1);
                swap(i, j);
            }
        }
    }

    static int calc() {
        int now = 1;
        int sum = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            sum += a[i] * now;
            now *= 10;
        }
        return sum;
    }

    static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
