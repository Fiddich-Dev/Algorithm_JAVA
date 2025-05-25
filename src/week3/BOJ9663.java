package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class BOJ9663 {

    static int n;
    static int ret = 0;
    static int[][] a = new int[20][20];
    static int[][] visited = new int[20][20];


    static void put(int y, int x) {
        // 퀸을 놓을때 
        for(int i = 0; i < n; i++) {
            visited[y][i] += 1;
            visited[i][x] += 1;
        }
        int sy = y - Math.min(y, x);
        int sx = x - Math.min(y, x);
        while(true) {
            visited[sy][sx] += 1;
            sy++;
            sx++;
            if(sy >= n || sx >= n) {
                break;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i + j == y + x) {
                    visited[i][j] += 1;
                }
            }
        }

        visited[y][x] -= 3;
    }

    static void remove(int y, int x) {
        // 퀸을 놓을때 
        for(int i = 0; i < n; i++) {
            visited[y][i] -= 1;
            visited[i][x] -= 1;
        }
        int sy = y - Math.min(y, x);
        int sx = x - Math.min(y, x);
        while(true) {
            visited[sy][sx] -= 1;
            sy++;
            sx++;
            if(sy >= n || sx >= n) {
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i + j == y + x) {
                    visited[i][j] -= 1;
                }
            }
        }
        visited[y][x] += 3;
    }

    static void go(int y, int cnt) {
        if(cnt == n) {
            ret++;
            return;
        }
        if(y == n) {
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[y][i] == 0) {
                put(y, i);
                go(y+1, cnt+1);
                remove(y, i);
            }
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        go(0, 0);
        System.out.println(ret);
        
    }

}
