package saffy;

import java.util.*;

public class SWEA1240 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for(int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for(int i = 0; i < n; i++) {
                String s = sc.next();
                for(int j = 0; j < m; j++) {
                    a[i][j] = s.charAt(j) - '0';
                }
            }

            Pair p = findStart(n, m, a);
            int sy = p.y;
            int sx = p.x - 7;
            List<Integer> arr = new ArrayList<>();

            for(int i = 0; i < 8; i++) {
                sx = sx + 7;
                int cnt = 1;
                List<Integer> temp = new ArrayList<>();
//                int sum = 0;
                int now = a[sy][sx];

                for(int j = 1; j < 7; j++) {
                    if(a[sy][sx + j] == now) {
                        cnt++;
                    }
                    else {
                        temp.add(cnt);
                        cnt = 1;
                        now = a[sy][sx + j];
                    }
                }

                temp.add(cnt);
                arr.add(table(temp));
            }

//            for(int i : arr) {
//                System.out.print(i + " ");
//            }
//            System.out.println();

            int ret = 0;
            for(int i = 0; i < 8; i++) {
                if(i % 2 == 0) {
                    ret += arr.get(i) * 3;
                }
                else {
                    ret += arr.get(i);
                }
//                System.out.println(ret);
            }

//            System.out.println(ret);

            if(ret % 10 == 0) {
                int result = 0;
                for(int i = 0; i < 8; i++) {
                    result += arr.get(i);
                }
                System.out.println("#" + t + " " + result);
            }
            else {
                System.out.println("#" + t + " " + 0);
            }

        }

    }

    static Integer table(List<Integer> temp) {
        if(temp.get(0) == 3 && temp.get(1) == 2 && temp.get(2) == 1 && temp.get(3) == 1) {
            return 0;
        }
        else if(temp.get(0) == 2 && temp.get(1) == 2 && temp.get(2) == 2 && temp.get(3) == 1) {
            return 1;
        }
        else if(temp.get(0) == 2 && temp.get(1) == 1 && temp.get(2) == 2 && temp.get(3) == 2) {
            return 2;
        }
        else if(temp.get(0) == 1 && temp.get(1) == 4 && temp.get(2) == 1 && temp.get(3) == 1) {
            return 3;
        }
        else if(temp.get(0) == 1 && temp.get(1) == 1 && temp.get(2) == 3 && temp.get(3) == 2) {
            return 4;
        }
        else if(temp.get(0) == 1 && temp.get(1) == 2 && temp.get(2) == 3 && temp.get(3) == 1) {
            return 5;
        }
        else if(temp.get(0) == 1 && temp.get(1) == 1 && temp.get(2) == 1 && temp.get(3) == 4) {
            return 6;
        }
        else if(temp.get(0) == 1 && temp.get(1) == 3 && temp.get(2) == 1 && temp.get(3) == 2) {
            return 7;
        }
        else if(temp.get(0) == 1 && temp.get(1) == 2 && temp.get(2) == 1 && temp.get(3) == 3) {
            return 8;
        }
        else if(temp.get(0) == 3 && temp.get(1) == 1 && temp.get(2) == 1 && temp.get(3) == 2) {
            return 9;
        }
        return null;
    }

    static Pair findStart(int n, int m, int[][] a) {
        for(int i = 0; i < n; i++) {
            for(int j = m-1; j >= 0; j--) {
                if(a[i][j] == 1) {
                    return new Pair(i, j - 55);
                }
            }
        }
        return null;
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
