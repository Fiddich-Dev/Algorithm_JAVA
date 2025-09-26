package baaarkingDog.sort;

import java.util.*;

public class BOJ10814 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            a[i] = new Pair(age, name, i);
        }

        Arrays.sort(a, (p1, p2) -> {
            if(p1.age == p2.age) {
                return p1.date - p2.date;
            }
            return p1.age - p2.age;
        });

        for(Pair p : a) {
            System.out.println(p.age + " " + p.name);
        }
    }

    static class Pair {
        int age;
        String name;
        int date;

        public Pair(int age, String name, int date) {
            this.age = age;
            this.name = name;
            this.date = date;
        }
    }
}
