package implementation;

import java.util.*;

public class BOJ15683 {

    static int n, m;
    static int[][] a = new int[10][10];
    static List<Pair> arr= new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int ret = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] >= 1 && a[i][j] <= 5) {
                    arr.add(new Pair(i, j));
                }
            }
        }


        combi(0, a);

        System.out.println(ret);
    }

    static void combi(int now, int[][] a_temp) {



        if(now == arr.size()) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(a_temp[i][j] == 0){
                        cnt++;
                    }
                }
            }


            ret = Math.min(ret, cnt);
            return;
        }

        int y = arr.get(now).y;
        int x = arr.get(now).x;


        for(int i = 0; i < 4; i++) {
            if(a[y][x] == 1) {
                fill(a_temp, y, x, i);
                combi(now+1, a_temp);
                unfill(a_temp, y, x, i);
            }
            else if(a[y][x] == 2) {
                fill(a_temp, y, x, i);
                fill(a_temp, y, x, (i+2) % 4);
                combi(now+1, a_temp);
                unfill(a_temp, y, x, i);
                unfill(a_temp, y, x, (i+2) % 4);
            }
            else if(a[y][x] == 3) {
                fill(a_temp, y, x, i);
                fill(a_temp, y, x, (i+1) % 4);
                combi(now+1, a_temp);
                unfill(a_temp, y, x, i);
                unfill(a_temp, y, x, (i+1) % 4);
            }
            else if(a[y][x] == 4) {
                fill(a_temp, y, x, i);
                fill(a_temp, y, x, (i+1) % 4);
                fill(a_temp, y, x, (i+2) % 4);
                combi(now+1, a_temp);
                unfill(a_temp, y, x, i);
                unfill(a_temp, y, x, (i+1) % 4);
                unfill(a_temp, y, x, (i+2) % 4);
            }
            else if(a[y][x] == 5) {
                fill(a_temp, y, x, i);
                fill(a_temp, y, x, (i+1) % 4);
                fill(a_temp, y, x, (i+2) % 4);
                fill(a_temp, y, x, (i+3) % 4);
                combi(now+1, a_temp);
                unfill(a_temp, y, x, i);
                unfill(a_temp, y, x, (i+1) % 4);
                unfill(a_temp, y, x, (i+2) % 4);
                unfill(a_temp, y, x, (i+3) % 4);
            }
        }

    }

    // 감시가능 구역은 -1로 바꾸기
    static void fill(int[][] a_temp, int y, int x, int dir) {
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                break;
            }
            if(a_temp[ny][nx] == 6) {
                break;
            }
            if(a_temp[ny][nx] >= 1 && a_temp[ny][nx] <= 5){
                y = ny;
                x = nx;
                continue;
            }

            a_temp[ny][nx] -= 1;

            y = ny;
            x = nx;
        }
    }

    static void unfill(int[][] a_temp, int y, int x, int dir) {
        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                break;
            }
            if(a_temp[ny][nx] == 6) {
                break;
            }
            if(a_temp[ny][nx] >= 1 && a_temp[ny][nx] <= 5){
                y = ny;
                x = nx;
                continue;
            }

            a_temp[ny][nx] += 1;

            y = ny;
            x = nx;
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

// 0은 빈 칸, 6은 벽, 1~5는 CCTV
// CCTV는 벽을 통과할 수 없기
// CCTV는 CCTV를 통과할 수 있다
