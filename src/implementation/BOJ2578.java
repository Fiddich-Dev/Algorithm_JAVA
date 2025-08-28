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

        int cnt = 0;

        for(int i = 0; i < 25; i++) {
            int num = sc.nextInt();
            Pair pos = find(num);
            int y = pos.y;
            int x = pos.x;
            visited[y][x] = 1;
            if(check1(y, x)) {
                cnt++;
            }
            if(check2(y, x)) {
                cnt++;
            }
            if(check3(y, x)) {
                cnt++;
            }
            if(check4(y, x)) {
                cnt++;
            }

            if(cnt >= 3) {
                System.out.println(i+1);

                return;
            }
        }
    }

    static boolean check1(int y, int x) {
        for(int i = 0; i < 5; i++) {
            if(visited[y][i] == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean check2(int y, int x) {
        for(int i = 0; i < 5; i++) {
            if(visited[i][x] == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean check3(int y, int x) {
        if(y != x) {
            return false;
        }

        for(int i = 0; i < 5; i++) {
            if(visited[i][i] == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean check4(int y, int x) {
        if(y + x != 4) {
            return false;
        }

        for(int i = 0; i < 5; i++) {
            if(visited[i][4-i] == 0) {
                return false;
            }
        }
        return true;
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
