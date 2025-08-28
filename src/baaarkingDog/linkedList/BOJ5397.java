package baaarkingDog.linkedList;

import java.util.*;
import java.io.*;

public class BOJ5397 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int q = 0;  q < t; q++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            LinkedList<Character> ll = new LinkedList<>();
            ListIterator<Character> lt = ll.listIterator();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c == '<') {
                    if(lt.hasPrevious()) {
                        lt.previous();
                    }
                }
                else if(c == '>') {
                    if(lt.hasNext()) {
                        lt.next();
                    }
                }
                else if(c == '-') {
                    if(lt.hasPrevious()) {
                        lt.previous();
                        lt.remove();
                    }
                }
                else {
                    lt.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();

            for(char chr : ll) {
                sb.append(chr);
            }

            System.out.println(sb);

        }
    }
}
