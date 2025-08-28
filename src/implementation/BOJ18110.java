package implementation;

import java.util.*;
import java.io.*;

public class BOJ18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int sum = 0;
        int cnt = 0;
        int start = (int) Math.round(n * 0.15);
        for(int i = start; i < n - start; i++) {
            sum += a[i];
            cnt++;
        }

        System.out.println(Math.round((float) sum / cnt));
    }
}




