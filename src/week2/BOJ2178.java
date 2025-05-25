package week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n, m;
    static String s = "";
    static char[][] a = new char[104][104];
    static int[][] visited = new int[104][104];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        // 시작 0, 0
        // 끝 n-1, m-1

        visited[0][0] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));

        while(!q.isEmpty()) {
            Pair temp = q.peek();
            q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] == '1') {
                    visited[ny][nx] = visited[temp.y][temp.x] + 1;
                    q.offer(new Pair(ny, nx));
                }
            }
        }

        System.out.println(visited[n-1][m-1]);

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}
