package week3;

import java.util.*;

class Pair {
    int y, x;
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
    @Override
    public String toString() {
        return "(" + y + ", " + x + ")";
    }
}

public class Main {

    static int n = 2; // 고를 좌표 개수
    // static int h = 3, w = 3; // 격자 크기
    static int cnt = 0;

    static void go(int y, int x, List<Pair> b) {
        if (b.size() == n) {
            cnt++;
            System.out.println(b);
            return;
        }

        if (y == n) return;

        int nx = x + 1 == n ? 0 : x + 1;
        int ny = x + 1 == n ? y + 1 : y;

        // 1. 현재 좌표 선택
        b.add(new Pair(y, x));
        go(ny, nx, b);
        b.remove(b.size() - 1);

        // 2. 현재 좌표 선택 안 함
        go(ny, nx, b);
    }

    public static void main(String[] args) {
        List<Pair> selected = new ArrayList<>();
        go(0, 0, selected);
        System.out.println("총 조합 수: " + cnt);
    }
}

