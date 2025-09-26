package baaarkingDog.backtracking;

import java.util.*;

public class BOJ15655 {

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
        combi(-1, v);

        System.out.println(sb);
    }

    static void combi(int start, List<Integer> b) {
        if(b.size() == m) {
            for(int i : b) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start+1; i < n; i++) {
            b.add(a[i]);
            combi(i, b);
            b.remove(b.size()-1);
        }
    }
}
