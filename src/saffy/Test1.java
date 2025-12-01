package saffy;

import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for(int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long ret = 0;
            long[][] dp = new long[n+1][n+1];

            for(int i = 0; i < n; i++) {
                dp[i][i] = a[i];
            }

            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    dp[i][j] = (dp[i][j-1] ^ a[j]);
                }
            }

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}

            for(int i = 0; i < n; i++) {
                for(int j = i; j < n; j++) {
                    ret += dp[i][j];
                }
            }

            System.out.println("#" + t + " " + ret);
        }
    }
}
// dp[i][j] = f(i, j)
// dp[i][j] = dp[i][j-1] ^ a[j]

