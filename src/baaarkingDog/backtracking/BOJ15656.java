package baaarkingDog.backtracking;

import java.util.*;

public class BOJ15656 {

    static int n, m;
    static int[] a;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        List<Integer> v = new ArrayList<>();

        go(v);

        System.out.println(sb);
    }

    static void go(List<Integer> b) {
        if(b.size() == m) {
            for(int i : b) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            b.add(a[i]);
            go(b);
            b.remove(b.size()-1);
        }
    }

}
