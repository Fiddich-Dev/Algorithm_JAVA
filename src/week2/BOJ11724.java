package week2;

import java.util.*;

public class BOJ11724 {
    static int n, m;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] visited = new int[1004];
    static int ret = 0;


    static void dfs(int here) {
        visited[here] = 1;

        for(int there : adj.get(here)) {

            if(visited[there] == 0) {
                dfs(there);
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int q = sc.nextInt();
            int w = sc.nextInt();

            adj.get(q).add(w);
            adj.get(w).add(q);
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) {
                dfs(i);
                ret++;
            }
        }

        System.out.println(ret);
    }
}
