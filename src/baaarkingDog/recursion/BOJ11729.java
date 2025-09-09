package baaarkingDog.recursion;

import java.util.*;

public class BOJ11729 {

    static int n;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        go(n, 1, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void go(int num, int from, int goal) {

        if(num == 1) {
            sb.append(from).append(" ").append(goal).append("\n");
            cnt++;
            return;
        }

        go(num-1, from, 6-from-goal);
        sb.append(from).append(" ").append(goal).append("\n");
        cnt++;
        go(num-1, 6-from-goal, goal);
    }
}

// n번 원판을 기둥3으로 옮기려면
// 1. n-1까지 원판은 기둥2로 옮긴다
// 2. n번 원판을 기둥3으로 옮긴다
// 3. n-1까지 원판을 기둥3으로 옮긴다

