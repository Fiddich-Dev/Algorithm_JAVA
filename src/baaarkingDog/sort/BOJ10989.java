package baaarkingDog.sort;

import java.util.*;
import java.io.*;

public class BOJ10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int mx = -1;

        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        List<Integer>[] temp = new ArrayList[10];


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            mx = Math.max(mx, s.length());
            a[i] = Integer.parseInt(s);
        }

        for(int i = 0; i < mx; i++) {
            for(int j = 0; j < 10; j++) {
                temp[j] = new ArrayList<>();
            }

            for(int j = 0; j < n; j++) {
                int num = digit(a[j], i);
                temp[num].add(a[j]);
            }

            int now = 0;
            for(int j = 0; j < 10; j++) {
                for(int k : temp[j]) {
                    a[now] = k;
                    now++;
                }
                temp[j].clear();
            }
        }

        for(int i : a) {
            sb.append(i).append("\n");
        }



        System.out.println(sb);
    }

    static int digit(int num, int idx) {
        int temp = 1;
        for(int i = 0; i < idx; i++) {
            temp *= 10;
        }
        return (num % (temp*10)) / temp;
    }
}
