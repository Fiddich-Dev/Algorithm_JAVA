package baaarkingDog.simulation;

import java.util.*;

public class BOJ14890 {

    static int n, l;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
//            System.out.println(solve(a[i]));
            if(solve(a[i])) {
                cnt++;
            }
        }

        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[i][j] = a[n-1-j][i];
            }
        }

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.print(temp[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i = 0; i < n; i++) {
//            System.out.println(solve(temp[i]));
            if(solve(temp[i])) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean solve(int[] load) {
        int[] visited = new int[n];
        for(int i = 0; i < n-1; i++) {
            int h = load[i+1] - load[i];
            // 내리막일떄
            if(h == -1) {
                int now = load[i+1];
                for(int j = 0; j < l; j++) {
                    if(i+1+j >= n) {
                        return false;
                    }
                    if(now != load[i+1+j] || visited[i+1+j] == 1) {
                        return false;
                    }
                    visited[i+1+j] = 1;
                }
            }
            else if(h == 1) {
                int now = load[i];
                for(int j = 0; j < l; j++) {
                    if(i-j < 0) {
                        return false;
                    }
                    if(now != load[i-j] || visited[i-j] == 1) {
                        return false;
                    }
                    visited[i-j] = 1;
                }
            }
            else if(h > 1 || h < -1) {
                return false;
            }

        }
        return true;
    }
}

