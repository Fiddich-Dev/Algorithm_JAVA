package baaarkingDog.backtracking;

import java.util.*;

public class BOJ18809 {

    static int n, m, g, r;
    static int[][] a;
    static List<Pair> arr = new ArrayList<>();
    static List<Pair> selectedG = new ArrayList<>();
    static List<Pair> selectedR = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        g = sc.nextInt();
        r = sc.nextInt();
        a = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();

                if(a[i][j] == 2) {
                    arr.add(new Pair(i, j));
                }
            }
        }


        go(0, 0, 0);

        System.out.println(ret);

    }

    static void go(int idx, int cntG, int cntR) {
        if(cntG == g && cntR == r) {
            bfs();
            return;
        }

        if(cntG+1 <= g) {
            selectedG.add(arr.get(idx));
            go(idx+1, cntG+1, cntR);
            selectedG.remove(selectedG.size()-1);
        }
        if(cntR+1 <= r) {
            selectedR.add(arr.get(idx));
            go(idx+1, cntG, cntR+1);
            selectedR.remove(selectedR.size()-1);
        }

        go(idx+1, cntG, cntR);

    }

    static void bfs() {
        int[][] visitedG = new int[n][m];
        int[][] visitedR = new int[n][m];
        int flower = 0;

        Queue<Pair> q_g = new LinkedList<>();
        Queue<Pair> q_r = new LinkedList<>();

        for(Pair p : selectedG) {
            q_g.add(p);
            visitedG[p.y][p.x] = 1;
        }
        for(Pair p : selectedR) {
            q_r.add(p);
            visitedR[p.y][p.x] = 1;
        }

        while(!q_g.isEmpty() || !q_r.isEmpty()) {
            int sizeG = q_g.size();
            int sizeR = q_r.size();

            for(int i = 0; i < sizeG; i++) {
                Pair p = q_g.poll();
                int y = p.y;
                int x = p.x;

                if(visitedR[y][x] == visitedG[y][x]) {
                    continue;
                }
                for(int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if(a[ny][nx] != 0 && visitedG[ny][nx] == 0) {
                        visitedG[ny][nx] = visitedG[y][x] + 1;
                        q_g.add(new Pair(ny, nx));
                    }
                }
            }

            for(int i = 0; i < sizeR; i++) {
                Pair p = q_r.poll();
                int y = p.y;
                int x = p.x;

                if(visitedR[y][x] == visitedG[y][x]) {
                    continue;
                }
                for(int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if(a[ny][nx] != 0 && visitedR[ny][nx] == 0) {
                        visitedR[ny][nx] = visitedR[y][x] + 1;
                        if(visitedG[ny][nx] == visitedR[ny][nx]) {
                            flower++;
                        }
                        else {
                            q_r.add(new Pair(ny, nx));
                        }
                    }
                }
            }
        }

        ret = Math.max(ret, flower);
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
// 0은 호수, 1은 배양액을 뿌릴 수 없는 땅, 2는 배양액을 뿌릴 수 있는 땅을 의미한다.

// 배양액 배치 : 10 C 5
//
