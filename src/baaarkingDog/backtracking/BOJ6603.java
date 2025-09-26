package baaarkingDog.backtracking;

import java.util.*;

public class BOJ6603 {

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }
            int[] a = new int[n];
            sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            List<Integer> v = new ArrayList<>();
            combi(-1, v, a, n);

            System.out.println(sb);
        }
    }

    static void combi(int start, List<Integer> b, int[] a, int n) {
        if(b.size() == 6) {
            for(int i : b) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start+1; i < n; i++) {
            b.add(a[i]);
            combi(i, b, a, n);
            b.remove(b.size()-1);
        }
    }
}
