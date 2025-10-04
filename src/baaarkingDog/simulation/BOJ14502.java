package baaarkingDog.simulation;

import java.util.*;

public class BOJ14502 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        List<Pair> blank = new ArrayList<>();
        List<Pair> v = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 0) {
                    blank.add(new Pair(i, j));
                }
                else if(a[i][j] == 2) {
                    v.add(new Pair(i, j));
                }
            }
        }

        int ret = Integer.MIN_VALUE;

        for(int i = 0; i < blank.size(); i++) {
            for(int j = i+1; j < blank.size(); j++) {
                for(int k = j+1; k < blank.size(); k++) {
                    Pair p1 = blank.get(i);
                    Pair p2 = blank.get(j);
                    Pair p3 = blank.get(k);

                    a[p1.y][p1.x] = 1;
                    a[p2.y][p2.x] = 1;
                    a[p3.y][p3.x] = 1;

                    Queue<Pair> q = new LinkedList<>();
                    int[][] visited = new int[n][m];

                    for(Pair p : v) {
                        q.add(p);
                        visited[p.y][p.x] = 1;
                    }

                    while(!q.isEmpty()) {
                        Pair p = q.poll();
                        int y = p.y;
                        int x = p.x;

                        for(int l = 0; l < 4; l++) {
                            int ny = y + dy[l];
                            int nx = x + dx[l];
                            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                                continue;
                            }
                            if(a[ny][nx] == 0 && visited[ny][nx] == 0) {
                                q.add(new Pair(ny, nx));
                                visited[ny][nx] = visited[y][x] + 1;
                            }
                        }
                    }

                    int cnt = 0;
                    for(int l = 0; l < n; l++) {
                        for(int o = 0; o < m; o++) {
                            if(a[l][o] == 0 && visited[l][o] == 0) {
                                cnt++;
                            }
                        }
                    }

                    ret = Math.max(ret, cnt);

                    a[p1.y][p1.x] = 0;
                    a[p2.y][p2.x] = 0;
                    a[p3.y][p3.x] = 0;
                }
            }
        }


        System.out.println(ret);


        // 벽을 세우고
        // 바이러스를 퍼트리고
        // 안전지대를 센다

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

// 64 * 63 * 62 / 6
