package baaarkingDog.binarysearch;

import java.util.*;
import java.io.*;

public class BOJ10816 {

    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m  = Integer.parseInt(st.nextToken());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        for(int i = 0; i < m; i++) {
            int start = lowerBound(n, b[i]);
            int end = upperBound(n, b[i]);

            sb.append(end - start).append(" ");
        }
        System.out.println(sb);
    }

    // 배열에서 target 이상의 값이 처음 등장하는 인덱스
    static int lowerBound(int len, int target) {
        int l = 0;
        int r = len;

        while(l < r) {
            int mid = (l + r) / 2;
            if(a[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 배열에서 타켓 초과의 수가 처음 등장하는 인덱스
    static int upperBound(int len, int target) {
        int l = 0;
        int r = len;
        while(l < r) {
            int mid = (l + r) / 2;
            if(a[mid] > target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}
