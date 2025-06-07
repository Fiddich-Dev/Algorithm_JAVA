package bitmask;

import java.util.*;

public class BOJ1562 {

	static int n;
	static int mod = 1000000000;
	static long[][][] dp = new long[104][10][1 << 10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for(int i = 1; i < 10; i++) {
			dp[1][i][1 << i] = 1;
		}


	}
}

// 0 ~ 9가 모두 사용되야함
// 각 자리가 1차이 나야함
// 젤 앞은 0이 오면 안됨

// 9 8 7 6 5 4 3 2 1 0
// 완탐 2^100 안됨

// 8 9 8 7 6 5 4 3 2 1 0
// 9 8 7 6 5 4 3 2 1 0 1

// dp[n][num][bit] = n자리 수 중, 마지막 숫자가 num이고 bit의 숫자들을 사용한 계단수의 수
// dp[n][num][bit] = dp[n-1][num+1][bit] + dp[n-1][num-1][bit]

