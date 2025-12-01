package saffy;

import java.util.Scanner;

public class Test1_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for(int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] dp = new int[n+1]; // 첫번째부터 n 번째까지 xor 연산의 결과
            dp[1] = a[0];

            for(int i = 2; i <= n; i++) {
                dp[i] = dp[i-1] ^ a[i-1];
            }

//            for(int i = 1; i <= n; i++) {
//                System.out.print(dp[i] + " ");
//            }
//            System.out.println();

            int ret = 0;

            for(int i = 1; i <= n; i++) {
                for(int j = i; j <= n; j++) {
                    if(i == j) {
                        ret += a[i-1];
                        continue;
                    }

                    ret += dp[j] ^ dp[i-1];
                }
            }

            System.out.println("#" + t + " " + ret);
        }
    }
}
// dp[i] = f(0, i)
// dp[i] = dp[i-1] ^ a[i]


