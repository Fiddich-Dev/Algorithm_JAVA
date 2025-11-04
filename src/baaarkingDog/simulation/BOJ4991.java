package baaarkingDog.simulation;

import java.util.*;

public class BOJ4991 {

    static int n, m;
    static int[][] a;
    static StringBuilder sb = new StringBuilder();
    static Pair robot;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        while(true) {
            ret = 0;
            m = sc.nextInt();
            n = sc.nextInt();

            if(n == 0 && m == 0) {
                break;
            }

            a = new int[n][m];
            for(int i = 0; i < n; i++) {
                String temp = sc.next();
                for(int j = 0; j < m; j++) {
                    a[i][j] = temp.charAt(j);
                    if(a[i][j] == 'o') {
                        a[i][j] = '.';
                        robot = new Pair(i, j);
                    }
                }
            }

            while(true) {
                int cnt = 0;
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(a[i][j] == '*') {
                            cnt++;
                        }
                    }
                }
                if(cnt == 0) {
                    break;
                }

//                System.out.println(robot.y + " : " + robot.x);

                visited = new int[n][m];
                bfs(robot.y, robot.x);

                List<Status> canDirty = check();

                if(canDirty.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                else {
                    Collections.sort(canDirty, (s1, s2) -> {
                        return s1.dis - s2.dis;
                    });
                    int y = canDirty.get(0).y;
                    int x = canDirty.get(0).x;
                    int dis = canDirty.get(0).dis;
                    ret += dis;
                    a[y][x] = '.';
                    robot.y = y;
                    robot.x = x;
                }
            }

            System.out.println(ret);


        }

    }

    // 갈수 있는데가 있으면 true
    static List<Status> check() {
        List<Status> dirty = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == '*' && visited[i][j] != 0) {
                    dirty.add(new Status(i, j, visited[i][j]-1));
                }
            }
        }

        return dirty;
    }

    static void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        visited[y][x] = 1;
        q.add(new Pair(y, x));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            for(int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] != 'x') {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[p.y][p.x] + 1;
                }
            }
        }
    }

    static class Status {
        int y;
        int x;
        int dis;

        public Status(int y, int x, int dis) {
            this.y = y;
            this.x = x;
            this.dis = dis;
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
