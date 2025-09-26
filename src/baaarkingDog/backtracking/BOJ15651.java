package baaarkingDog.backtracking;

import java.util.*;

public class BOJ15651 {

    static int n, m;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();

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
        for(int i = 1; i <= n; i++) {
            b.add(i);
            go(b);
            b.remove(b.size()-1);
        }
    }
}
