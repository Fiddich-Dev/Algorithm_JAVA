package baaarkingDog.simulation;

import java.util.*;

public class BOJ14499 {

    static int[][] a;
    static int[] dice = new int[6];
    static int y, x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        y = sc.nextInt();
        x = sc.nextInt();
        int k = sc.nextInt();

        a = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < k; i++) {
            int dir = sc.nextInt();
            int ny = 0;
            int nx = 0;
            if(dir == 1) {
                ny = y;
                nx = x+1;
            }
            else if(dir == 2) {
                ny = y;
                nx = x-1;
            }
            else if(dir == 3) {
                ny = y-1;
                nx = x;
            }
            else if(dir == 4) {
                ny = y+1;
                nx = x;
            }
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            y = ny;
            x = nx;
//            System.out.println(y + " : " + x);
            roll(dir);
        }
    }

    static void roll(int dir) {
        int[] temp = new int[6];

        if(dir == 1) { // 동쪽
            temp[1] = dice[1];
            temp[3] = dice[3];

            temp[2] = dice[0];
            temp[0] = dice[4];
            temp[4] = dice[5];
            temp[5] = dice[2];
        }
        else if(dir == 2) {
            temp[1] = dice[1];
            temp[3] = dice[3];

            temp[4] = dice[0];
            temp[0] = dice[2];
            temp[2] = dice[5];
            temp[5] = dice[4];
        }
        else if(dir == 3) {
            temp[2] = dice[2];
            temp[4] = dice[4];

            temp[1] = dice[0];
            temp[0] = dice[3];
            temp[3] = dice[5];
            temp[5] = dice[1];
        }
        else if(dir == 4) {
            temp[2] = dice[2];
            temp[4] = dice[4];

            temp[1] = dice[5];
            temp[5] = dice[3];
            temp[3] = dice[0];
            temp[0] = dice[1];
        }
        if(a[y][x] == 0) {
            a[y][x] = temp[5];
        }
        else {
            temp[5] = a[y][x];
            a[y][x] = 0;
        }

        for(int i = 0; i < 6; i++) {
            dice[i] = temp[i];
        }
        System.out.println(dice[0]);
    }
}
