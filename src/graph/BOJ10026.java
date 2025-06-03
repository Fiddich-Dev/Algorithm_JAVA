package graph;

import java.util.*;
import java.io.*;

public class BOJ10026 {

    static int n;
    static char[][] a = new char[104][104];
    static int[][] visited = new int[104][104];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        // 스트링을 캐릭터로 바꾸는법

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        int ret1 = 0;
        int ret2 = 0;

        // 정상인
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    dfs(i, j, a[i][j]);
                    ret1++;
                }
            }
        }

        // 초기화
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }

        // 색약

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 'R') {
                    a[i][j] = 'G';
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    dfs(i, j, a[i][j]);
                    ret2++;
                }
            }
        }




        System.out.println(ret1 + " " + ret2);

    }

    static void dfs(int y, int x, char c) {
        visited[y][x] = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if(visited[ny][nx] == 0 && a[ny][nx] == c) {
                dfs(ny, nx, c);
            }
        }
    }
}

// 적록 색약은 빨간, 초록이 같다
// 커넥티드 컴포넌트 개수 구하기