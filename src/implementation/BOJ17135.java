package implementation;

import java.util.*;
import java.io.*;

public class BOJ17135 {

    static int n, m, d;
    static int[][] a = new int[17][17];
    static int[][] a_temp = new int[17][17];
    static int ret = 0;
    static int cnt = 0;

    // 궁수의 위치 a[n][0] ~ a[n][m-1]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                a_temp[i][j] = a[i][j];
            }
        }

        List<Integer> v = new ArrayList<>();
        go(-1, v);


        System.out.println(ret);
    }

    // 궁수 배치하기
    static void go(int start, List<Integer> b) {
        if (b.size() == 3) {
            cnt = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    a[i][j] = a_temp[i][j];
                }
            }

            List<Pair> people = new ArrayList<>();

            people.add(new Pair(n, b.get(0)));
            people.add(new Pair(n, b.get(1)));
            people.add(new Pair(n, b.get(2)));

            for(int i = 0; i < n; i++) {
                atk(people);
                move();
            }

            ret = Math.max(ret, cnt);
            return;
        }
        for (int i = start + 1; i < m; i++) {
            b.add(i);
            go(i, b);
            b.remove(b.size() - 1);
        }
    }

    // 공격
    static void atk(List<Pair> people) {
        List<Pair> e = new ArrayList<>();

        // 적 찾기
        for(Pair p : people) {
            int dis = 987654321;
            int y = -1;
            int x = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if(a[i][j] == 1) {
                        // 적과의 거리
                        int temp = Math.abs(p.y - i) + Math.abs(p.x - j);
                        if(temp < dis && temp <= d) {
                            dis = temp;
                            y = i;
                            x = j;
                        }
                        else if(temp == dis && j < x && temp <= d) {
                            y = i;
                            x = j;
                        }
                    }

                }
            }

            if(y != -1 && x != -1) {
                e.add(new Pair(y, x));
            }

        }

//        System.out.println(e.size());

        for(Pair p : e) {
            if(a[p.y][p.x] == 1) {
                a[p.y][p.x] = 0;

                cnt++;
            }
        }
    }

    // 1칸 전진
    static void move() {
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < m; j++) {
                a[i+1][j] = a[i][j];
            }
        }

        for(int j = 0; j < m; j++) {
            a[0][j] = 0;
        }
    }


    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}