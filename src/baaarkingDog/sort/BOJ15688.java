package baaarkingDog.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15688 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[2000004];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            a[num + 1000000]++;
        }

        for(int i = 0; i < 2000004; i++) {
            for(int j = 0; j < a[i]; j++) {
                sb.append(i - 1000000).append("\n");
            }
        }

        System.out.println(sb);
    }
}
