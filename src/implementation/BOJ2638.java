package implementation;

import java.util.*;

public class BOJ2638 {

    static int n, m;
    static int[][] a = new int[104][104];
    static int[][] visited = new int[104][104];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        List<Pair> cheeses = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 1) {
                    cheeses.add(new Pair(i, j));
                }
            }
        }

        int ret = 0;


        while(true) {

            visited = new int[104][104];
            // 공기층 찾아서 -1로 바꾸기
            dfs(0, 0);


            int cheeseCnt = 0;
            for(Pair p : cheeses) {
                if(a[p.y][p.x] == 1) {
                    cheeseCnt++;
                }
            }
            if(cheeseCnt == 0) {
                break;
            }

            ret++;
            // 치즈 녹이기
            for(Pair p : cheeses) {
                int y = p.y;
                int x = p.x;

                if(a[y][x] != 1) {
                    continue;
                }

                int cnt = 0;

                for(int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(a[ny][nx] == -1) {
                        cnt++;
                    }
                }

                if(cnt >= 2) {
                    a[y][x] = 0;
                }
            }


        }
        System.out.println(ret);

    }

    static void dfs(int y, int x) {

        a[y][x] = -1;
        visited[y][x] = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if(visited[ny][nx] == 0 && a[ny][nx] != 1) {
                dfs(ny, nx);
            }
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

// 진짜 공기층만 찾기
// 녹을 치즈 찾기
// 시간 늘리고, 녹이기




