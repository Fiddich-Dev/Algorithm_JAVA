package implementation;

import java.util.Scanner;

public class BOJ1193 {
    static int n;
    
    static int[] dy = {-1, 1};
    static int[] dx = {1, -1};

    static int[] dy1 = {0, 1};
    static int[] dx1 = {1, 0};

    static int retY, retX;
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int y = 1;
        int x = 1;
        int flag = 0;
        int cnt = 0;

        while(true) {
            cnt++;
            if(cnt == n) {
                System.out.println(y + "/" + x);
                return;
            }

            int ny = y + dy[flag];
            int nx = x + dx[flag];

            if(ny < 1) {
                ny = y + dy1[flag];
                nx = x + dx1[flag];
                flag ^= (1 << 0);
            }
            else if(nx < 1) {
                ny = y + dy1[flag];
                nx = x + dx1[flag];
                flag ^= (1 << 0);
            }

            y = ny;
            x = nx;
        }
    }
    
}
