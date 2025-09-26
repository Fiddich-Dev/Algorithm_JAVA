package baaarkingDog.backtracking;

import java.util.*;

public class BOJ15663 {

    static int n, m;
    static int[] a;
    static int[] visited;
    static int sum = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        int prev = -1;
        for(int i = 0; i < n; i++) {
            if(visited[i] == 1) {
                continue;
            }
            if(prev == a[i]) {
                continue;
            }



            b.add(a[i]);
            visited[i] = 1;
            prev = a[i];

            go(b);

            b.remove(b.size()-1);
            visited[i] = 0;
        }
    }

}
