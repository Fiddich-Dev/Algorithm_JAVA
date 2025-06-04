package implementation;

import java.util.*;
import java.io.*;

public class BOJ2580 {

    static int[][] a = new int[10][10];
    static List<Pair> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] == 0) {
                    arr.add(new Pair(i, j));
                }
            }
        }

        go(0);
    }

    static void go(int cnt) {
        if(cnt == arr.size()) {

            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        int y = arr.get(cnt).y;
        int x = arr.get(cnt).x;

        for(int i = 1; i <= 9; i++) {
            if(check(y, x, i) == true) {
                a[y][x] = i;
                go(cnt+1);
                a[y][x] = 0;
            }
        }

    }

    static boolean check(int y, int x, int num) {
        for(int i = 0; i < 9; i++) {
            if(a[i][x] == num) {
                return false;
            }
            if(a[y][i] == num) {
                return false;
            }
        }

        for(int i = y/3 * 3; i < y/3*3+3; i++) {
            for(int j = x/3 * 3; j < x/3*3+3; j++) {
                if(a[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }


    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
// arr를 돌면서 1~9까지 넣으면서 check1, check2, check3을 한다
// 다 true이면 다음 arr로 가서 1~9까지 넣어본다
// 도중에 되는게 없으면 백트래킹