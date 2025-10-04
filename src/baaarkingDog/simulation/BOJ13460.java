package baaarkingDog.simulation;

import java.util.*;

public class BOJ13460 {

    static int n, m;
    static int[][] a;
    static int ry, rx, by, bx;
    static int ret = 987654321;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                if(a[i][j] == 'R') {
                    ry = i;
                    rx = j;
                    a[i][j] = '.';
                }
                else if(a[i][j] == 'B') {
                    by = i;
                    bx = j;
                    a[i][j] = '.';
                }
            }
        }


        Queue<Beads> q = new LinkedList<>();
        q.add(new Beads(ry, rx, by, bx, 0));

        while(!q.isEmpty()) {
            Beads b = q.poll();
            if(b.cnt == 10) {
                break;
            }



            for(int i = 0; i < 4; i++) {
                int ry = b.ry;
                int rx = b.rx;
                int by = b.by;
                int bx = b.bx;
                boolean redHole = false;
                boolean blueHole = false;
                // 빨간공
                while(true) {
                    int nry = ry + dy[i];
                    int nrx = rx + dx[i];
                    if(nry < 0 || nrx < 0 || nry >= n || nrx >= m) {
                        break;
                    }
                    if(a[nry][nrx] == '#') {
                        break;
                    }
                    if (a[nry][nrx] == '.') {
                        ry = nry;
                        rx = nrx;
                    }
                    if(a[nry][nrx] == 'O') {
                        redHole = true;
                        ry = nry;
                        rx = nrx;
                        break;
                    }
                }
                // 파란공
                while(true) {
                    int nby = by + dy[i];
                    int nbx = bx + dx[i];
                    if(nby < 0 || nbx < 0 || nby >= n || nbx >= m) {
                        break;
                    }
                    if(a[nby][nbx] == '#') {
                        break;
                    }
                    if (a[nby][nbx] == '.') {
                        by = nby;
                        bx = nbx;
                    }
                    if(a[nby][nbx] == 'O') {
                        blueHole = true;
                        by = nby;
                        bx = nbx;
                        break;
                    }
                }
                // 재배치
                if(ry == by && rx == bx) {
                    int disRed = Math.abs(b.ry - ry) + Math.abs(b.rx - rx);
                    int disBlue = Math.abs(b.by - by) + Math.abs(b.bx - bx);
                    if(disRed < disBlue) {
                        by = by + dy[(i+2) % 4];
                        bx = bx + dx[(i+2) % 4];
                    }
                    else if(disRed > disBlue) {
                        ry = ry + dy[(i+2) % 4];
                        rx = rx + dx[(i+2) % 4];
                    }
                }

                if(redHole == false && blueHole == false) {
                    q.add(new Beads(ry, rx, by, bx, b.cnt+1));
                }
                else if(redHole == true && blueHole == false) {
                    ret = Math.min(ret, b.cnt+1);
                }
            }
        }



        if(ret == 987654321) {
            System.out.println(-1);
        }
        else {
            System.out.println(ret);
        }

    }

    static class Beads {
        int ry;
        int rx;
        int by;
        int bx;
        int cnt;

        public Beads(int ry, int rx, int by, int bx, int cnt) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.cnt = cnt;
        }
    }
}
// 빨강은 구멍에, 파랑은 안됨

// 10 * 10 4^10