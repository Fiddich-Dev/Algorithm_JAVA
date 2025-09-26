package baaarkingDog.simulation;

import java.util.*;

public class BOJ14503 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] a;
    static int[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int y = r;
        int x = c;
        int dir = d;
        int cnt = 0;
        while(true) {
//            System.out.println(y + " : " + x);
            if(a[y][x] == 0) {
                a[y][x] = -1;
                cnt++;
            }

            // 청소안된칸 있는지 확인
            int flag = 0; // 0이면 청소 안된칸이 없음
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(a[ny][nx] == 0) { // 청소안된 칸 찾으면
                    flag = 1;
                }
            }


            if(flag == 0) {
                int ny = y + dy[(dir+2) % 4];
                int nx = x + dx[(dir+2) % 4];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 1) {
//                    System.out.println(cnt);
//                    return;
                    break;
                }
                else {
                    y = ny;
                    x = nx;
                }
            }
            else {
                dir = (dir + 3) % 4;
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(a[ny][nx] == 0) {
                    y = ny;
                    x = nx;
                }
            }
        }


        System.out.println(cnt);
    }
}
