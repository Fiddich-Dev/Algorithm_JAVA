package week1;

import java.util.Scanner;

public class BOJ1018 {
    static int n, m;
    static char[][] a = new char[54][54];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        System.out.println(slice());

        
    }

    static int slice() {
        char[][] temp = new char[8][8];

        int startY = 0;
        int startX = 0;

        int ret = 987654321;

        while(true) {

            for(int i = startY; i < startY+8; i++) {
                for(int j = startX; j < startX+8; j++) {
                    temp[i - startY][j - startX] = a[i][j];
                }
            }

            ret = Math.min(ret, check(temp));

            // 0 ~ m-8
            startX = startX+1 == m-7 ? 0 : startX+1;
            // 0 ~ n-8
            startY = startX == 0 ? startY+1 : startY;


            if(startY == n-7) {
                break;
            }

        }

        return ret;
    }

    static int check(char[][] map) {

        char[] h = {'B', 'W'};

        int cnt1 = 0;
        int cnt2 = 0;

        int now1 = 0;
        int now2 = 1;

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(map[i][j] != h[now1]) {
                    cnt1++;
                }
                if(map[i][j] != h[now2]) {
                    cnt2++;
                }
                now1 ^= 1;
                now2 ^= 1;
            }
            now1 ^= 1;
            now2 ^= 1;
        }

        return Math.min(cnt1, cnt2);
    }
}
// 체스판을 8*8로 자른다
// 각경우를 B, W로 시작하는 각가의 경우에서 바꿔야하는 칸의 개수를 구한다
// 그 개수 중 최솟값을 구힌디

