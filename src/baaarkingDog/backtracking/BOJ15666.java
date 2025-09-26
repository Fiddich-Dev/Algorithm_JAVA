package baaarkingDog.backtracking;

import java.util.*;

public class BOJ15666 {

    static int n, m;
    static int[] a;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        List<Integer> v = new ArrayList<>();
        go(0, v);

        System.out.println(sb);
    }

    static void go(int start, List<Integer> b) {
        if(b.size() == m) {
            for(int i : b) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i = start; i < n; i++) {
            if(prev == a[i]) {
                continue;
            }

            b.add(a[i]);
            prev = a[i];

            go(i, b);

            b.remove(b.size()-1);
        }
    }
}
