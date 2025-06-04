package implementation;

import java.util.*;
import java.io.*;

public class BOJ1051 {

    static int n, m;
    static int[][] a = new int[54][54];
    static int ret = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        // 정사각형 최대 길이
        int mx = Math.min(n, m);


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                for(int k = 0; k < mx; k++) {
                    int y1 = i;
                    int x1 = j+k;

                    if(y1 < 0 || x1 < 0 || y1 >= n || x1 >= m) {
                        continue;
                    }

                    int y2 = i+k;
                    int x2 = j;

                    if(y2 < 0 || x2 < 0 || y2 >= n || x2 >= m) {
                        continue;
                    }

                    int y3 = i+k;
                    int x3 = j+k;

                    if(y3 < 0 || x3 < 0 || y3 >= n || x3 >= m) {
                        continue;
                    }

                    if(check(i, j, k) == true) {
                        ret = Math.max(ret, k+1);
                    }


                }

            }
        }

        System.out.println(ret * ret);



    }

    // 4꼭지점이 같으면 true
    static boolean check(int y, int x, int size) {
        int num = a[y][x];

        if(a[y+size][x] == num && a[y][x+size] == num && a[y+size][x+size] == num) {
            return true;
        }
        return false;
    }
}

