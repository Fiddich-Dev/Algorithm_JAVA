package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18111 {

    static int n, m, b;
    static int[][] a = new int[504][504];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ret = Integer.MAX_VALUE;
        int h = -1;

        for(int i = 0; i <= 256; i++) {
            int time = solve(i, b);
            if(time != -1) {
                if(time <= ret) {
                    ret = time;
                    h = i;
                }
            }
        }

        System.out.println(ret + " " + h);


    }

    // 걸리는 시간 리턴
    static int solve(int h, int block) {
        // 필요한 블럭 수
        int cnt = 0;
        int time = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int temp = h - a[i][j];
                // 블럭이 필요할때
                if(temp > 0) {
                    time += temp;
                    cnt += temp;
                }
                // 블록을 제거해야할때
                else if(temp < 0) {
                    time += -2 * temp;
                    block += -1 * temp;
                }

            }
        }

        if(cnt <= block) {
            return time;
        }
        else {
            return -1;
        }
    }
}
// 블록 제거 2초
// 블록 추가 1초

// 높이는 0 ~ 256



