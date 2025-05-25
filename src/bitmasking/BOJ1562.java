package bitmasking;

import java.util.*;

public class BOJ1562 {

	static int num;
	static int[][][] dp = new int[104][10][1050];
	
	
	static int go(int n, int now, int visited) {
		
		if(now == 10 || now == -1) {
			return 0;
		}
		
		if(n == num) {
			if(visited == (1 << 10) - 1) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		if(dp[n][now][visited] != -1) {
			return dp[n][now][visited];
		}
		
		// 오르막
		int a = 0;
		if(n == 9) {
			
		}
		
		// 내리막
		
		
		return dp[n][now][visited] = (go(n+1, now+1, visited |= 1 << now) + go(n+1, now-1, visited |= 1 << (now-2))) % 1000000000;
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		int ret = 0;
		
		ret += go(1, 1, 1 << 0);
		ret += go(1, 2, 1 << 1);
		ret += go(1, 3, 1 << 2);
		ret += go(1, 4, 1 << 3);
		ret += go(1, 5, 1 << 4);
		ret += go(1, 6, 1 << 5);
		ret += go(1, 7, 1 << 6);
		ret += go(1, 8, 1 << 7);
		ret += go(1, 9, 1 << 8);
		
		System.out.println(ret);
	
		
		
	}
}

// 테이블 : dp[자릿수][현재숫자][지금까지 사용한 수] = 경우의수 
// 점화식 : dp[n][num][s] = dp[n-1][num-1][s-num] + dp[n-1][num+1][s-num]
// 초기화 : dp[]