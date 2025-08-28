package backtracking;

import java.util.*;
import java.io.*;

public class BOJ13023 {

    static int n, m;
    static List<Integer>[] adj = new ArrayList[2004];
    static int[] visited = new int[2004];
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 0; i < n; i++) {
            visited = new int[2004];
            dfs(i, 1);
        }

        System.out.println(ret);

    }

    static void dfs(int here, int depth) {
        if(ret == 1) {
            return;
        }

        if(depth == 5) {
            ret = 1;
            return;
        }

        visited[here] = 1;

        for(int there : adj[here]) {
            if(visited[there] == 0) {
                dfs(there, depth+1);
            }
        }

        visited[here] = 0;
    }
}
