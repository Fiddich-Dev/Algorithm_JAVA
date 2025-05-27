package implementation;

import java.util.*;

public class BOJ3085 {

    static int n;
    static char[][] a = new char[54][54];
    static int[][] visited = new int[54][54];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    // 좌우 상하로 계산해서 같은거 몇개 붙어있는지 최댓값 반환
    static int calc(int y, int x) {
        char start = a[y][x];
        int nowY = y;
        int nowX = x;
        // 좌우
        int cnt1 = 1;
        for(int i = x-1; i >= 0; i--) {
            if(start == a[y][i]) {
                cnt1++;
            }
            else {
                break;
            }
        }
        for(int i = x+1; i < n; i++) {
            if(start == a[y][i]) {
                cnt1++;
            }
            else {
                break;
            }
        }

        // 상하
        int cnt2 = 1;
        for(int i = y-1; i >= 0; i--) {
            if(start == a[i][x]) {
                cnt2++;
            }
            else {
                break;
            }
        }
        for(int i = y+1; i < n; i++) {
            if(start == a[i][x]) {
                cnt2++;
            }
            else {
                break;
            }
        }

        return Math.max(cnt1, cnt2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        int ret = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int y = i;
                int x = j;

                ret = Math.max(ret, calc(y, x));

                for(int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    if(visited[ny][nx] == 0 && (a[y][x] != a[ny][nx])) {
                        // 잠깐 바꾸기
                        char temp = a[y][x];
                        a[y][x] = a[ny][nx];
                        a[ny][nx] = temp;

                        // 계산
                        // a[y][x]에서 좌우, 상하로 계산
                        // a[ny][nx]에서 좌우, 상하로 계산
                        ret = Math.max(ret, calc(y, x));
                        ret = Math.max(ret, calc(ny, nx));


                        // 백트래킹
                        temp = a[ny][nx];
                        a[ny][nx] = a[y][x];
                        a[y][x] = temp;
                    }
                }

                visited[y][x] = 1;
            }
        }

        System.out.println(ret);
    }
}



