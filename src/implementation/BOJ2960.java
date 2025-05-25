package implementation;

import java.util.*;

public class BOJ2960 {
	
	static int n, k;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		int[] a = new int[1004];
		for(int i = 2; i <= n; i++) {
			a[i] = i;
		}
		
		int cnt = 0;
//		int now = 2;
		
		while(true) {
			int now = -1;
			
			// 가장 작은 소수 찾기
			for(int i = 2; i <= n; i++) {
				if(a[i] != 0) {
					now = i;
					break;
				}
			}
			
			for(int i = now; i <= n; i += now) {
				if(a[i] != 0) {
					a[i] = 0;
					cnt++;
				}
				
				if(cnt == k) {
					System.out.println(i);
					return;
				}
			}
			
			
		}
		
	}
}
