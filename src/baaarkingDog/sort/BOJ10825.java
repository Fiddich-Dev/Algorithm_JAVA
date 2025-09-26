package baaarkingDog.sort;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10825 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Person[] a = new Person[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());

            a[i] = new Person(name, s1, s2, s3);
        }

        Arrays.sort(a, (p1, p2) -> {
            if(p1.s1 == p2.s1) {
                if(p1.s2 == p2.s2) {
                    if(p1.s3 == p2.s3) {
                        return p1.name.compareTo(p2.name);
                    }
                    return p2.s3 - p1.s3;
                }
                return p1.s2 - p2.s2;
            }
            return p2.s1 - p1.s1;
        });

        StringBuilder sb = new StringBuilder();
        for(Person p : a) {
            sb.append(p.name).append("\n");
        }

        System.out.println(sb);
    }


    static class Person {
        String name;
        int s1;
        int s2;
        int s3;

        public Person(String name, int s1, int s2, int s3) {
            this.name = name;
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }
    }
}
