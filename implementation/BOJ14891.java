package implementation;

import java.util.*;

class Pair {
    int idx;
    int dir;
    public Pair(int idx, int dir) {
        this.idx = idx;
        this.dir = dir;
    }
    
}

// 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.

public class BOJ14891 {

    static List<Integer>[] a = new ArrayList[4];
    static int k;

    static void roll(int idx, int dir) {
        

        Collections.rotate(a[idx], dir);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 4; i++) {
            a[i] = new ArrayList<>();
        }

        for(int i = 0; i < 4; i++) {
            String s = sc.next();
            for(char c : s.toCharArray()) {
                a[i].add(c - '0');
            }
        }
        k = sc.nextInt();

        

        for(int i = 0; i < k; i++) {
            // 돌 톱니바퀴 
            List<Pair> rolling = new ArrayList<>();

            int q = sc.nextInt()-1;
            int w = sc.nextInt();

            rolling.add(new Pair(q, w));

            int dir = w;
            // 오른쪽
            for(int j = q; j < 4-1; j++) {
                if(a[j].get(2) != a[j+1].get(6)) {
                    dir *= -1;
                    rolling.add(new Pair(j+1, dir));
                }
                else {
                    break;
                }
            }
            // 왼쪽 
            dir = w;
            for(int j = q; j > 0; j--) {
                if(a[j].get(6) != a[j-1].get(2)) {
                    dir *= -1;
                    rolling.add(new Pair(j-1, dir));
                }
                else {
                    break;
                }
            }

            for(Pair p : rolling) {
                roll(p.idx, p.dir);
            }

        }

        int sum = 0;
        for(int i = 0; i < 4; i++) {
            if(a[i].get(0) == 1) {
                sum += Math.pow(2, i);
            }
        }

        System.out.println(sum);
    }
}

// 3시는 2번 인덱스
// 9시는 6번 인덱스

// N극이면 0점, S극이면 1점
