package baaarkingDog.simulation;

import java.util.*;

public class BOJ17142 {

    static int n, m;
    static int[][] a;
    static List<Pair> virous = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int total;
    static int ret = Integer.MAX_VALUE;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 2) {
                    virous.add(new Pair(i, j));
                }
                else if(a[i][j] == 0) {
                    total++;
                }
            }
        }

        List<Pair> v = new ArrayList<>();
        combi(-1, v);

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ret-1);
        }
    }



    static void combi(int start, List<Pair> b) {
        if(b.size() == m) {
            int cnt = 0; // 퍼진 개수
            int[][] visited = new int[n][n];
            Queue<Pair> q = new LinkedList<>();
            for(Pair p : b) {
                q.add(new Pair(p.y, p.x));
                visited[p.y][p.x] = 1;
            }

            while(!q.isEmpty()) {
                Pair p = q.poll();
                int y = p.y;
                int x = p.x;

                for(int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    if(visited[ny][nx] == 0 && a[ny][nx] != 1) {
                        if(a[ny][nx] == 0) {
                            cnt++;
                        }
                        q.add(new Pair(ny, nx));
                        visited[ny][nx] = visited[y][x] + 1;
                    }
                }
            }

            int temp = 1;

            if(cnt == total) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(visited[i][j] != 0 && a[i][j] != 2) {
                            temp = Math.max(temp, visited[i][j]);
                        }
                    }
                }

                ret = Math.min(ret, temp);
            }



            return;
        }
        for(int i = start+1; i < virous.size(); i++) {
            b.add(virous.get(i));
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
