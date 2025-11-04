package baaarkingDog.simulation;

import java.util.*;

public class BOJ16236 {

    static Shark shark;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int time = 0;
    static int eat = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 9) {
                    shark = new Shark(i, j, 2);
                    a[i][j] = 0;
                }
            }
        }

        while(true) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(a[i][j] != 0 && a[i][j] < shark.size) {
                        cnt++;
//                        System.out.println(i + " : " + j + " " + a[i][j]);
                    }
                }
            }
            if(cnt == 0) {
                break;
            }

//            System.out.println(cnt);


            int[][] visited = new int[n][n];

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(shark.y, shark.x));
            visited[shark.y][shark.x] = 1;

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
                    if(visited[ny][nx] == 0 && a[ny][nx] <= shark.size) {
                        q.add(new Pair(ny, nx));
                        visited[ny][nx] = visited[y][x] + 1;
                    }
                }
            }

            List<Pos> arr = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j] != 0 && a[i][j] != 0 && a[i][j] < shark.size) {
                        arr.add(new Pos(i, j, visited[i][j]-1));
                    }
                }
            }


//            for(int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(visited[i][j] + " ");
//                }
//                System.out.println();
//            }


            Collections.sort(arr, (p1, p2) -> {
                if(p1.dis == p2.dis) {
                    if(p1.y == p2.y) {
                        return p1.x - p2.x;
                    }
                    return p1.y - p2.y;
                }
                return p1.dis - p2.dis;
            });

            if(arr.isEmpty()) {
                break;
            }
            int y = arr.get(0).y;
            int x = arr.get(0).x;
            int dis = arr.get(0).dis;
//            System.out.println(y + " : " + x);
            if(a[y][x] < shark.size) {

                a[y][x] = 0;
                shark.y = y;
                shark.x = x;
                eat++;
                time += dis;
                if(eat == shark.size) {
                    eat = 0;
                    shark.size++;
                }
            }
            else if(a[y][x] == shark.size) {
                shark.y = y;
                shark.x = x;
                time += dis;
            }




        }

        System.out.println(time);



    }

    static class Shark {
        int y;
        int x;
        int size;

        public Shark(int y, int x, int size) {
            this.y = y;
            this.x = x;
            this.size = size;
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

    static class Pos {
        int y;
        int x;
        int dis;

        public Pos(int y, int x, int dis) {
            this.y = y;
            this.x = x;
            this.dis = dis;
        }
    }
}
