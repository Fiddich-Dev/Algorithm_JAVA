package baaarkingDog.bfs;

import java.util.*;

public class BOJ1697 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] visited = new int[200004];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();
            int[] nx = {now-1, now+1, now*2};
            for(int there : nx) {
                if(there < 0 || there > 200000) {
                    continue;
                }
                if(visited[there] == 0) {
                    q.add(there);
                    visited[there] = visited[now] + 1;
                }
            }
        }

        System.out.println(visited[m] - 1);
    }
}
