package baaarkingDog.bfs;

import java.util.*;

public class BOJ5014 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt(); // 총 층수
        int s = sc.nextInt(); // 현재 위치
        int g = sc.nextInt(); // 스타트링크
        int u = sc.nextInt();
        int d = sc.nextInt();

        int[] nxt = {u, -d};

        int[] visited = new int[f+4];

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int there : nxt) {
                there += now;

                if(there <= 0 || there > f) {
                    continue;
                }
                if(visited[there] == 0) {
                    q.add(there);
                    visited[there] = visited[now] + 1;
                }
            }
        }

        if(visited[g] == 0) {
            System.out.println("use the stairs");
        }
        else {
            System.out.println(visited[g] - 1);
        }

    }
}
