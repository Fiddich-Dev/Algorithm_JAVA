package week7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1535 {
    static int n;
    // 잃는 체력
    static ArrayList<Integer> a = new ArrayList<>();
    // 얻는 기쁨
    static ArrayList<Integer> b = new ArrayList<>();

    static int[] dp = new int[104];
    static int temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            temp = sc.nextInt();
            a.add(temp);
        }
        for(int i = 0; i < n; i++) {
            temp = sc.nextInt();
            b.add(temp);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 100; j > a.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - a.get(i)] + b.get(i));
            }
        }

        System.out.println(dp[100]);
    }
}

// 테이블 : dp[체력] = 얻을 수 있는 최대 기쁨
// 점화식 : max(dp[n] = dp[n-1] + 20, dp[n-21] + 30, dp[n-79] + 25)
// 초기화 : dp[0] = 0;