package baaarkingDog.backtracking;

import java.util.*;

public class BOJ15654 {

    static int n, m;
    static StringBuilder sb;
    static int[] a;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        visited = new int[n];

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
            if(visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            b.add(a[i]);

            go(b);

            visited[i] = 0;
            b.remove(b.size()-1);
        }
    }
}
