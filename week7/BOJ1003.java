package week7;

import java.util.Arrays;
import java.util.Scanner;

class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class BOJ1003 {
    
    static int t;

    static Pair[] dp = new Pair[42];

    static Pair go(int num) {
        if(num == 1) {
            return new Pair(0, 1);
        }
        if(num == 0) {
            return new Pair(1, 0);
        }

        if(dp[num].a != -1 && dp[num].b != -1) {
            return dp[num];
        }

        return dp[num] = new Pair(go(num-1).a + go(num-2).a, go(num-1).b + go(num-2).b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            
            // dp 초기화
            for (int j = 0; j <= 41; j++) {
                dp[j] = new Pair(-1, -1);
            }


            Pair ret = go(n);


            System.out.println(ret.a + " " + ret.b);

        }

    }
}

// 테이블 dp[n] = {0의 개수, 1의 개수}
// 점화식 dp[n] = {dp[n-1].a + dp[n-2].a, dp[n-1].b + dp[n-2].b}
// 초기화 dp[0] = {1, 0}, dp[1] = {0, 1}