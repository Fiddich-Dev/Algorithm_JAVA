package implementation;

import java.util.*;

public class BOJ15685 {

    static int n = 0;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] a = new int[104][104];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();



        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            List<Integer> arr = new ArrayList<>();

            solve(x, y, d, g, arr);
        }

        int ret = 0;

        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(a[i][j] == 1 && a[i+1][j] == 1 && a[i][j+1] == 1 && a[i+1][j+1] == 1) {
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }

    static void solve(int x, int y, int d, int g, List<Integer> arr) {
        // 0세대 그리기
        arr.add(d);
        a[y][x] = 1;
        int ny = y + dy[d];
        int nx = x + dx[d];
        a[ny][nx] = 1;

        y = ny;
        x = nx;

        for(int i = 0; i < g; i++) {

            int temp = arr.size();

            for(int j = temp-1; j >= 0; j--) {
                int nd = (arr.get(j) + 1) % 4;
                ny = y + dy[nd];
                nx = x + dx[nd];

                a[ny][nx] = 1;
                arr.add(nd);

                y = ny;
                x = nx;
            }

        }
    }


}
