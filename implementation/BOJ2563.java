package implementation;

import java.util.*;


public class BOJ2563 {
    static int n;
    static int[][] visited = new int[104][104];
    static int ret = 0;

    static void solve(int y, int x) {
        for(int i = y; i < y+10; i++) {
            for(int j = x; j < x+10; j++) {
                visited[i][j]++;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            solve(90-x, y);
        }

        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(visited[i][j] != 0) {
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }

}