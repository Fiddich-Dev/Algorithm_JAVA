package implementation;

import java.util.*;

public class BOJ1652 {

    static int n;
    static char[][] a = new char[104][104];
    static char[][] temp = new char[104][104];
    static int[][] visited = new int[104][104];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j);
                temp[i][j] = a[i][j];
            }
        }

        int retC = 0;
        int retR = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0 && a[i][j] == '.') {
                    if(solve(i, j)) {
                        retC++;
                    }
                }
            }
        }

        visited = new int[104][104];
        // 회전
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = temp[j][i];
            }
        }



        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0 && a[i][j] == '.') {
                    if(solve(i, j)) {
                        retR++;
                    }
                }
            }
        }

        System.out.println(retC + " " + retR);

    }

    static boolean solve(int y, int x) {
        int cnt = 0;

        visited[y][x] = 1;
        cnt++;

        // 오른쪽으로 탐색
        while(true) {
            int ny = y + dy[1];
            int nx = x + dx[1];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                break;
            }
            if(a[ny][nx] == 'X' || visited[ny][nx] == 1) {
                break;
            }

            visited[ny][nx] = 1;
            cnt++;

            y = ny;
            x = nx;
        }

        if(cnt >= 2) {
            return true;
        }
        return false;
    }

}
