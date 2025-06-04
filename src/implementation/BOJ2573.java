package implementation;


import java.util.*;

public class BOJ2573 {

	static int n, m;
	static int[][] a = new int[304][304];
	static int[][] visited = new int[304][304];
	// 바다와 닿아있는 면의 수
	static int[][] melt = new int[304][304];
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	
	// 녹을 높이 구하기
	static void calc(List<Pair> ice) {
		// 녹을 높이 초기화
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				melt[i][j] = 0;
			}
		}
		// 녹을 높이 구하기
		for(Pair p : ice) {
			int y = p.y;
			int x = p.x;
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				if(a[ny][nx] == 0) {
					melt[y][x]++;
				}
			}
		}
		
		// 녹이기
		for(Pair p : ice) {
			int y = p.y;
			int x = p.x;
			
			a[y][x] = Math.max(a[y][x] - melt[y][x], 0);  
		}
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = 1;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
				continue;
			}
			
			if(visited[ny][nx] == 0 && a[ny][nx] != 0) {
				dfs(ny, nx);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		List<Pair> ice = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j] != 0) {
					ice.add(new Pair(i, j));
				}
			}
		}
		
		int ret = 0;
		
		
		while(true) {
			

			
			// 두 덩이 이상인지 확인
			int cc = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					visited[i][j] = 0;
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(visited[i][j] == 0 && a[i][j] != 0) {
						dfs(i, j);
						cc++;
					}
				}
			}
			if(cc >= 2) {
				break;
			}
			
			// 다 녹았는지 확인
			if(check(ice) == true) {
				ret = 0;
				break;
			}
			
			
			
			calc(ice);
			ret++;
		}
		
		System.out.println(ret);
		
	}
	
	// true면 다 녹은거
	static boolean check(List<Pair> ice) {
		for(Pair p : ice) {
			if(a[p.y][p.x] != 0) {
				return false;
			}
		}
		return true;
	}

	static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
