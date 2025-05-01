package implementation;

import java.util.Scanner;

class Pair {
    int y;
    int x;
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ13460 {
    static int n, m;
    static char[][] a = new char[14][14];
    static int[][][][] dp = new int[14][14][14][14];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static Pair r = new Pair(0, 0);
    static Pair b = new Pair(0, 0);


    static void moveR(int num) {
        while(true) {
            int ny = r.y + dy[num];
            int nx = r.x + dx[num];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                break;
            }
            if(a[ny][nx] == '#' || a[ny][nx] == 'B') {
                break;
            }
            if(a[ny][nx] == '0') {
                // 구멍에 빠질때
                // 움직한 횟수 세야함
                r.y = ny;
                r.x = nx;
                break;
            }

            // r.y = ny;
            // r.x = nx;
        }

    }
    static void moveB(int num) {
        while(true) {
            int ny = b.y + dy[num];
            int nx = b.x + dx[num];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                break;
            }
            if(a[ny][nx] == '#' || a[ny][nx] == 'R') {
                break;
            }
            if(a[ny][nx] == '0') {
                // 구멍에 빠질때
                // 움직한 횟수 세야함
                // r.y = ny;
                // r.x = nx;
                break;
            }

            r.y = ny;
            r.x = nx;
        }
    }

    

    // 더 위에 있는게 먼저 움직임
    static void up() {
        if(r.y < b.y) {
            moveR(0);
            moveB(0);
        }
        else {
            moveB(0);
            moveR(0);
        }
    }

    // 더 오른쪽 있는게 먼저 움직임
    static void right() {
        if(r.x > b.x) {
            moveR(1);
            moveB(1);
        }
        else {
            moveB(1);
            moveR(1);
        }
    }

    // 더 밑에 있는게 먼저 움직임
    static void down() {
        if(r.y > b.y) {
            moveR(2);
            moveB(2);
        }
        else {
            moveB(2);
            moveR(2);
        }
    }

    // 더 위에 있는게 먼저 움직임
    static void left() {
        if(r.x < b.x) {
            moveR(3);
            moveB(3);
        }
        else {
            moveB(3);
            moveR(3);
        }
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                if(a[i][j] == 'R') {
                    r.y = i;
                    r.x = j;
                }
                else if(a[i][j] == 'B') {
                    b.y = i;
                    b.x = j;
                }
            }
        }

        
    }
}
