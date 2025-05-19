package week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


class Pair {
    int y;
    int x;

    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}


public class BOJ7576 {
    
    static int n, m;
    static int[][] a = new int[1004][1004];
    static int[][] visited = new int[1004][1004];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int ret = -987654321;

    // 익은 토마토 위치
    static List<Pair> arr = new ArrayList<>();

    // 안익은 토마토 개수
    static int t = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();

                if(a[i][j] == 1) {
                    arr.add(new Pair(i, j));
                }
                else if(a[i][j] == -1) {
                    t++;
                }
            }
        }

        if(arr.size() + t == n*m) {
            System.out.println(0);
            return;
        }

        Queue<Pair> q = new LinkedList<>();
        for(Pair p : arr) {
            visited[p.y][p.x] = 1;
            q.add(p);
        }

        while(!q.isEmpty()) {
            Pair now = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if(visited[ny][nx] == 0 && a[ny][nx] == 0) {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[now.y][now.x] + 1;
                    ret = Math.max(ret, visited[ny][nx]);
                }
                
            }
        }

        // 방문 못 익게한 토마토 개수
        int t2 = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0) {
                    t2++;
                }
            }
        }



        if(t2 == t) {
            System.out.println(ret - 1);
        }
        else {
            System.out.println(-1);
        }

        
    }
}
