package implementation;

import java.util.*;

public class BOJ2669 {

    static int[][] visited = new int[104][104];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++) {
            // 왼쪽 아래
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            // 오른쪽 위
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    visited[j][k] = 1;
                }
            }
        }

        int ret = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(visited[i][j] == 1) {
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }
}
