package implementation;

import java.util.Scanner;

// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
public class BOJ14499 {
    static int n, m, x, y, k;
    static int[][] a = new int[24][24];
    // 아래 위 북 동 남 서
    static int[] dice = {0, 0, 0, 0, 0, 0};

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static void roll(int num) {
        int[] temp = dice.clone();
        // 동
        if(num == 1) {
            dice[1] = temp[3];
            dice[3] = temp[0];
            dice[0] = temp[5];
            dice[5] = temp[1];
        }
        // 서
        else if(num == 2) {
            dice[1] = temp[5];
            dice[3] = temp[1];
            dice[0] = temp[3];
            dice[5] = temp[0];
        }
        // 북
        else if(num == 3) {
            dice[1] = temp[2];
            dice[2] = temp[0];
            dice[0] = temp[4];
            dice[4] = temp[1];
        }
        // 남
        else if(num == 4) {
            dice[1] = temp[4];
            dice[4] = temp[0];
            dice[0] = temp[2];
            dice[2] = temp[1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        y = sc.nextInt();
        x = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        // 주사위 놓을때
        if(a[y][x] == 0) {
            a[y][x] = dice[0];
        }
        else {
            dice[0] = a[y][x];
            a[y][x] = 0;
        }

        for(int i = 0; i < k; i++) {
            int num = sc.nextInt();

            // 다음 좌표
            int ny = y + dy[num-1];
            int nx = x + dx[num-1];
            // 굴릴 수 있는지 확인
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }

            // 주사위 굴리기
            roll(num);

            if(a[ny][nx] == 0) {
                a[ny][nx] = dice[0];
            }
            else {
                dice[0] = a[ny][nx];
                a[ny][nx] = 0;
            }

            y = ny;
            x = nx;

            System.out.println(dice[1]);
        }

    }
    
}

// 이동한 맵이 0이면 주사위 닿은면의 수가 맵으로 복사
// 이동한 맵이 0이 아니면 주사위 닿은면에 맵의 숫자가 입력, 맵은 0
