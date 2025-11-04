package baaarkingDog.simulation;

import java.util.*;

public class BOJ17144 {

    static int r, c, t;
    static int[][] a;
    static Pair air1;
    static Pair air2;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        a = new int[r][c];
        int flag = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == -1) {
                    if(flag == 0) {
                        air1 = new Pair(i, j);
                        flag++;
                    }
                    else {
                        air2 = new Pair(i, j);
                    }
                }
            }
        }

        while(t-- != 0) {
            // 확산
            spread();
            // 정화
            roll(new int[]{0, -1, 0, 1}, new int[]{1, 0, -1, 0}, air1);
            roll(new int[]{0, 1, 0, -1}, new int[]{1, 0, -1, 0}, air2);
        }

        int ret = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(a[i][j] > 0) {
                    ret += a[i][j];
                }
            }
        }

        System.out.println(ret);
    }

    static void roll(int[] dy, int[] dx, Pair air) {
        List<Integer> temp = new ArrayList<>();
        List<Pair> pos = new ArrayList<>();

        int startY = air.y;
        int startX = air.x;
        int dir = 0;

        while(true) {
            int ny = startY + dy[dir];
            int nx =  startX + dx[dir];
            if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                dir++;
                ny = startY + dy[dir];
                nx = startX + dx[dir];
            }

            if(ny == air.y && nx == air.x) {
                break;
            }
            temp.add(a[ny][nx]);
            pos.add(new Pair(ny, nx));
            startY = ny;
            startX = nx;
        }
        a[pos.get(0).y][pos.get(0).x] = 0;
        for(int i = 1; i < pos.size(); i++) {
            a[pos.get(i).y][pos.get(i).x] = temp.get(i-1);
        }
    }

    static void spread() {
        int[][] temp = new int[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if((i == air1.y && j == air1.x) || (i == air2.y && j == air2.x)) {
                    continue;
                }
                if(a[i][j] != 0) {
                    temp[i][j] += a[i][j];
                    int v = a[i][j] / 5;
                    for(int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny < 0 || nx < 0 || ny >= r || nx >= c || (ny == air1.y && nx == air1.x) || (ny == air2.y && nx == air2.x)) {
                            continue;
                        }
                        temp[ny][nx] += v;
                        temp[i][j] -= v;
                    }
                }
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if((i == air1.y && j == air1.x) || (i == air2.y && j == air2.x)) {
                    continue;
                }
                a[i][j] = temp[i][j];
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
