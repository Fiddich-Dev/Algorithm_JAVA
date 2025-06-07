package implementation;


import java.util.*;
import java.io.*;

public class BOJ2573 {

	static int n, m;
	static int[][] a = new int[304][304];
	static int[][] visited = new int[304][304];
	// 녹을 빙하 계산기
	static int[][] temp = new int[304][304];

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ret = 0;

		while(true) {

			temp = new int[304][304];
			visited = new int[304][304];
			ret++;

			// 녹을 빙하 계산
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (a[i][j] != 0) {
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
								continue;
							}
							if (a[ny][nx] == 0) {
								cnt++;
							}
						}
						temp[i][j] = cnt;
					}
				}
			}
			// 녹을 빙하 없는지 체크
			if(check()) {
				ret = 0;
				break;
			}

			// 빙하 녹이기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = Math.max(0, a[i][j] - temp[i][j]);
				}
			}
			// 커넥티드 컴포넌트 계산
			int cp = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j] == 0 && a[i][j] != 0) {
						dfs(i, j);
						cp++;
					}
				}
			}

			if (cp >= 2) {
				break;
			}
		}

		System.out.println(ret);
	}

	static void dfs(int y, int x) {
		visited[y][x] = 1;

		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
				continue;
			}

			if(visited[ny][nx] == 0 && a[ny][nx] != 0) {
				dfs(ny, nx);
			}
		}
	}

	// 녹을 빙하가 없을때
	static boolean check() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(temp[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
}

// 녹을 빙하를 계산한다
// 빙하를 녹인다
// 커넥티드 컴포넌트가 2개이상이면 멈춘다
