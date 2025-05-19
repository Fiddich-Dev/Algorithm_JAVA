package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
    
    static int n, m, v;
    static ArrayList<Integer>[] adj = new ArrayList[1004];
    static int[] visitedDFS = new int[1004];
    static int[] visitedBFS = new int[1004];

    static void dfs(int here) {
        System.out.print(here + " ");
        visitedDFS[here] = 1;

        for(int there : adj[here]) {
            if(visitedDFS[there] == 0) {
                dfs(there);
            }
        }

    }

    static void bfs(int here) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(here);
        visitedBFS[here] = 1;

        while(!q.isEmpty()) {
            Integer temp = q.poll();
            System.out.print(temp + " ");

            for(int there : adj[temp]) {
                if(visitedBFS[there] == 0) {
                    q.add(there);
                    visitedBFS[there] = visitedBFS[temp] + 1;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            adj[from].add(to);
            adj[to].add(from);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }

        dfs(v);
        System.out.println();
        bfs(v);
        System.out.println();

    }
}
