package baaarkingDog.backtracking;

import java.util.*;

public class BOJ1759 {

    static int l, c;
    static char[] a;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        a = new char[c];



        for(int i = 0; i < c; i++) {
            a[i] = sc.next().charAt(0);
        }

        Arrays.sort(a);

        List<Character> v = new ArrayList<>();
        combi(-1, v, 0, 0);

        System.out.println(sb);

    }

    static void combi(int start, List<Character> b, int y, int x) { // y는 모음
        if(b.size() == l) {
            if(y >= 1 && x >= 2) {
                for(char c : b) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i = start+1; i < c; i++) {
            b.add(a[i]);
            if(a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u') {
                y++;
            }
            else {
                x++;
            }

            combi(i, b, y, x);

            b.remove(b.size()-1);
            if(a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u') {
                y--;
            }
            else {
                x--;
            }

        }
    }
}
