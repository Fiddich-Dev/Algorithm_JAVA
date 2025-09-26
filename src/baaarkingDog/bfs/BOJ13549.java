package baaarkingDog.bfs;

import java.util.*;

public class BOJ13549 {

    static int n, m;
    static int[] visited = new int[200004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while(!q.isEmpty()) {
            int here = q.poll();
//            System.out.println(here);

            int there = here - 1;
            if(there < 0 || there > 200000) {

            }
            else {
                if (visited[there] == 0) {
                    q.add(there);
                    visited[there] = visited[here] + 1;
                }
            }

            there = here + 1;
            if(there < 0 || there > 200000) { }
            else {
                if (visited[there] == 0) {
                    q.add(there);
                    visited[there] = visited[here] + 1;
                }
            }

            there = here * 2;
            while(there <= 200000 && there != 0) {
                if(visited[there] == 0) {
                    visited[there] = visited[here];
                }
                else {
                    visited[there] = Math.min(visited[there], visited[here]);
                }
                q.add(there);
                there *= 2;
            }
        }

        System.out.println(visited[m]-1);

    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
