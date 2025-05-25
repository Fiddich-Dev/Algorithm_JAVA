package week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int y;
    int x;

    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ14497 {

    static int n, m;
    static Pair j;
    static Pair b;

    static char[][] a = new char[304][304];
    static int[][] visited = new int[304][304];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int temp1 = sc.nextInt();
        int temp2 = sc.nextInt();
        int temp3 = sc.nextInt();
        int temp4 = sc.nextInt();

        temp1--;
        temp2--;
        temp3--;
        temp4--;

        j = new Pair(temp1, temp2);
        b = new Pair(temp3, temp4);

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        

        int cnt = 0;
        Queue<Pair> q = new LinkedList<>();
        visited[j.y][j.x] = 1;
        q.add(new Pair(j.y, j.x));

        while(true) {

            cnt++;
            Queue<Pair> q_temp = new LinkedList<>();


            while (!q.isEmpty()) {
                Pair now = q.poll();

                for(int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if(visited[ny][nx] == 0 && a[ny][nx] != '0') {
                        q_temp.add(new Pair(ny, nx));
                        visited[ny][nx] = cnt;
                    }

                    if(visited[ny][nx] == 0 && a[ny][nx] == '0') {
                        q.add(new Pair(ny, nx));
                        visited[ny][nx] = cnt;
                    }
                }
            }

            if(q_temp.isEmpty()) {
                break;
            }

            q = q_temp;
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(visited[b.y][b.x]);

    }
    
}

// 한번 뛰면 0을 1로 1은 q_temp에 저장
// 그 q_temp로 다시 탐색
