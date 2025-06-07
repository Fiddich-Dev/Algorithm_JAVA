package backtracking;

import java.util.*;
import java.io.*;


public class BOJ15649 {

    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] visited = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> v = new ArrayList<>();
        go(v, visited);
        System.out.println(sb);
    }

    static void go(List<Integer> b, int[] visited) {
        if(b.size() == m) {
            for(int i : b) {
                sb.append(i).append(" ");
            }
            sb.append("\n");

            return;
        }
        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) {
                b.add(i);
                visited[i] = 1;

                go(b, visited);

                b.remove(b.size() - 1);
                visited[i] = 0;
            }
        }
    }
}
