package lis;

import java.util.*;
import java.io.*;

public class BOJ11053 {


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[1004];
//        // i번째 값을 마지막으로 갖는 lis의 길이
//        int[] cnt = new int[1004];
//        for(int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//            cnt[i] = 1;
//        }
//
//        int ret = 0;
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                if(a[i] > a[j]) {
//                    cnt[i] = Math.max(cnt[i], cnt[j]+1);
//                }
//            }
//            ret = Math.max(ret, cnt[i]);
//        }
//
//        System.out.println(ret);
//
//    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[1004];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[1004];
        int len = 0;

        for(int i = 0; i < n; i++) {
            int pos = solve(lis, len, a[i]);
            if(pos == len) {
                len++;
            }
            lis[pos] = a[i];
        }

        System.out.println(len);

    }

    // 크거나 같은 값을 찾기
    static int solve(int[] lis, int len, int target) {
        int l = 0;
        int r = len;

        while(l < r) {
            int mid = (l + r) / 2;
            if(lis[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }

}

