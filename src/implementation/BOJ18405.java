package implementation;

import java.util.*;

public class BOJ18405 {

    static int n, k;
    static int[][] a = new int[204][204];
    static int[][] visited = new int[204][204];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] num = new int[204][204];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        List<Status> v = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] != 0) {
                    v.add(new Status(i, j, a[i][j]));
                    num[i][j] = a[i][j];
                }
            }
        }



        int s = sc.nextInt();
        int lastY = sc.nextInt() - 1;
        int lastX = sc.nextInt() - 1;

        // 각 바이러스 별로 bfs를 돈다
        // bfs를 돌고 해당위치의 감염시간과, 값을 저장한다
        // 감염시간이 빠른거를 찾는다, 감염시간이 같다면 값이 더 작은 걸 고른다
        // 마지막에 visited하나 빼기

        Queue<Status> q = new LinkedList<>();
        v.sort((s1, s2) -> {
            return s1.v - s2.v;
        });
        for(Status st : v) {
            visited[st.y][st.x] = 1;
            q.add(st);
        }

        while(!q.isEmpty()) {
            Status now = q.poll();
            int y = now.y;
            int x = now.x;
            int virus = now.v;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                if(visited[ny][nx] == 0 && a[ny][nx] == 0) {
                    visited[ny][nx] = visited[y][x] + 1;
                    a[ny][nx] = virus;
                    q.add(new Status(ny, nx, virus));
                }
            }
        }


//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }

        int ret = 0;
        if(visited[lastY][lastX]-1 <= s) {
            ret = a[lastY][lastX];
        }

        System.out.println(ret);
//        System.out.println(lastY);
//        System.out.println(lastX);



    }

    static class Status {
        int y;
        int x;
        int v;

        public Status(int y, int x, int v) {
            this.y = y;
            this.x = x;
            this.v = v;
        }
    }
}
