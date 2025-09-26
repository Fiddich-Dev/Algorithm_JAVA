package baaarkingDog.simulation;

import java.util.*;

public class BOJ18808 {

    static int n, m, k;
    static int[][] a;
    static Pair[] pos;
    static int[][][] stickers = new int[100][10][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        a = new int[n][m];
        pos = new Pair[k];


        for(int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            pos[i] = new Pair(r, c);
            for(int j = 0; j < r; j++) {
                for(int l = 0; l < c; l++) {
                    stickers[i][j][l] = sc.nextInt();
                }
            }
        }

        for(int i = 0; i < k; i++) {
            if(putSticker1(i)) {
                continue;
            }
            if(putSticker2(i)) {
                continue;
            }
            if(putSticker3(i)) {
                continue;
            }
            if(putSticker4(i)) {
                continue;
            }
        }

//        go(0, 0, 0);

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    static boolean putSticker1(int num) {
        int r = pos[num].y;
        int c = pos[num].x;

        int[][] temp = stickers[num];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(check(i, j, temp, r, c)) {
                    fill(i, j, temp, r, c);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean putSticker2(int num) {
        int r = pos[num].y;
        int c = pos[num].x;

        int[][] temp = rotate90(num);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(check(i, j, temp, c, r)) {
                    fill(i, j, temp, c, r);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean putSticker3(int num) {
        int r = pos[num].y;
        int c = pos[num].x;

        int[][] temp = rotate180(num);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(check(i, j, temp, r, c)) {
                    fill(i, j, temp, r, c);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean putSticker4(int num) {
        int r = pos[num].y;
        int c = pos[num].x;

        int[][] temp = rotate270(num);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(check(i, j, temp, c, r)) {
                    fill(i, j, temp, c, r);
                    return true;
                }
            }
        }
        return false;
    }

    static void go(int y, int x, int num) {

        // 마지막 스티커까지 탐색했을떄
        if(num == k) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(a[i][j] == 1) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            System.exit(0);
            return;
        }

        if(y == n) {
            go(0, 0, num+1);
            return;
        }


        int[][] temp = stickers[num];
        int r = pos[num].y;
        int c = pos[num].x;
        if(check(y, x, temp, r, c)) {
            fill(y, x, temp, r, c);
            go(0, 0, num+1);
        }
        else {
            temp = rotate90(num);
            if(check(y, x, temp, c, r)) {
                fill(y, x, temp, c, r);
                go(0, 0, num+1);
            }
            else {
                temp = rotate180(num);
                if(check(y, x, temp, r, c)) {
                    fill(y, x, temp, r, c);
                    go(0, 0, num+1);
                }
                else {
                    temp = rotate270(num);
                    if(check(y, x, temp, c, r)) {
                        fill(y, x, temp, c, r);
                        go(0, 0, num+1);
                    }
                    else {
                        int nx = x+1 == m ? 0 : x+1;
                        int ny = nx == 0 ? y+1 : y;
                        go(ny, nx, num);
                    }
                }

            }
        }


    }

    static void fill(int y, int x, int[][] temp, int r, int c) {

        for(int i = y; i < y+r; i++) {
            for(int j = x; j < x+c; j++) {
                a[i][j] += temp[i-y][j-x];
            }
        }
    }

    static boolean check(int y, int x, int[][] temp, int r, int c) {

        if(y+r > n || x+c > m) {
            return false;
        }

        for(int i = y; i < y+r; i++) {
            for(int j = x; j < x+c; j++) {
                if(a[i][j] == 1 && temp[i-y][j-x] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static int[][] rotate90(int num) {
        int[][] org = stickers[num];
        int r = pos[num].y; // 3
        int c = pos[num].x; // 2

        int[][] temp = new int[10][10];

        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                temp[i][j] = org[r-1-j][i];
            }
        }

        return temp;
    }

    static int[][] rotate180(int num) {
        int[][] org = stickers[num];
        int r = pos[num].y; // 3
        int c = pos[num].x; // 2

        int[][] temp = new int[10][10];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                temp[i][j] = org[r-1-i][c-1-j];
            }
        }

        return temp;
    }

    static int[][] rotate270(int num) {
        int[][] org = stickers[num];
        int r = pos[num].y; // 3
        int c = pos[num].x; // 2

        int[][] temp = new int[10][10];

        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                temp[i][j] = org[j][c-1-i];
            }
        }

        return temp;
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

// 1600 * 100 * 4 * 100


