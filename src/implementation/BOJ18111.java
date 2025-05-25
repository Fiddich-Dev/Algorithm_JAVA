package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18111 {
    
    static int n, m, b;
    static int[][] a = new int[504][504];


    // 걸린 시간
    static int ret1 = Integer.MAX_VALUE;
    // 땅 높이
    static int ret2 = 0;

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

        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i <= 256; i++) {

            // 초기 불럭
            int sum = b;

            // 걸린 시간
            int t = 0;

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    // 목표가 높으면
                    if(i > a[j][k]) {
                        t += i - a[j][k];
                        sum -= (i - a[j][k]);
                    }
                    else if(i < a[j][k]) {
                        t += (a[j][k] - i) * 2;
                        sum += (a[j][k] - i);
                    }
                }
            }

            if(sum < 0) {
                continue;
            }
            if(ret1 >= t) {
                ret1 = t;
                ret2 = i;
            }

        }

        System.out.println(ret1 + " " + ret2);


    }
}
// 블록 제거 2초
// 블록 추가 1초

// 평균을 구한다
// 평균을 반올림한다


// 1 1 1
// 1 1 1
// 1 1 0

// 평균 0.9

// 0으로 하면 


// 256 * 250000
