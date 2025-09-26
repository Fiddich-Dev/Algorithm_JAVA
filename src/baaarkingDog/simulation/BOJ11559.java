package baaarkingDog.simulation;

import java.util.*;

public class BOJ11559 {

    static char[][] a = new char[12][6];
    static int[][] visited = new int[12][6];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 12; i++) {
            String s = sc.next();
            for(int j = 0; j < 6; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        int ret = 0;

        while(true) {
            visited = new int[12][6];
            List<Pair> remove = new ArrayList<>();

            // 제거할거 탐색
            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    if(a[i][j] != '.' && visited[i][j] == 0) {
                        List<Pair> temp  = new ArrayList<>();
                        dfs(i, j, a[i][j], temp);

                        if(temp.size() >= 4) {
                            remove.addAll(temp);
                        }
                    }
                }
            }

            if(remove.isEmpty()) {
                break;
            }

            // 제거
            for(Pair p : remove) {
                a[p.y][p.x] = '.';
            }

            ret++;

            for(int i = 0; i < 6; i++) {
                List<Character> temp = new ArrayList<>();
                for(int j = 11; j >= 0; j--) {
                    if(a[j][i] != '.') {
                        temp.add(a[j][i]);
                        a[j][i] = '.';
                    }
                }

                int bottom = 11;
                for(int j = 0; j < temp.size(); j++) {
                    a[bottom][i] = temp.get(j);
                    bottom--;
                }
            }
        }

        System.out.println(ret);
    }

    static void dfs(int y, int x, char now, List<Pair> temp) {
        visited[y][x] = 1;
        temp.add(new Pair(y, x));

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6) {
                continue;
            }
            if(a[ny][nx] == now && visited[ny][nx] == 0) {
                dfs(ny, nx, now, temp);
            }
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
