package two_pointer;

import java.util.*;
import java.io.*;

public class BOJ11728 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            a.add(temp);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            b.add(temp);
        }

        Collections.sort(a);
        Collections.sort(b);

        int p1 = 0;
        int p2 = 0;

        while(true) {

            if(p1 == n) {
                sb.append(b.get(p2)).append(" ");
//                System.out.print(b.get(p2) + " ");
                p2++;
            }
            else if(p2 == m) {
                sb.append(a.get(p1)).append(" ");
//                System.out.print(a.get(p1) + " ");
                p1++;
            }
            else {
                if (a.get(p1) <= b.get(p2)) {
                    sb.append(a.get(p1)).append(" ");
                    p1++;
                } else {
                    sb.append(b.get(p2)).append(" ");
                    p2++;
                }
            }

            if(p1 == n && p2 == m) {
                break;
            }
        }
        System.out.println(sb);
    }
}


