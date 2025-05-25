package bitmasking;

import java.util.*;

public class BOJ15787 {

	static int n, m;
	
	static int[] train = new int[100004];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			
			if(a == 1) {
				int c = sc.nextInt();
				// 비트 켜기
				train[b] |= (1 << c-1);
			}
			else if(a == 2) {
				int c = sc.nextInt();
				train[b] &= ~(1 << c-1);
			}
			else if(a == 3) {
				train[b] = train[b] << 1;
				train[b] &= ~(1 << 20);
			}
			else if(a == 4) {
				train[b] = train[b] >> 1;
			}
		}
		
		Set<Integer> s = new HashSet<>();
		for(int i = 1; i <= n; i++) {
			s.add(train[i]);
		}
		
		System.out.println(s.size());
		
		
	}
}

//1 i x : i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라. 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
//2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
//3 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다. 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
//4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다. 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
