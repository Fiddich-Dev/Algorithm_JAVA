package implementation;

import java.util.*;
import java.io.*;

public class BOJ14891 {

    static int[][] a = new int[4][8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++) {
            String s = sc.next();
            for(int j = 0; j < 8; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            num--;
            int dir = sc.nextInt();
            // 돌릴거 찾기
            List<Pair> arr = new ArrayList<>();
            arr.add(new Pair(num, dir));

            int dir_temp = dir;
            for(int j = num; j < 3; j++) {
                if(a[j][2] != a[j+1][6]) {
                    dir_temp *= -1;
                    arr.add(new Pair(j+1, dir_temp));
                }
                else {
                    break;
                }
            }

            dir_temp = dir;
            for(int j = num; j >= 1; j--) {
                if(a[j][6] != a[j-1][2]) {
                    dir_temp *= -1;
                    arr.add(new Pair(j-1, dir_temp));
                }
                else {
                    break;
                }
            }

            // 돌리기
            for(Pair p : arr) {
                roll(p.num, p.dir);
            }
        }

        int ret = 0;
        for(int i = 0; i < 4; i++) {
            if(a[i][0] == 1) {
                ret += 1 << i;
            }
        }

        System.out.println(ret);
    }



    // 1 : 시계, -1 : 반시계
    static void roll(int num, int dir) {
        if(dir == 1) {
            int temp = a[num][7];
            for(int i = 6; i >= 0; i--) {
                a[num][i+1] = a[num][i];
            }
            a[num][0] = temp;
        }
        else {
            int temp = a[num][0];
            for(int i = 1; i <= 7; i++) {
                a[num][i-1] = a[num][i];
            }
            a[num][7] = temp;
        }
    }

    static class Pair {
        int num;
        int dir;

        public Pair(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }

}

