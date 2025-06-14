package sweeping;

import java.util.*;
import java.io.*;

public class BOJ15922 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        List<Pair> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            a.add(new Pair(start, end));
        }

        a.sort((p1, p2) -> {
            return p1.start - p2.start;
        });

        int ret = 0;

        int start = a.get(0).start;
        int end = a.get(0).end;

        for(int i = 1; i < a.size(); i++) {
            // 이어 질때
            if(end >= a.get(i).start) {
                end = Math.max(end, a.get(i).end);
            }

            // 안이어질때
            else if(end < a.get(i).start) {
                ret += end - start;
                start = a.get(i).start;
                end = a.get(i).end;
            }
        }
        ret += end - start;

        System.out.println(ret);
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
