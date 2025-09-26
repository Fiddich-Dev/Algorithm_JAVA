package baaarkingDog.backtracking;

import java.util.*;

public class BOJ1941 {

    static char[][] a = new char[5][5];
    static int[][] visited = new int[5][5];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = 0;

    static List<Pair> pos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            String s = sc.next();
            for(int j = 0; j < 5; j++) {
                a[i][j] = s.charAt(j);
                pos.add(new Pair(i, j));
            }
        }

        List<Pair> v = new ArrayList<>();
        go(-1, v);

        System.out.println(ret);

    }


    static void go(int start, List<Pair> b) {
        if(b.size() == 7) {
            int cntS = 0;
            int cntY = 0;
            for(Pair p : b) {
                int y = p.y;
                int x = p.x;
                if(a[y][x] == 'S') {
                    cntS++;
                }
                else {
                    cntY++;
                }
            }

            if(cntY > cntS) {
                return;
            }


            Queue<Pair> q = new LinkedList<>();
            int[][] visited2 = new int[5][5];
            q.add(b.get(0));
            visited2[b.get(0).y][b.get(0).x] = 1;

            int cnt = 0;

            while(!q.isEmpty()) {
                Pair p = q.poll();
                cnt++;
                int y = p.y;
                int x = p.x;
                for(int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) {
                        continue;
                    }
                    if(visited[ny][nx] == 1 && visited2[ny][nx] == 0) {
                        q.add(new Pair(ny, nx));
                        visited2[ny][nx] = visited2[y][x] + 1;
                    }
                }
            }

            if(cnt == 7) {
                ret++;
            }

            return;
        }

        for(int i = start+1; i < 25; i++) {
            int y = pos.get(i).y;
            int x = pos.get(i).x;

            b.add(pos.get(i));
            visited[y][x] = 1;

            go(i, b);

            b.remove(b.size()-1);
            visited[y][x] = 0;
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
