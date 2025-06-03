package implementation;

import java.util.*;
import java.io.*;

public class BOJ1018 {

    static int n, m;
    static char[][] a = new char[54][54];
    static char[] c = {'B', 'W'};
    static int ret = Integer.MAX_VALUE;

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

        // 가능한 시작점
        for(int i = 0; i <= n-8; i++) {
            for(int j = 0; j <= m-8; j++) {
                ret = Math.min(ret, check(i, j));
            }
        }

        System.out.println(ret);

    }

    static int check(int y, int x) {
        int cnt = 0;

        for(int i = y; i < y+8; i++) {
            // B로 시작
            for(int j = x; j < x+8; j++) {
                if((i+j) % 2 == 0) {
                    if(a[i][j] != 'B') {
                        cnt++;
                    }
                }
                else {
                    if(a[i][j] != 'W') {
                        cnt++;
                    }
                }
            }
        }

        return Math.min(cnt, 64-cnt);
    }
}
