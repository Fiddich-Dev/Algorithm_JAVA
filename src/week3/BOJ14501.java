package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ14501 {
    static int n;
    static int[] t = new int[20];
    static int[] p = new int[20];
    static int[] visited = new int[20];

    static int ret = -1;

    static void go(int now, int sum) {
        if(now == n+1) {
            ret = Math.max(ret, sum);
            return;
        }
        // 해당 상담을 고를때
        if(now + t[now] <= n+1) {
            for(int i = now; i < now + t[now]; i++) {
                visited[i] = 1;
            }
            go(now + t[now], sum + p[now]);
    
            for(int i = now; i < now + t[now]; i++) {
                visited[i] = 0;
            }
        }

        // 해당 상담을 안 고를때
        go(now+1, sum);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        

        for(int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
            
        }

        go(1, 0);

        System.out.println(ret);
    }
}
