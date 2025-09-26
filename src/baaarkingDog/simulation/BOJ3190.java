package baaarkingDog.simulation;

import java.util.*;

public class BOJ3190 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] snake = new int[n][n];

        int k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            a[y][x] = 1;
        }

        int l = sc.nextInt();
        Queue<Turn> q = new LinkedList<>();
        for(int i = 0; i < l; i++) {
            q.add(new Turn(sc.nextInt(), sc.next().charAt(0)));
        }

        int d = 1;
        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(0, 0));
        snake[0][0] = 1;
        int cnt = 0;

        while(true) {
            cnt++;
            Pair head = dq.getLast();
            int ny = head.y + dy[d];
            int nx = head.x + dx[d];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                break;
            }
            if(snake[ny][nx] == 1) {
                break;
            }

            dq.addLast(new Pair(ny, nx));
            snake[ny][nx] = 1;

            if(a[ny][nx] == 1) {
                a[ny][nx] = 0;
            }
            else {
                Pair tail = dq.pollFirst();
                snake[tail.y][tail.x] = 0;
            }

            if(!q.isEmpty()) {
                Turn t = q.peek();
                if(t.t == cnt) {
                    if(t.d == 'D') {
                        d = (d + 1) % 4;
                    }
                    else {
                        d = (d + 3) % 4;
                    }
                    q.poll();
                }
            }

        }

        System.out.println(cnt);

    }

    static class Turn {
        int t;
        char d;

        public Turn(int t, char d) {
            this.t = t;
            this.d = d;
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
