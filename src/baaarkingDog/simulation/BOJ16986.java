package baaarkingDog.simulation;

import java.util.*;

public class BOJ16986 {

    static int n, k;
    static int[][] a;
    static int[][] friend = new int[3][20];
    static int[] visited;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n][n];
        visited = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i < 3; i++) {
            for(int j = 0; j < 20; j++) {
                friend[i][j] = sc.nextInt() - 1;
            }
        }

        List<Integer> v = new ArrayList<>();
        perm(v);

        System.out.println(ret);
    }


    static void perm(List<Integer> b) {
        if(b.size() == n) {
            for(int i = 0; i < n; i++) {
                friend[0][i] = b.get(i);
//                System.out.print(friend[0][i] + " ");
            }

            int[] friendIdx = new int[3];

            int p1 = 0;
            int p2 = 1;
            int[] cnt = new int[3];

            while(true) {

                if(friendIdx[p1] >= limit(p1) || friendIdx[p2] >= limit(p2)) {
                    break;
                }

                int p1Ret = friend[p1][friendIdx[p1]++]; // p1이 내는거
                int p2Ret = friend[p2][friendIdx[p2]++];
                int next = 3 - p1 - p2;
                int winner = -1;

                // 이건거 새야함
                if(a[p1Ret][p2Ret] == 2) { // p1이 이김
                    winner = p1;
                    p2 = next;
                }
                else if(a[p1Ret][p2Ret] == 1) { // p2가 이김
                    if(p1 > p2) {
                        winner = p1;
                    }
                    else {
                        winner = p2;
                    }
                    p1 = winner;
                    p2 = next;
                }
                else if(a[p1Ret][p2Ret] == 0) { // p2가 이김
                    winner = p2;
                    p1 = p2;
                    p2 = next;
                }

                cnt[winner]++;

                if(cnt[winner] == k) {
                    if(winner == 0) {
                        ret = 1;
                    }
                    break;
                }
            }




            return;
        }
        for(int i = 0; i < n; i++) {
            if(visited[i] == 1) {
                continue;
            }
            b.add(i);
            visited[i] = 1;

            perm(b);

            visited[i] = 0;
            b.remove(b.size() - 1);
        }
    }

    static int limit(int player) {
        if(player == 0) {
            return n;
        }
        return 20;
    }
}

// 2: 이김, 1: 비김, 0: 짐
