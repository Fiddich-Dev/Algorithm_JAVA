package implementation;

import java.util.*;

public class BOJ17140 {

    static int r, c, k;
    static int[][] a = new int[104][104];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        r--;
        c = sc.nextInt();
        c--;
        k = sc.nextInt();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }


    }
}

// 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬한다.
// 2 1 3 1 1 2




