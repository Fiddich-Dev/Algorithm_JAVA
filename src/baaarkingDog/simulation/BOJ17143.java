package baaarkingDog.simulation;

import java.util.*;
import java.io.*;

public class BOJ17143 {

    static int r, c, m;
    static List<Pos> sharks = new ArrayList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int ret = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            if(d == 0 || d == 1) {
                s = s % ((r-1) * 2);
            }
            else {
                s = s % ((c-1) * 2);
            }

            sharks.add(new Pos(y, x, s, d, z));
        }

        for(int i = 0; i < c; i++) {
            fishing(i);
            move();
        }

        System.out.println(ret);
    }

    static void move() {
        List<Pos> newSharks = new ArrayList<>();

        for(Pos p : sharks) {
            int y = p.y;
            int x = p.x;
            int s = p.s;
            int d = p.d;
            int z = p.z;

            int ny = y;
            int nx = x;
            for(int i = 0; i < s; i++) {
                ny = y + dy[d];
                nx = x + dx[d];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    d = d^1;
                    ny = y + dy[d];
                    nx = x + dx[d];
                }
                y = ny;
                x = nx;
            }

            newSharks.add(new Pos(y, x, s, d, z));
        }

        sharks = new ArrayList<>();
        int[][] visited = new int[r][c];
        Collections.sort(newSharks, (p1, p2) -> {
            return p2.z - p1.z;
        });

        for(Pos p : newSharks) {
            int y = p.y;
            int x = p.x;
            int s = p.s;
            int d = p.d;
            int z = p.z;

            if(visited[y][x] == 0) {
                visited[y][x] = 1;
                sharks.add(new Pos(y, x, s, d, z));
            }
        }
    }

    static void fishing(int x) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < sharks.size(); j++) {
                Pos p = sharks.get(j);
                if(p.y == i && p.x == x) {
                    ret += p.z;
                    sharks.remove(j);
                    return;
                }
            }
        }
    }

    static class Pos {
        int y;
        int x;
        int s;
        int d;
        int z;

        public Pos(int y, int x, int s, int d, int z) {
            this.y = y;
            this.x = x;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static class Shark {
        int s;
        int d;
        int z;

        public Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
