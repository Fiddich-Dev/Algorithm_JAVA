package baaarkingDog.bfs;

import java.util.*;

public class BOJ9466 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            int[] a = new int[n+1];
            int[] visited = new int[n+1];
            boolean[] isTeam = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();

            for(int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }



            for(int i = 1; i <= n; i++) {
                if(visited[i] == 0) {
                    int start = -1;
                    q.add(i);
                    visited[i] = i;

                    while(!q.isEmpty()) {
                        int here = q.poll();
                        int there = a[here];

                        if(visited[there] == i) {
                            start = there;
                        }
                        if(visited[there] == 0) {
                            q.add(there);
                            visited[there] = i;
                        }
                    }

                    if(start != -1) {
                        while(!isTeam[start]) {
                            isTeam[start] = true;
                            start = a[start];
                        }
                    }
                }

            }

            int ret = 0;
            for(int i = 1; i <= n; i++) {
                if(!isTeam[i]) {
                    ret++;
                }
            }

            System.out.println(ret);
        }
    }
}
