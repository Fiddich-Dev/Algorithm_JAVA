package baaarkingDog.sort;

import java.util.*;
import java.io.*;

public class BOJ11931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        for(int i = n-1; i >= 0; i--) {
            sb.append(a[i]).append("\n");
        }

        System.out.println(sb);
    }
}
