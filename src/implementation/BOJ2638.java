package implementation;

import java.util.*;

public class BOJ2638 {

    static int n, m;
    static int[][] a = new int[104][104];
    static int[][] visited = new int[104][104];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    // 녹을 치즈들
    static List<Pair> cheeses = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

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
            // visited 초기화
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    visited[i][j] = 0;
                }
            }

            dfs(0, 0);

            // 치즈가 다 녹았으면 break
            if(endCheck(cheeses)) {
                break;
            }

            for(Pair p : cheeses) {
                if(check(p.y, p.x)) {
                    a[p.y][p.x] = 0;
                }
            }
            ret++;
        }

        System.out.println(ret);
    }
    // false면 치즈가 남아 있음
    static boolean endCheck(List<Pair> arr) {
        for(Pair p : arr) {
            if(a[p.y][p.x] == 1) {
                return false;
            }
        }
        return true;
    }

    // 공기만 표시, visited가 1이면 공기
    static void dfs(int y, int x) {
        visited[y][x] = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            // 공기
            if(visited[ny][nx] == 0 && a[ny][nx] == 0) {
                dfs(ny, nx);
            }
        }
    }

    // 2면 이상 공기에 닿아 있으면 true
    static boolean check(int y, int x) {
        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }

            if(visited[ny][nx] == 1) {
                cnt++;
            }
        }
        if(cnt >= 2) {
            return true;
        }
        else {
            return false;
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

// 0, 0부터 dfs를 해서 방문한 곳은 공기가 있는 곳
// dfs를 하면서 만난 1들의 좌료를 cheeses에 담음
// 치즈들을 돌면서 공기가 있는곳에 맞닿아 있는 곳이 2부분 이상이면 한번에 모아서 0으로 바꿈 ret++;



