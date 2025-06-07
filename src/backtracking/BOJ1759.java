package backtracking;

import java.util.*;
import java.io.*;

public class BOJ1759 {

    static int n, m;
    static List<Character> a = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            char temp = st.nextToken().charAt(0);
            a.add(temp);
        }

        Collections.sort(a);

        List<Character> v = new ArrayList<>();
        combi(-1, v);

        System.out.println(sb);

    }

    static void combi(int start, List<Character> b) {
        if(b.size() == n) {
            if(check(b)) {
                for (char c : b) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i = start+1; i < m; i++) {
            b.add(a.get(i));
            combi(i, b);
            b.remove(b.size()-1);
        }
    }

    static boolean check(List<Character> b) {
        int cnt1 = 0;
        int cnt2 = 0;

        for(char c : b) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt1++;
            }
            else {
                cnt2++;
            }
        }

        return (cnt1 >= 1 && cnt2 >= 2);
    }
}
