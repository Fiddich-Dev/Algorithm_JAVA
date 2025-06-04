package implementation;

import java.util.*;

class Fish {
    int y;
    int x;
    int d;

    Fish(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}

public class BOJ16236 {
    static int n;
    static int[][] a = new int[24][24];
    static int[][] visited = new int[24][24];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static Pair shark = new Pair(-1, -1);
    static int hp = 2;
    static int gage = 0;


    static int ret = 0;

    // true면 먹을 물고기 있음
    static boolean check() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] != 0 && a[i][j] < hp) {
                    return true;
                }
            }
        }
        return false;
    }


    static Fish bfs(int y, int x) {
        visited[y][x] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        ArrayList<Fish> fishes = new ArrayList<>();

        while(!q.isEmpty()) {
            Pair temp = q.poll();
            for(int i = 0; i < 4; i++) {
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if(visited[ny][nx] != 0) {
                    continue;
                }
                if(a[ny][nx] > hp) {
                    continue;
                }

                visited[ny][nx] = visited[temp.y][temp.x] + 1;
                q.add(new Pair(ny, nx));

                if(a[ny][nx] != 0 && a[ny][nx] < hp) {
                    fishes.add(new Fish(ny, nx, visited[ny][nx] - 1));
                }
            }
        }

        if(fishes.isEmpty()) {
            return null;
        }
        Collections.sort(fishes, (p1, p2) -> {
            if (p1.d != p2.d) return p1.d - p2.d;
            if (p1.y != p2.y) return p1.y - p2.y;
            return p1.x - p2.x;
        });

        return fishes.get(0);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 9) {
                    a[i][j] = 0;
                    shark.y = i;
                    shark.x = j;
                }
            }
        }

        while (true) {

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    visited[i][j] = 0;
                }
            }

            Fish target = bfs(shark.y, shark.x);
            if(target == null) {
                break;
            }

            ret += target.d;
            shark.y = target.y;
            shark.x = target.x;
            a[target.y][target.x] = 0;

            gage++;
            if(hp == gage) {
                hp++;
                gage = 0;
            }

        }

        System.out.println(ret);
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
