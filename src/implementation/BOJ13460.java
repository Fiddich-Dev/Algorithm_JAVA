package implementation;

import java.util.*;


class PairBeads {
    int redY;
    int redX;
    int blueY;
    int blueX;
    int cnt;
    public PairBeads(int redY, int redX, int blueY, int blueX, int cnt) {
        this.redY = redY;
        this.redX = redX;
        this.blueY = blueY;
        this.blueX = blueX;
        this.cnt = cnt;
    }



}



public class BOJ13460 {

    static int n;
    static int m;

    static char[][] board = new char[14][14];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        PairBeads pb = new PairBeads(0, 0, 0, 0, 0);

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'R') {
                    pb.redY = i;
                    pb.redX = j;
                    board[i][j] = '.';
                }
                else if(board[i][j] == 'B') {
                    pb.blueY = i;
                    pb.blueX = j;
                    board[i][j] = '.';
                }
                
            }
        }

        System.out.println(bfs(pb));
    }

    static int bfs(PairBeads pb) {

        Queue<PairBeads> q = new LinkedList<>();
        q.add(pb);

        while(!q.isEmpty()) {
            PairBeads beads = q.poll();


            if(beads.cnt == 10) {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int redY = beads.redY;
                int redX = beads.redX;
                int blueY = beads.blueY;
                int blueX = beads.blueX;
                boolean isRedHole = false;
                boolean isBlueHole = false;

                // 빨간공
                while(true) {
                    int newRedY = redY + dy[i];
                    int newRedX = redX + dx[i];

                    if(board[newRedY][newRedX] == '#') {
                        break;
                    }

                    if(board[newRedY][newRedX] == 'O') {
                        isRedHole = true;
                        break;
                    }

                    redY = newRedY;
                    redX = newRedX;
                }
                // 파란공
                while(true) {
                    int newBlueY = blueY + dy[i];
                    int newBlueX = blueX + dx[i];

                    if(board[newBlueY][newBlueX] == '#') {
                        break;
                    }

                    if(board[newBlueY][newBlueX] == 'O') {
                        isBlueHole = true;
                        break;
                    }

                    blueY = newBlueY;
                    blueX = newBlueX;
                }

                if(isBlueHole == true) {
                    continue;
                }
                else if(isRedHole == true) {
                    return beads.cnt + 1; //?
                }

                // 경우의 수를 줄이기 위해 두 구슬의 위치가 그대로인 경우에는 큐에 집어넣지 않습니다.
                if (beads.redX == redX && beads.redY == redY && beads.blueX == blueX && beads.blueY == blueY) {
                    continue;
                }

                if(redY == blueY && redX == blueX) {
                    if(i == 0) {
                        if(beads.blueY < beads.redY) {
                            redY++;
                        }
                        else {
                            blueY++;
                        }
                    }
                    else if(i == 1) {
                        if(beads.blueX < beads.redX) {
                            blueX--;
                        }
                        else {
                            redX--;
                        }
                    }
                    else if(i == 2) {
                        if(beads.blueY < beads.redY) {
                            blueY--;
                        }
                        else {
                            redY--;
                        }
                    }
                    else if(i == 3) {
                        if(beads.blueX < beads.redX) {
                            redX++;
                        }
                        else {
                            blueX++;
                        }
                    }
                }

                q.add(new PairBeads(redY, redX, blueY, blueX, beads.cnt+1)); // ?
            }
        }
        return -1;
    }
}
