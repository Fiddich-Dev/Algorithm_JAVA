package implementation;

import java.util.*;

public class BOJ2960 {

	static int n, k;
	// a[i] = 1이면 지운거
	static int[] a = new int[1004];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		int cnt = 0;
		int ret = -1;

		while(true) {
			// 가장 작은 수 찾기
			int temp = 0;
			for(int i = 2; i <= n; i++) {
				if(a[i] == 0) {
					temp = i;
					break;
				}
			}

			// 배수를 지운다
			for(int i = temp; i <= n; i += temp) {
				if(a[i] == 0) {
					a[i] = 1;
					cnt++;

					if(cnt == k) {
						System.out.println(i);
						return;
					}
				}
			}

		}
	}
}
