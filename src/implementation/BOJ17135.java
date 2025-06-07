package implementation;

import java.util.*;
import java.io.*;

public class BOJ17135 {

    static int n, m, d;
    static int[][] a = new int[18][18];
    static List<Pair> e = new ArrayList<>();
    static List<Pair> OrgE = new ArrayList<>();
    static int ret = 0;
    static int mx = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] == 1) {
                    e.add(new Pair(i, j));
                    OrgE.add(new Pair(i, j));
                }
            }
        }

        List<Integer> v = new ArrayList<>();
        combi(-1, v);

        System.out.println(mx);

    }

    // 궁수 배치
    static void combi(int start, List<Integer> b) {
        if(b.size() == 3) {
            // 적 초기화
            e = new ArrayList<>();
            for(Pair p : OrgE) {
                e.add(new Pair(p.y, p.x)); // death는 기본 false
            }

            ret = 0;

            while(true) {
                // 공격하기
                attack(b);
                // 이동하기
                move();

                // 다 죽어있는지 확인
                if(check() == true) {
                    break;
                }
            }

            mx = Math.max(mx, ret);

            return;
        }
        for(int i = start+1; i < m; i++) {
            b.add(i);
            combi(i, b);
            b.remove(b.size()-1);
        }
    }

    static boolean check() {
        for(Pair p : e) {
            if(!p.death) {
                return false;
            }
        }
        return true;
    }

    static void move() {
        for(Pair p : e) {
            if(!p.death) {
                p.y++;
                if(p.y == n) {
                    p.death = true;
                }
            }
        }
    }

    // 공격
    static void attack(List<Integer> b) {

        Pair[] targets = new Pair[3];
        // 0일떄 조심
        int[] diss = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        for(int i = 0; i < 3; i++) {
            // 궁수 위치
            int y = n;
            int x = b.get(i);

            for(Pair p : e) {

                if(p.death) {
                    continue;
                }

                // 적과의 거리
                int dis = Math.abs(y - p.y) + Math.abs(x - p.x);
                // 적을 공격할수 있다면
                if(dis <= d) {
                    // 더 가까운 적을 찾았을때
                    if(diss[i] > dis) {
                        diss[i] = dis;
                        targets[i] = p;
                    }
                    // 거리가 같은 적을 찾았을때
                    else if(diss[i] == dis) {
                        // 새로 찾은 적이 더 오른쪽에 있을때
                        if(targets[i].x > p.x) {
                            targets[i] = p;
                        }
                    }
                }
            }
        }



        for(Pair p : targets) {
            if(p == null) {
                continue;
            }
            for(Pair enemy : e) {
                if(p.y == enemy.y && p.x == enemy.x) {
                    if(!enemy.death) {
                        enemy.death = true;
                        ret++;
                        break;
                    }
                }
            }
        }
    }





    static class Pair {
        int y;
        int x;
        boolean death = false;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
