package implementation;

import java.util.*;

public class BOJ14500 {
    
    static int n, m;
    static int[][] map = new int[504][504];
    static int[][] visited = new int[504][504];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};


    static int ret = 0;

    // true면 맵 안쪽
    static boolean check(int y, int x) {
        if(y < 0 || x < 0 || y >= n || x >= m) {
            return false;
        }
        return true;
    }


    static int solve(int y, int x) {
        // // 세로
        // int temp1 = map[y][x] + map[y+1][x] + map[y+2][x];
        // // 가로
        // int temp2 = map[y][x] + map[y][x+1] + map[y][x+2];
        int q = 0;
        int w = 0;
        int e = 0;
        int r = 0;

        if(check(y, x) && check(y+1, x) && check(y+2, x) && check(y+1, x+1)) {
            q = map[y][x] + map[y+1][x] + map[y+2][x] + map[y+1][x+1];
        }

        if(check(y, x) && check(y+1, x) && check(y+2, x) && check(y+1, x-1)) {
            w = map[y][x] + map[y+1][x] + map[y+2][x] + map[y+1][x-1];
        }


        if(check(y, x) && check(y, x+1) && check(y, x+2) && check(y-1, x+1)) {
            e = map[y][x] + map[y][x+1] + map[y][x+2] + map[y-1][x+1];
        }

        if(check(y, x) && check(y, x+1) && check(y, x+2) && check(y+1, x+1)) {
            r = map[y][x] + map[y][x+1] + map[y][x+2] + map[y+1][x+1];
        }

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(q);
        arr.add(w);
        arr.add(e);
        arr.add(r);

        return Collections.max(arr);
        
    }

    static void dfs(int y, int x, int cnt, int sum) {
        visited[y][x] = 1;
        cnt++;
        sum += map[y][x];

        
        // System.out.println(sum);
        if(cnt == 4) {
            ret = Math.max(ret, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if(visited[ny][nx] == 0) {
                dfs(ny, nx, cnt, sum);
                visited[ny][nx] = 0;
            }
        }
    }   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                visited[i][j] = 0;

                ret = Math.max(ret, solve(i, j));
            }
        }
        
        
        

        System.out.println(ret);


    }
}
