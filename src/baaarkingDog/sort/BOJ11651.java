package baaarkingDog.sort;

import java.util.*;

public class BOJ11651 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) {
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(a, (p1, p2) -> {
            if(p1.y == p2.y) {
                return p1.x - p2.x;
            }
            return p1.y - p2.y;
        });

        for(int i = 0; i < n; i++) {
            System.out.println(a[i].x + " " + a[i].y);
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
