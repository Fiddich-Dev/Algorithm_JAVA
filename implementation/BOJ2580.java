package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pair {
    int y;
    int x;
    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ2580 {

    static int[][] a = new int[10][10];
    static List<Pair> arr = new ArrayList<>();

    static int[][] ret = new int[10][10];

    // 가로
    static boolean check1(int y, int x) {
        int[] visited = new int[10];
        for(int i = 0; i < 9; i++) {
            if(a[y][i] == 0) {
                continue;
            }
            else {
                if(visited[a[y][i]] != 0) {
                    return false;
                }
                visited[a[y][i]] = 1;
            }
        }
        return true;
    }

    // 세로
    static boolean check2(int y, int x) {
        int[] visited = new int[10];
        for(int i = 0; i < 9; i++) {
            if(a[i][x] == 0) {
                continue;
            }
            else {
                if(visited[a[i][x]] != 0) {
                    return false;
                }
                visited[a[i][x]] = 1;
            }
        }
        return true;
    }

    // 굵은선
    static boolean check3(int y, int x) {
        int[] visited = new int[10];
        Pair start = new Pair(y/3 * 3, x/3 * 3);

        for(int i = start.y; i < start.y+3; i++) {
            for(int j = start.x; j < start.x+3; j++) {
                if(a[i][j] == 0) {
                    continue;
                }
                else {
                    if(visited[a[i][j]] != 0) {
                        return false;
                    }
                    visited[a[i][j]] = 1;
                }
            }
        }
        return true;
    }

    static void go(int nowIdx) {

        if(nowIdx == arr.size()) {

            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    ret[i][j] = a[i][j];
                }
            }

            return;
        }

        Pair now = arr.get(nowIdx);

        for(int i = 1; i <= 9; i++) {
            a[now.y][now.x] = i;
            if(check1(now.y, now.x) == true && check2(now.y, now.x) == true && check3(now.y, now.x) == true) {
                go(nowIdx + 1);
            }
            a[now.y][now.x] = 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                a[i][j] = sc.nextInt();

                if(a[i][j] == 0) {
                    arr.add(new Pair(i, j));
                }
            }
        }

        go(0);

        System.out.println();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// arr를 돌면서 1~9까지 넣으면서 check1, check2, check3을 한다
// 다 true이면 다음 arr로 가서 1~9까지 넣어본다
// 도중에 되는게 없으면 백트래킹 