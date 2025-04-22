package week7;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ12865 {
    static int n, k;
    static int w, v;
    // 무게
    static ArrayList<Integer> a = new ArrayList<>();
    // 가치
    static ArrayList<Integer> b = new ArrayList<>();

    static int[] dp = new int[100004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            w = sc.nextInt();
            v = sc.nextInt();
            a.add(w);
            b.add(v);
        }

        for(int i = 0; i < n; i++) {
            for(int j = k; j >= a.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j-a.get(i)] + b.get(i));
            }
        }

        System.out.println(dp[k]);
    }
}
// 4 7
// 6 13
// 4 8
// 3 6
// 5 12

// 테이블 : dp[무게] = 무게 만큼 넣어서 만들수 있는 가치
// 점화식 : dp[n] = max(dp[n-6] + 13, dp[n-4] + 8, dp[n-3] + 6, dp[n-5] + 12)
// 초기화 : dp[0] = 0
