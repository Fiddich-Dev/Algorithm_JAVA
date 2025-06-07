package implementation;

import java.util.*;

public class BOJ2578 {

    static int[][] a = new int[5][5];
    static int[][] visited = new int[5][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ret = 0;

        for(int i = 0; i < 25; i++) {
            int num = sc.nextInt();
            Pair p = find(num);
            visited[p.y][p.x] = 1;

            if(check1(p.y, p.x)) {
                ret++;
            }
            if(check2(p.y, p.x)) {
                ret++;
            }
            if(check3(p.y, p.x)) {
                ret++;
            }
            if(check4(p.y, p.x)) {
                ret++;
            }

            if(ret >= 3) {
                System.out.println(i+1);
                return;
            }
        }
    }

    // 가로 체크
    static boolean check1(int y, int x) {
        int cnt = 0;
        for(int i = 0; i < 5; i++) {
            if(visited[y][i] == 1) {
                cnt++;
            }
        }
        if(cnt == 5) {
            return true;
        }
        return false;
    }

    // 세로 체크
    static boolean check2(int y, int x) {
        int cnt = 0;
        for(int i = 0; i < 5; i++) {
            if(visited[i][x] == 1) {
                cnt++;
            }
        }
        if(cnt == 5) {
            return true;
        }
        return false;
    }

    // 내리는 대각선
    static boolean check3(int y, int x) {
        int cnt = 0;

        if(y == x) {
            for(int i = 0; i < 5; i++) {
                if(visited[i][i] == 1) {
                    cnt++;
                }
            }
        }

        if(cnt == 5) {
            return true;
        }
        return false;
    }

    // 오르는 대각선
    static boolean check4(int y, int x) {
        int cnt = 0;

        if(y+x == 4) {
            for(int i = 0; i < 5; i++) {
                if(visited[i][4-i] == 1) {
                    cnt++;
                }
            }
        }

        if(cnt == 5) {
            return true;
        }
        return false;

    }



    static Pair find(int num) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(a[i][j] == num) {
                    return new Pair(i, j);
                }
            }
        }
        return null;
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
