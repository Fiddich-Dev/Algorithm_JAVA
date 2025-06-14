package implementation;

import java.util.*;

public class BOJ15685 {

    static int n;
    static int[][] a = new int[104][104];
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();
            draw(y, x, d, g);
        }
        System.out.println(calc());
    }

    static void draw(int y, int x, int d, int g) {

        a[y][x] = 1;
        List<Integer> dir = new ArrayList<>();
        int ny = y + dy[d];
        int nx = x + dx[d];
        a[ny][nx] = 1;
        dir.add(d);

        y = ny;
        x = nx;

        for(int i = 1; i <= g; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = dir.size()-1; j >= 0; j--) {
                temp.add((dir.get(j) + 1) % 4);
            }

            for(int j : temp) {
                ny = y + dy[j];
                nx = x + dx[j];
                a[ny][nx] = 1;
                dir.add(j);

                y = ny;
                x = nx;
            }

        }

    }

    static int calc() {
        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(a[i][j] == 1 && a[i+1][j] == 1 && a[i][j+1] == 1 && a[i+1][j+1] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


}
