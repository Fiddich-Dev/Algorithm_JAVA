package bruteforcing;

import java.util.*;
import java.io.*;

public class BOJ9663 {

    static int n;
    static int[][] a = new int[18][18];
    static int ret = 0;
    static int[] visited = new int[18];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        go(0);

        System.out.println(ret);

    }

    static void go(int y) {
        if(y == n) {
            ret++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0 && check(y, i) == true) {
                a[y][i] = 1;
                visited[i] = 1;

                go(y+1);

                a[y][i] = 0;
                visited[i] = 0;
            }
        }
    }

    static boolean check(int y, int x) {
        // 세로 확인
        for(int i = 0; i < n; i++) {
            if(a[i][x] == 1) {
                return false;
            }
        }



        // 대각선 확인
        int nowY = y;
        int nowX = x;
        while(true) {
            int ny = nowY-1;
            int nx = nowX+1;
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                break;
            }
            if(a[ny][nx] == 1) {
                return false;
            }
            nowY = ny;
            nowX = nx;
        }
        nowY = y;
        nowX = x;
        while(true) {
            int ny = nowY+1;
            int nx = nowX-1;
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                break;
            }
            if(a[ny][nx] == 1) {
                return false;
            }
            nowY = ny;
            nowX = nx;
        }
        nowY = y;
        nowX = x;
        while(true) {
            int ny = nowY+1;
            int nx = nowX+1;
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                break;
            }
            if(a[ny][nx] == 1) {
                return false;
            }
            nowY = ny;
            nowX = nx;
        }
        nowY = y;
        nowX = x;
        while(true) {
            int ny = nowY-1;
            int nx = nowX-1;
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                break;
            }
            if(a[ny][nx] == 1) {
                return false;
            }
            nowY = ny;
            nowX = nx;
        }
        return true;
    }

}

