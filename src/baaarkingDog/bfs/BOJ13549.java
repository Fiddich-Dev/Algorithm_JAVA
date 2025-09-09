package baaarkingDog.bfs;

import java.util.*;

public class BOJ13549 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[200004];
        int[] visited = new int[200004];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, 1));
        visited[n] = 1;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int idx = p.idx;
            int time = p.time;

            if(idx+1 >= 0 && idx+1 <= 200000) {
                if(visited[idx+1] == 0 || visited[idx+1] > time+1) {
                    visited[idx+1] = time+1;
                    q.add(new Pair(idx+1, time+1));
                }
            }

            if(idx-1 >= 0 && idx-1 <= 200000) {
                if(visited[idx-1] == 0 || visited[idx-1] > time+1) {
                    visited[idx-1] = time+1;
                    q.add(new Pair(idx-1, time+1));
                }
            }

            if(idx*2 >= 0 && idx*2 <= 200000) {
                if(visited[idx*2] == 0 || visited[idx*2] > time) {
                    visited[idx*2] = time;
                    q.add(new Pair(idx*2, time));
                }
            }
        }

        System.out.println(visited[m] - 1);

    }

    static class Pair {
        int idx;
        int time;

        public Pair(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}
