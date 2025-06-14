package implementation;

import java.util.*;

public class BOJ17472 {

    static int n, m;
    static int[][] a = new int[14][14];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }


    }
}

// 모두 연결되있는 경우
// 겹치는거 뺴고 다 연결되

