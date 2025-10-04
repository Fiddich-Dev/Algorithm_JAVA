package baaarkingDog.simulation;

import java.util.*;

public class BOJ15685 {

    static int[][] a = new int[104][104];
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            a[y][x] = 1;

            List<Integer> arr = new ArrayList<>();
            arr.add(d);
            int ny = y + dy[d];
            int nx = x + dx[d];
            a[ny][nx] = 1;
            y = ny;
            x = nx;



            for(int j = 1; j <= g; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(arr);
                Collections.reverse(temp);

                for(int dir : temp) {
                    dir = (dir + 1) % 4;
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                    a[ny][nx] = 1;
                    arr.add(dir);
                    y = ny;
                    x = nx;
                }
            }
        }

//        for(int i = 0; i <= 10; i++) {
//            for(int j = 0; j <= 10; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }

        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(a[i][j] == 1 && a[i+1][j] == 1 && a[i][j+1] == 1 && a[i+1][j+1] == 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
