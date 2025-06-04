package backtracking;

import java.util.*;
import java.io.*;

public class BOJ13023 {

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
            for(int j = 0; j < 2004; j++) {
                visited[j] = 0;
            }
            bfs(i);
            if(visited[i+1] != 0) {

            }
        }
        System.out.println(0);


//        System.out.println(dfs(1));

//        if(check()) {
//            System.out.println(1);
//        }
//        else {
//            System.out.println(0);
//        }

    }

    static boolean check() {
        for(int i = 0; i < 2004; i++) {
            visited[i] = 0;
        }
        for(int i = 0; i < n; i++) {
            if(dfs(i) != n) {
                return false;
            }
        }
        return true;
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

    static void bfs(int here) {
        int ret = 1;
        visited[here] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(here);

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int there : adj[now]) {
                if(visited[there] == 0) {
                    q.add(there);
                    visited[there] = visited[now] + 1;
                    ret = Math.max(ret, visited[there]);
                }
            }
        }

    }


}
