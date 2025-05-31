package implementation;

import java.util.*;
import java.io.*;

public class BOJ18110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Integer> a = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            a.add(temp);
        }

        Collections.sort(a);

        int sum = 0;
        int start = (int) Math.round(n * 0.15);


        for(int i = start; i < n - start; i++) {
            sum += a.get(i);
        }

        int cnt = n - start*2;
        int avg = (int) Math.round((float) sum / cnt);

        System.out.println(avg);
    }
}




