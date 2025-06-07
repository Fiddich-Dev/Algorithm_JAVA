package implementation;

import java.util.*;

public class BOJ11559 {

    static char[][] a = new char[12][6];
    static int[][] visited = new int[12][6];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Pair> arr;


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


//            for(int i = 0; i < 12; i++) {
//                for(int j = 0; j < 6; j++) {
//                    System.out.print(a[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println();

            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    visited[i][j] = 0;
                }
            }



            int cnt = 0;

            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    if(visited[i][j] == 0 && a[i][j] != '.') {
                        arr = new ArrayList<>();

                        dfs(i, j, a[i][j]);

                        if(arr.size() >= 4) {
                            cnt++;
                            for(Pair p : arr) {
                                a[p.y][p.x] = '.';
                            }
                        }

                    }
                }
            }

            // 종료조건
            if(cnt == 0) {
                break;
            }

            ret++;

            // 떨어짐
            move();


        }

        System.out.println(ret);


    }

    static void move() {
        // 각 좌표가 밑에 .이 아니거나, 범위 밖에 벗어나기 전까지 떨어짐

        for(int i = 10; i >= 0; i--) {
            for(int j = 0; j < 6; j++) {

                if(a[i][j] != '.') {

                    int y = i;
                    int x = j;

                    while (true) {
                        int ny = y + 1;
                        int nx = x;

                        if(ny == 12) {
                            break;
                        }
                        if(a[ny][nx] != '.') {
                            break;
                        }

                        a[ny][nx] = a[y][x];
                        a[y][x] = '.';
                        y = ny;
                        x = nx;
                    }
                }

            }
        }
    }

    static void dfs(int y, int x, char c) {
        visited[y][x] = 1;
        arr.add(new Pair(y, x));

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6) {
                continue;
            }

            if(visited[ny][nx] == 0 && a[ny][nx] == c) {
                dfs(ny, nx, c);
            }
        }

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

// dfs를 했을때 횟수가 4이상이면 탐색한 좌표를 .으로 바꾼다
// 블록을 떨어뜨린다

// 탐색 횟수가 4이상인 경우가 없으면 멈춘다

