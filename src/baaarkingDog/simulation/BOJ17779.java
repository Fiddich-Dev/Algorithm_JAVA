package baaarkingDog.simulation;

import java.util.*;
import java.io.*;

public class BOJ17779 {

    static int n;
    static int[][] a;
    static int[][] line;
    static int ret = Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;
    static int totalPeople = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                totalPeople += a[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int y = i;
                int x = j;
                for(int k = 1; k < n; k++) {
                    for(int l = 1; l < n; l++) {
                        int d1 = k;
                        int d2 = l;

                        if(y+d1 < 0 || x-d1 < 0 || y+d1 >= n || x-d1 >= n) {
                            continue;
                        }
                        if(y+d2 < 0 || x+d2 < 0 || y+d2 >= n || x+d2 >= n) {
                            continue;
                        }
                        if(y+d1+d2 < 0 || x-d1+d2 < 0 || y+d1+d2 >= n || x-d1+d2 >= n) {
                            continue;
                        }

//                        solution(y, x, d1, d2);
                        solve(y, x, d1, d2);
                        calc();
                    }
                }
            }
        }

        System.out.println(ret);
//        System.out.println(min);
    }

    static void solve(int y, int x, int d1, int d2) {
        line = new int[n][n];
        // 5 구역 채우기
        for(int i = 0; i <= d1; i++) {
            line[y+i][x-i] = 5;
            line[y+d2+i][x+d2-i] = 5;
        }
        for(int i = 0; i <= d2; i++) {
            line[y+i][x+i] = 5;
            line[y+d1+i][x-d1+i] = 5;
        }

        for(int i = y+1; i < y+d1+d2; i++) {  // y부터 시작
            boolean isInside = false;
            for(int j = 0; j < n; j++) {
                if(line[i][j] == 5) isInside = !isInside;
                if(isInside) line[i][j] = 5;
            }
        }

        // 1
        for(int i = 0; i < y+d1; i++) {
            for(int j = 0; j <= x; j++) {
                if(line[i][j] == 5) {
                    continue;
                }
                line[i][j] = 1;
            }
        }
        // 2
        for(int i = 0; i <= y+d2; i++) {
            for(int j = n-1; j >= x+1; j--) {
                if(line[i][j] == 5) {
                    continue;
                }
                line[i][j] = 2;
            }
        }
        // 3
        for(int i = y+d1; i < n; i++) {
            for(int j = 0; j < x+d2-d1; j++) {
                if(line[i][j] == 5) {
                    continue;
                }
                line[i][j] = 3;
            }
        }
        // 4
        for(int i = y+d2+1; i < n; i++) {
            for(int j = n-1; j >= x+d2-d1; j--) {
                if(line[i][j] == 5) {
                    continue;
                }
                line[i][j] = 4;
            }
        }
    }

    static void calc() {
        int[] cnt = new int[5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int area = line[i][j];
//                if(area == 0) {
//                    cnt[4] += a[i][j];
//                }
//                else {
                    cnt[area-1] += a[i][j];
//                }
            }
        }

        Arrays.sort(cnt);
        ret = Math.min(ret, cnt[4] - cnt[0]);

    }

    static void solution(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[n][n];

        // 경계선 세팅
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] peopleSum = new int[5];

        // 1 구역 인구수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                peopleSum[0] += a[i][j];
            }
        }

        // 2 구역 인구수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (border[i][j]) break;
                peopleSum[1] += a[i][j];
            }
        }

        // 3 구역 인구수
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                peopleSum[2] += a[i][j];
            }
        }

        // 4 구역 인구수
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                peopleSum[3] += a[i][j];
            }
        }

        // 5 구역 인구수
        peopleSum[4] = totalPeople;

        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }

        // 정렬
        Arrays.sort(peopleSum);

        // 최대 - 최소
        min = Math.min(min, peopleSum[4] - peopleSum[0]);
    }
}
