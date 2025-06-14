package implementation;

import java.util.*;

public class BOJ5635 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Student> a = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            a.add(new Student(year, month, day, name));
        }

        a.sort((s1, s2) -> {
            if(s1.year == s2.year) {
                if(s1.month == s2.month) {
                    return s2.day - s1.day;
                }
                return s2.month - s1.month;
            }
            return s2.year - s1.year;
        });

        System.out.println(a.get(0).name);
        System.out.println(a.get(n-1).name);
    }

    static class Student {
        int year;
        int month;
        int day;
        String name;

        public Student(int year, int month, int day, String name) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.name = name;
        }
    }
}
