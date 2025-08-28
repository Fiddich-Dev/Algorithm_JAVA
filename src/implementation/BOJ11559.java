package implementation;

import java.util.*;

public class BOJ11559 {

    static char[][] a = new char[12][6];
    static int[][] visited = new int[12][6]; // 초기화
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static List<Pair> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 12; i++) {
            String s = sc.next();
            for(int j = 0; j < 6; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        int ret = 0;

        while(true) {
            visited = new int[12][6]; // 초기화
            int flag = 0;


            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {

                    if(visited[i][j] == 0 && a[i][j] != '.') {
                        arr = new ArrayList<>();
                        int cnt = dfs(i, j, a[i][j]);
                        if(cnt >= 4) {
                            flag = 1;
                            for(Pair p : arr) {
                                a[p.y][p.x] = '.';
                            }
                        }
                    }

                }
            }

            drop();

//            for(int i = 0; i < 12; i++) {
//                for(int j = 0; j < 6; j++) {
//                    System.out.print(a[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            if(flag == 0) {
                break;
            }

            ret++;



        }

        System.out.println(ret);
    }

    static void drop() {
        for(int i = 11; i >= 0; i--) {
            for(int j = 0; j < 6; j++) {

                if(a[i][j] != '.') {
                    move(i, j);
                }
            }
        }
    }

    static void move(int y, int x) {
        int ny = y;
        int nx = x;

        while(true) {
            ny += 1;
            nx = x;

            if(ny == 12) {
                break;
            }
            if(a[ny][nx] != '.') {
                break;
            }
        }
        if(ny-1 != y) {
            a[ny - 1][nx] = a[y][x];
            a[y][x] = '.';
        }
    }

    static int dfs(int y, int x, char c) {
        visited[y][x] = 1;
        arr.add(new Pair(y, x));
        int cnt = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6) {
                continue;
            }
            if(visited[ny][nx] == 0 && a[ny][nx] == c) {
                cnt += dfs(ny, nx, c);
            }
        }

        return cnt;
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


