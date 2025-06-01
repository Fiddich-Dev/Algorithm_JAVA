package implementation;

import java.util.*;

public class BOJ17143 {

    static int r, c, m;
    static int ret = 0;
    static Shark[] sharks = new Shark[10004];
    static int[][] board = new int[104][104];
    static int[][] temp = new int[104][104];

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= m; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();
            y--;
            x--;
            d--;

            if(d <= 1) {
                s = s % (2 * (r-1));
            }
            else {
                s = s % (2 * (c-1));
            }

            sharks[i] = new Shark(y, x, s, d, z);
            board[y][x] = i;
        }

        for(int t = 0; t < c; t++) {
            // 상어잡기
            for(int i = 0; i < r; i++) {
                if(board[i][t] > 0) {
                    int id = board[i][t];
                    if(sharks[id].death == false) {
                        sharks[id].death = true;
                        ret += sharks[id].z;
                    }
                    board[i][t] = 0;
                    break;
                }
            }

            for (int i = 0; i < r; i++) {
                Arrays.fill(temp[i], 0);
            }

            // 상어 움직이기
            for(int i = 1; i <= m; i++) {
                Shark s = sharks[i];
                if(s.death) {
                    continue;
                }
                int y = s.y;
                int x = s.x;
                int dir = s.dir;
                int spd = s.s;

                while(spd > 0) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                        dir ^= 1;
                        continue;
                    }
                    y = ny;
                    x = nx;
                    spd--;
                }

                if(temp[y][x] == 0) {
                    temp[y][x] = i;
                }
                else {
                    if(sharks[temp[y][x]].z < s.z) {
                        sharks[temp[y][x]].death = true;
                        temp[y][x] = i;
                    }
                    else {
                        s.death = true;
                    }
                }

                s.y = y;
                s.x = x;
                s.dir = dir;
            }

            // 3. 보드 갱신
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    board[i][j] = temp[i][j];
                }
            }
        }



        System.out.println(ret);
    }

    static class Shark {
        int y;
        int x;
        int s;
        int dir;
        int z;
        boolean death;

        public Shark(int y, int x, int s, int dir, int z) {
            this.y = y;
            this.x = x;
            this.s = s;
            this.dir = dir;
            this.z = z;
            this.death = false;
        }
    }

}
