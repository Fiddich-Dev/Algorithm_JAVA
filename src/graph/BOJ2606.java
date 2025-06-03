package graph;

import java.util.*;
import java.io.*;

public class BOJ2606 {

    static int n, m;
    static List<Integer>[] adj = new ArrayList[104];
    static int[] visited = new int[104];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s--;
            e--;

            adj[s].add(e);
            adj[e].add(s);
        }

        System.out.println(dfs(0)-1);

    }

    static int dfs(int here) {
        visited[here] = 1;
        int cnt = 1;

        for(int there : adj[here]) {
            if(visited[there] == 0) {
                cnt += dfs(there);
            }
        }
        return cnt;
    }

}

// 0에서 탐색하는 노드의 수
