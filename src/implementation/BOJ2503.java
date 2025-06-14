package implementation;

import java.util.*;

public class BOJ2503 {

    static int n;
    static int[] a = new int[1004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < 1004; i++) {
            a[i] = i;
        }

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int s = sc.nextInt();
            int b = sc.nextInt();

            solve(num, s, b);

//            for(int j = 100; j < 1000; j++) {
//                System.out.println(a[j]);
//            }
        }

        int ret = 0;
        for(int i = 100; i < 1000; i++) {
            if(a[i] != 0) {
                ret++;
            }
        }

        System.out.println(ret);
    }

    static void solve(int num, int s, int b) {
        for(int i = 100; i < 1000; i++) {
            if(a[i] == 0) {
                continue;
            }

            // 중복으로 고른 수 제거
            int[] visited = new int[10];
            int q = i / 100;
            int w = i / 10 % 10;
            int e = i % 10;
            visited[q] += 1;
            visited[w] += 1;
            visited[e] += 1;
            if(visited[0] != 0) {
                a[i] = 0;
                continue;
            }

            if(visited[q] > 1|| visited[w] > 1 || visited[e] > 1) {
                a[i] = 0;
                continue;
            }
            // 조건에 맞지 않는 수 제거
            int cntS = 0;
            int cntB = 0;
            String tempI = String.valueOf(i);
            String tempNum = String.valueOf(num);

            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(tempNum.charAt(j) == tempI.charAt(k)) {
                        if(j == k) {
                            cntS++;
                            break;
                        }
                        else {
                            cntB++;
                            break;
                        }
                    }
                }
            }

            if(cntS != s || cntB != b) {
                a[i] = 0;
            }

        }
    }




}


// 100 ~ 999까지
// 애초에 중복되는 건 제외
// s, b조건에 안 맞는거 제외