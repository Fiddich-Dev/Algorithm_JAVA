package week2;

import java.util.*;

public class BOJ2606 {


    static int solve(List<Integer>[] adj, int[] visited, int now) {
        visited[now] = 1;
        int ret = 1;

        for(int there : adj[now]) {
            if(visited[there] == 0) {
                ret += solve(adj, visited, there);
            }
        }
        return ret;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] adj = new ArrayList[n+4];
        int[] visited = new int[n+4];

        for(int i = 0; i < n+4; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        System.out.println(solve(adj, visited, 1) - 1);
    }
}
