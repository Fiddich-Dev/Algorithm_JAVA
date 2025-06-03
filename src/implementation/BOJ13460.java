package implementation;

import java.util.*;


public class BOJ13460 {

    static int n, m;
    static char[][] a = new char[14][14];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        Beads beads = new Beads(0, 0, 0, 0, 0);

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);

                if(a[i][j] == 'R') {
                    beads.redY = i;
                    beads.redX = j;
                    a[i][j] = '.';
                }
                else if(a[i][j] == 'B') {
                    beads.blueY = i;
                    beads.blueX = j;
                    a[i][j] = '.';
                }
            }
        }

        bfs(beads);

        if(ret == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ret);
        }


    }
    // 빨간 공만 빠져야함

    static void bfs(Beads beads) {
        Queue<Beads> q = new LinkedList<>();
        q.add(beads);

        while(!q.isEmpty()) {
            Beads now = q.poll();

            if(now.cnt == 10) {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int redY = now.redY;
                int redX = now.redX;
                int blueY = now.blueY;
                int blueX = now.blueX;
                boolean isRedHole = false;
                boolean isBlueHole = false;

                // 빨간공
                while(true) {
                    int nry = redY + dy[i];
                    int nrx = redX + dx[i];

                    if(a[nry][nrx] == '#') {
                        break;
                    }
                    if(a[nry][nrx] == 'O') {
                        isRedHole = true;
                        break;
                    }
                    redY = nry;
                    redX = nrx;
                }
                // 파란공
                while(true) {
                    int nby = blueY + dy[i];
                    int nbx = blueX + dx[i];

                    if(a[nby][nbx] == '#') {
                        break;
                    }
                    if(a[nby][nbx] == 'O') {
                        isBlueHole = true;
                        break;
                    }

                    blueY = nby;
                    blueX = nbx;
                }
                // 목적 달성
                if(isRedHole == true && isBlueHole == false) {
                    ret = Math.min(ret, now.cnt+1);
                    continue;
                }
                // 안되는 경우
                if(isBlueHole == true) {
                    continue;
                }

                // 겹치는 경우
                if(redY == blueY && redX == blueX) {
                    if(i == 0) {
                        // y좌표가 큰게 밀려남
                        if(now.redY > now.blueY) {
                            redY++;
                        }
                        else {
                            blueY++;
                        }
                    }
                    else if(i == 1) {
                        // x좌표가 작은게 밀려남
                        if(now.redX > now.blueX) {
                            blueX--;
                        }
                        else {
                            redX--;
                        }
                    }
                    else if(i == 2) {
                        // y좌표가 작은게 밀려남
                        if(now.redY > now.blueY) {
                            blueY--;
                        }
                        else {
                            redY--;
                        }
                    }
                    else if(i == 3) {
                        // x좌표가 큰게 밀려남
                        if(now.redX > now.blueX) {
                            redX++;
                        }
                        else {
                            blueX++;
                        }
                    }
                }

                q.add(new Beads(redY, redX, blueY, blueX, now.cnt+1));
            }
        }
    }


    static class Beads {
        int redY;
        int redX;
        int blueY;
        int blueX;
        int cnt;

        public Beads(int redY, int redX, int blueY, int blueX, int cnt) {
            this.redY = redY;
            this.redX = redX;
            this.blueY = blueY;
            this.blueX = blueX;
            this.cnt = cnt;
        }
    }

}
