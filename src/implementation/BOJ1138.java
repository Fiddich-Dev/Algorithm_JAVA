package implementation;

import java.util.*;
import java.io.*;

public class BOJ1138 {

    static int n;
    // i의 키를 가진 사람이 왼쪽에 가지보다 큰 사람이 k명
    // a[i] = k
    static int[] a = new int[14];
    static int[] visited = new int[14];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] ret = new int[14];
        combi(1, ret);

    }

    static void combi(int start, int[] ret) {
        if(start == n+1) {
            if(check(ret) == true) {

                for (int i = 1; i <= n; i++) {
                    System.out.print(ret[i] + " ");
                }

                System.exit(0);
            }
            return;
        }
        for(int i = a[start]+1; i <= n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                ret[i] = start;

                combi(start+1, ret);

                visited[i] = 0;
                ret[i] = 0;
            }
        }
    }

    static boolean check(int[] ret) {
//        for (int i = 1; i <= n; i++) {
//            System.out.print(ret[i] + " ");
//        }

        for(int i = 1; i <= n; i++) {
            int now = ret[i];
            int cnt = 0;
            for(int j = 1; j < i; j++) {
                if(ret[j] > now) {
                    cnt++;
                }
            }
//            System.out.println(cnt);
            if(cnt != a[now]) {
                return false;
            }
        }
        return true;
    }
}

// a[1] = 2이면 3번부터 가능
// a[2] = 1이면 2번부터 가능
// a[3] = 1이면 2번부터 가능
// a[4] = 0이면 1번부터 가능


