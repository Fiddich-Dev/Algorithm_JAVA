package dp;

import java.util.*;

public class BOJ11054 {

    static int n;
    static List<Integer> a = new ArrayList<>();
    static int[] dp1 = new int[1004];
    static int[] dp2 = new int[1004];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] cnt1 = new int[n];
        int[] cnt2 = new int[n];

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            a.add(temp);
            dp1[i] = 1;
            dp2[i] = 1;
            cnt1[i] = 1;
            cnt2[i] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a.get(i) > a.get(j)) {
                    cnt1[i] = Math.max(cnt1[i], cnt1[j]+1);
                    dp1[i] = Math.max(dp1[i], dp1[j]+1);
                }
            }
        }

        Collections.reverse(a);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a.get(i) > a.get(j)) {
                    cnt2[i] = Math.max(cnt2[i], cnt2[j]+1);
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
            }
        }
        int[] dp_reverse = new int[n];
        for(int i = 0; i < n; i++) {
            dp_reverse[i] = dp2[n-1-i];
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            ret = Math.max(ret, dp1[i] + dp_reverse[i] - 1);
        }

        System.out.println(ret);


    }


}

// 테이블 : dp[i] = i번째수까지 봤을때 가장 긴 바이토닉 수열의 길이
// 점화식 : dp[i] = 조건을 만족하면 +1 아니면 +0
// 초기화 : dp[0] = 1

