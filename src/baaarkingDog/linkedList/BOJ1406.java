package baaarkingDog.linkedList;

import java.util.*;
import java.io.*;

public class BOJ1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        LinkedList<Character> ll = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            ll.add(s.charAt(i));
        }

        ListIterator<Character> li = ll.listIterator();
        while(li.hasNext()) {
            li.next();
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if(c == 'L') {
                if(li.hasPrevious()) {
                    li.previous();
                }
            }
            else if(c == 'D') {
                if(li.hasNext()) {
                    li.next();
                }
            }
            else if(c == 'B') {
                if(li.hasPrevious()) {
                    li.previous();
                    li.remove();
                }
            }
            else if(c == 'P') {
                char temp = st.nextToken().charAt(0);
                li.add(temp);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char chr : ll) {
            sb.append(chr);
        }
        System.out.println(sb);
    }
}
