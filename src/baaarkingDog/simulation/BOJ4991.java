package baaarkingDog.simulation;

import java.util.*;

public class BOJ4991 {

    static int n, m;
    static char[][] a;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Pair> pos;
    static List<Pair> dirty;
    static int[][] visited;
    static int[][] dp;
    static int ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            ret = Integer.MAX_VALUE;
            dirty = new ArrayList<>();
            pos = new ArrayList<>();
            m = sc.nextInt();
            n = sc.nextInt();
            if(n == 0 && m == 0) {
                break;
            }

            a = new char[n][m];
            for(int i = 0; i < n; i++) {
                String temp = sc.next();
                for(int j = 0; j < m; j++) {
                    a[i][j] = temp.charAt(j);
                    if(a[i][j] == 'o') {
                        pos.add(new Pair(i, j));
                    }
                    else if(a[i][j] == '*') {
                        dirty.add(new Pair(i, j));
                    }
                }
            }

            pos.addAll(dirty);

            dp = new int[pos.size()][pos.size()];

            for(int i = 0; i < pos.size(); i++) {
                Pair p = pos.get(i);
                visited = new int[n][m];
                bfs(p.y, p.x);
                for(int j = 0; j < pos.size(); j++) {
                    Pair temp = pos.get(j);
                    int y = temp.y;
                    int x = temp.x;
                    dp[i][j] = visited[y][x] - 1;
                }
            }

            int[] order = new int[pos.size()];
            for(int i = 0; i < pos.size(); i++) {
                order[i] = i;
            }

            temp = new int[pos.size()];
            List<Integer> v = new ArrayList<>();
            v.add(0);
            perm(v);

//            permutation(1, pos.size(), pos.size(), order);

            if(ret == Integer.MAX_VALUE) {
                System.out.println(-1);
            }
            else {
                System.out.println(ret);
            }
        }
    }

    static int[] temp;
    static void perm(List<Integer> b) {
        if(b.size() == pos.size()) {
            int temp = 0;
            for(int i = 0; i < b.size()-1; i++) {
                int from = b.get(i);
                int to = b.get(i+1);
                if(dp[from][to] == -1) {
                    return;
                }
                temp += dp[from][to];
            }
            ret = Math.min(ret, temp);
            return;
        }
        for(int i = 1; i < pos.size(); i++) {
            if(temp[i] == 1) {
                continue;
            }
            b.add(i);
            temp[i] = 1;

            perm(b);

            temp[i] = 0;
            b.remove(b.size() - 1);
        }
    }

//    static void permutation(int depth, int n, int r, int[] order) {
//        if(depth == r) {
//            int temp = 0;
//            for(int i = 0; i < order.length-1; i++) {
//                int from = order[i];
//                int to = order[i+1];
//                if(dp[from][to] == -1) {
//                    return;
//                }
//                temp += dp[from][to];
//            }
//            ret = Math.min(ret, temp);
//            return;
//        }
//        for(int i = depth; i < n; i++) {
//            swap(depth, i, order);
//            permutation(depth+1, n, r, order);
//            swap(depth, i, order);
//        }
//    }
//
//    static void swap(int depth, int i, int[] order) {
//        int temp = order[i];
//        order[i] = order[depth];
//        order[depth] = temp;
//    }

    static void bfs(int y, int x) {
        visited[y][x] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            for(int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] == 0 && a[ny][nx] != 'x') {
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[p.y][p.x] + 1;
                }
            }
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
