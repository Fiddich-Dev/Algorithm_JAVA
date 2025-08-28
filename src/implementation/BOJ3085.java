package implementation;

import java.util.*;

public class BOJ3085 {

    static int n;
    static char[][] a = new char[54][54];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        int ret = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                int y = i;
                int x = j;

                for(int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    char temp = a[y][x];
                    a[y][x] = a[ny][nx];
                    a[ny][nx] = temp;

                    ret = Math.max(ret, check1(y, x));
                    ret = Math.max(ret, check2(y, x));
                    ret = Math.max(ret, check1(ny, nx));
                    ret = Math.max(ret, check2(ny, nx));

                    temp = a[y][x];
                    a[y][x] = a[ny][nx];
                    a[ny][nx] = temp;


                }

            }
        }

        System.out.println(ret);

    }

    static int check1(int y, int x) {
        char c = a[y][x];
        int cnt = 1;

        for(int i = x+1; i < n; i++) {
            if(a[y][i] == c) {
                cnt++;
            }
            else {
                break;
            }
        }

        for(int i = x-1; i >= 0; i--) {
            if(a[y][i] == c) {
                cnt++;
            }
            else {
                break;
            }
        }

        return cnt;
    }

    static int check2(int y, int x) {
        char c = a[y][x];
        int cnt = 1;

        for(int i = y+1; i < n; i++) {
            if(a[i][x] == c) {
                cnt++;
            }
            else {
                break;
            }
        }

        for(int i = y-1; i >= 0; i--) {
            if(a[i][x] == c) {
                cnt++;
            }
            else {
                break;
            }
        }

        return cnt;
    }
}



