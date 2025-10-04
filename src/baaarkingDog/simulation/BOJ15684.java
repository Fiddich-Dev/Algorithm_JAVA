package baaarkingDog.simulation;

import java.util.*;
import java.io.*;

public class BOJ15684 {

    static int n, m, h;
    static int[][] a;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        a = new int[h][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        go(0, 0, 0);

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ret);
        }


    }

    static void go(int y, int x, int cnt) {
        if(cnt == 3) {
            if(check()) {
                ret = Math.min(ret, cnt);
            }
            return;
        }

        if(check()) {
            ret = Math.min(ret, cnt);
        }
        if(y == h) {
            return;
        }

        int nx;
        int ny;
        nx = x+1 == n-1 ? 0 : x+1;
        ny = nx == 0 ? y+1 : y;

        boolean flag = true;
        if(a[y][x] == 1) {
            flag = false;
        }
        if(x-1 >= 0 && a[y][x-1] == 1) {
            flag = false;
        }
        if(x+1 < n && a[y][x+1] == 1) {
            flag = false;
        }

        if(flag) {
//            nx = x+1 == n-1 ? 0 : x+1;
//            ny = nx == 0 ? y+1 : y;

            a[y][x] = 1;
            go(ny, nx, cnt+1);
            a[y][x] = 0;
        }

        // 사다리 안놓기

        go(ny, nx, cnt);
    }

    static boolean check() {
        for(int i = 0; i < n; i++) {
            int now = i;
            for(int j = 0; j < h; j++) {
                if(a[j][now] == 1) {
                    now++;
                }
                else if(now-1 >= 0 && a[j][now-1] == 1) {
                    now--;
                }
            }
            if(now != i) {
                return false;
            }
        }
        return true;
    }
}
