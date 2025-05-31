package implementation;

import java.util.*;
import java.io.*;

public class BOJ14719 {

    static int n, m;
    // 블록인 1, 빈칸은 0
    static int[][] map = new int[504][504];
    static int[] a = new int[504];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            for(int j = n-1; j >= n-a[i]; j--) {
                map[j][i] = 1;

            }
        }


        int ret = 0;

        for(int i = 0; i < n; i++) {
            ret += solve(i);
        }

        System.out.println(ret);

    }

    static int solve(int h) {

        int y = n-h-1;  // n-1 ~ 0
        int x = 0;      // 0 ~ m-1

        int cnt = 0;

        int startBlock = -1;
        int endBlock = -1;
        // 0이먄 시작블럭 못참음, 1이면 찾음
        int flag = 0;
        for(int i = 0; i < m; i++) {
            // 블럭이 있을때
            if(map[y][i] == 1) {
                if(flag == 0) {
                    startBlock = i;
                    flag = 1;
                }
                else {
                    endBlock = i;
                }
            }
        }
        // 시작만 찾을떄 // 안됨
        // 둘다 못찾을떄 // 안됨


        // 시작과 끝 다 찾을때 //됨
        if(startBlock != -1 && endBlock != -1) {
            for(int i = startBlock; i < endBlock; i++) {
                if(map[y][i] == 0) {
                    cnt++;
                }
            }
        }



        return cnt;

    }
}

