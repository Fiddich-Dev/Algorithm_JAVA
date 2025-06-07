package implementation;

import java.util.*;
import java.io.*;

// 극이 다르면 반대로 회전함
// 극이 같으면 회전안함

public class BOJ14891 {

    static int[][] a = new int[4][8];
    static int k;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < 8; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            // 1 시계, -1 반시계
            int dir = Integer.parseInt(st.nextToken());

            solve(idx, dir);
        }

        int ret = 0;

        for(int i = 0; i < 4; i++) {
            if(a[i][0] == 1) {
                ret += (1 << i);
            }
        }

        System.out.println(ret);
    }

    // 3시 방향은 2번 인덱스
    // 9시 방향은 6번 인덱스

    // 돌릴 톱니바퀴 찾기
    static void solve(int idx, int dir) {
        int nowD = dir;

        List<Pair> arr = new ArrayList<>();

        arr.add(new Pair(idx, dir));

        // 오른쪽 확인
        for(int i = idx; i < 3; i++) {
            if(a[i][2] != a[i+1][6]) {
                nowD *= -1;
                arr.add(new Pair(i+1, nowD));
            }
            else {
                break;
            }
        }
        // 왼쪽 확인
        nowD = dir;
        for(int i = idx; i > 0; i--) {
            if(a[i][6] != a[i-1][2]) {
                nowD *= -1;
                arr.add(new Pair(i-1, nowD));
            }
            else {
                break;
            }
        }

        for(Pair p : arr) {
            roll(p.idx, p.dir);
        }
    }

    // 1 시계, -1 반시계
    static void roll(int idx, int dir) {

        if(dir == 1) {
            int temp = a[idx][7];
            for(int i = 6; i >= 0; i--) {
                a[idx][i+1] = a[idx][i];
            }
            a[idx][0] = temp;
        }
        else {
            int temp = a[idx][0];
            for(int i = 1; i <= 7; i++) {
                a[idx][i-1] = a[idx][i];
            }
            a[idx][7] = temp;
        }

    }

    static class Pair {
        int idx;
        int dir;

        public Pair(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }
}

