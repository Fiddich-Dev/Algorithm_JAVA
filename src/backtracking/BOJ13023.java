package backtracking;

import java.util.*;
import java.io.*;

public class BOJ13023 {

    static int ret = 0;
    static int n, m;
    static List<Integer>[] adj = new ArrayList[2004];
    static int[] visited = new int[2004];

    // 0에서 탐색할떄 1이 있어야함
    // 1에서 탐색할떄 2이 있어야함
    // n-2에서 탐색할떄 n-1이 있어야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }


        for(int i = 0; i < n; i++) {

            if(ret == 1) {
                break;
            }

            for(int j = 0; j < 2004; j++) {
                visited[j] = 0;
            }

            visited[i] = 1;
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

        for(int there : adj[here]) {
            if(visited[there] == 0) {
                visited[there] = 1;
                dfs(there, depth+1);
                visited[there] = 0;
            }
        }
    }


}
