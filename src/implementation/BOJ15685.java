package implementation;

import java.util.*;

public class BOJ15685 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            a.add(new Person(name, day, month, year));
        }

        // 나이 내림
        a.sort((p1, p2) -> {
            if(p1.year == p2.year) {
                if(p1.month == p2.month) {
                    return p1.day - p2.day;
                }
                return p1.month - p2.month;
            }
            return p1.year - p2.year;
        });

        System.out.println(a.get(n-1).name);
        System.out.println(a.get(0).name);

    }

    static class Person {
        String name;
        int day;
        int month;
        int year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

}
