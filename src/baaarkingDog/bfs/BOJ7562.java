package baaarkingDog.bfs;

import java.util.*;

public class BOJ7562 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int qq = 0; qq < t; qq++) {
            int l = sc.nextInt();
            int[][] a = new int[l][l];
            int[][] visited = new int[l][l];
            int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
            int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};

            Queue<Pair> q = new LinkedList<>();

            Pair start = new Pair(sc.nextInt(), sc.nextInt());
            q.add(start);
            visited[start.y][start.x] = 1;

            Pair end = new Pair(sc.nextInt(), sc.nextInt());

            while(!q.isEmpty()) {
                Pair p = q.poll();
                int y = p.y;
                int x = p.x;
                for(int i = 0; i < 8; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= l || nx >= l) {
                        continue;
                    }
                    if(visited[ny][nx] == 0) {
                        q.add(new Pair(ny, nx));
                        visited[ny][nx] = visited[y][x] + 1;
                    }
                }
            }

            System.out.println(visited[end.y][end.x] - 1);
        }
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
