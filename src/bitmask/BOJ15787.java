package bitmask;

import java.util.*;
import java.io.*;

public class BOJ15787 {

	static int n, m;
	static int[] train = new int[100004];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < m; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken())-1;
			int c = 0;
			if(a == 1 || a == 2) {
				c = Integer.parseInt(st.nextToken())-1;
			}

			if(a == 1) {
				train[b] |= (1 << c);
			}
			else if(a == 2) {
				train[b] &= ~(1 << c);
			}
			else if(a == 3) {
				train[b] = train[b] << 1;
				train[b] %= (1 << 20);
			}
			else if(a == 4) {
				train[b] = train[b] >> 1;
			}
		}

		Set<Integer> set = new HashSet<>();

		for(int i = 0; i < n; i++) {
			set.add(train[i]);
		}

		System.out.println(set.size());


	}


}

//1 i x : i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라. 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
//2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
//3 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다. 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
//4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다. 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
