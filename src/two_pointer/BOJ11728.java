package two_pointer;

import java.util.*;
import java.io.*;

public class BOJ11728 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);
        Collections.sort(b);

        List<Integer> ret = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while(true) {
            if(a.get(p1) < b.get(p2)) {
                ret.add(a.get(p1));
                p1++;
            }
            else {
                ret.add(b.get(p2));
                p2++;
            }

            if(p1 == n || p2 == m) {
                break;
            }
        }

        for(int i = p1; i < n; i++) {
            ret.add(a.get(i));
        }
        for(int i = p2; i < m; i++) {
            ret.add(b.get(i));
        }

        for(int i = 0; i < n+m; i++) {
            sb.append(ret.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }
}



