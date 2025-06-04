package implementation;

import java.util.*;
import java.io.*;

public class BOJ20055 {

    static int n, k;
    static int cnt = 0;
    // 내구도
    static int[] a = new int[204];
    // 로봇위치에 1
    static int[] b = new int[104];
    static int ret = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            ret++;

            // 레일 회전
            int temp = a[2*n - 1];
            for(int i = 2*n-2; i >= 0; i--) {
                a[i+1] = a[i];
            }
            a[0] = temp;

            // 로봇도 같이
            for(int i = n-2; i >= 0; i--) {
                b[i+1] = b[i];
            }
            b[0] = 0;
            b[n-1] = 0;

            // 로봇이 움질일수 있으면
            for(int i = n-2; i >= 0; i--) {
                if(b[i] == 1 && a[i+1] > 0 && b[i+1] == 0) {
                    a[i+1]--;
                    if(a[i+1] == 0) {
                        cnt++;
                    }
                    b[i+1] = 1;
                    b[i] = 0;
                }
            }
            b[n-1] = 0;

            if(a[0] != 0) {
                b[0] = 1;
                a[0]--;
                if(a[0] == 0) {
                    cnt++;
                }
            }



            if(cnt >= k) {
                break;
            }

        }

        System.out.println(ret);

    }
}




