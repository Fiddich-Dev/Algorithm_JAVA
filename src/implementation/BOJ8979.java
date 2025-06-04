package implementation;

import java.util.*;
import java.io.*;

public class BOJ8979 {

    static int n, k;
    static List<Status> arr = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.add(new Status(a, b, c, d));
        }

        arr.sort((s1, s2) -> {
            if(s1.g == s2.g) {
                if(s1.s == s2.s) {
//                    if(s1.b == s2.b) {
//                        return s2.num - s1.num;
//                    }
                    return s2.b - s1.b;
                }
                return s2.s - s1.s;
            }
            return s2.g - s1.g;
        });

        System.out.println(arr.get(k-1).num);
    }

    static class Status {
        int num;
        int g;
        int s;
        int b;

        public Status(int num, int g, int s, int b) {
            this.num = num;
            this.g = g;
            this.s = s;
            this.b = b;
        }
    }
}
