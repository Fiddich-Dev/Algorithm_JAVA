package baaarkingDog.simulation;

import java.util.*;

public class BOJ17281 {

    static int n;
    static int[][] a;
    static int[] temp = new int[9];
    static int[] visited = new int[9];
    static int ret = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][9];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 9; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        List<Integer> v = new ArrayList<>();

        go(v);

        System.out.println(ret);
    }

    static void go(List<Integer> b) {
        if(b.size() == 8) {
            b.add(3, 0);

//            for(int i : b) {
//                System.out.print(i + " ");
//            }
//            System.out.println();

            // 순서 정함
            int[] map = new int[4];
            int out = 0;
            int score = 0;
            int startIdx = 0;
            for(int i = 0; i < n; i++) { // 이닝
                out = 0;
                map = new int[4];
                while(out < 3) { // 타순
                    int person = b.get(startIdx % 9);
                    int hit = a[i][person];
                    startIdx++;

                    if(hit == 0) {
                        out++;
                    }
                    else { // 공을 쳤을때
                        map[0] = 1;
                        for(int k = 3; k >= 0; k--) {
                            if(map[k] == 1) {
                                int nextIdx = k + hit;
                                if(nextIdx > 3) {
                                    score++;
                                }
                                else {
                                    map[nextIdx] = 1;
                                }
                                map[k] = 0;
                            }
                        }
                    }
                }
            }


//            System.out.println(score);
            ret = Math.max(ret, score);

            b.remove(3);
            return;
        }
        for(int i = 1; i < 9; i++) {
            if(visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            b.add(i);

            go(b);

            b.remove(b.size() - 1);
            visited[i] = 0;

        }
    }
}
