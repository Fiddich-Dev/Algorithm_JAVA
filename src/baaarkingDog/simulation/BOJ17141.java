package baaarkingDog.simulation;

import java.util.*;

public class BOJ17141 {

    static int n, m;
    static int[][] a;
    static List<Pair> arr = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int cnt = 0; // 빈 칸의 개수
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
                    arr.add(new Pair(i, j));
                    a[i][j] = 0;
                }
                else if(a[i][j] == 1) {
                    cnt++;
                }
            }
        }

        cnt = n * n - cnt;

        List<Pair> v = new ArrayList<>();
        combi(-1, v);

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ret);
        }
    }

    static void combi(int start, List<Pair> b) {
        if(b.size() == m) {
            int[][] visited = new int[n][n];
            Queue<Pair> q = new LinkedList<>();

            for(Pair p : b) {
                a[p.y][p.x] = 2;
                visited[p.y][p.x] = 1;
                q.add(new Pair(p.y, p.x));
            }

            int searchCnt = 0;
            int time = 1;

            while(!q.isEmpty()) {
                Pair p = q.poll();
                searchCnt++;
                int y = p.y;
                int x = p.x;

                for(int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    if(visited[ny][nx] == 0 && a[ny][nx] == 0) {
                        q.add(new Pair(ny, nx));
                        visited[ny][nx] = visited[y][x] + 1;
                        time = Math.max(time, visited[ny][nx]);
                    }
                }
            }

            // 다 퍼졌을때
            if(searchCnt == cnt) {
                ret = Math.min(ret, time - 1);
            }


            for(Pair p : b) {
                a[p.y][p.x] = 0;
            }
            return;
        }
        for(int i = start+1; i < arr.size(); i++) {
            b.add(arr.get(i));
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

// 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 칸