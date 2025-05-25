package week7;

import java.util.*;



public class BOJ17837 {

    static class Pair {
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n, k;
    // 맵
    static int[][] a = new int[14][14];
    // 말의 위치
    static Pair[] loca = new Pair[14];
    // 말의 방향
    static int[] flag = new int[14];
    // 쌓인 순서
    static ArrayList<Integer>[][] horse = new ArrayList[14][14];

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    

    static int ret = 0;

    // true면 종료
    static boolean check(int y, int x) {
        if(horse[y][x].size() >= 4) {
            return true;
        }
        return false;
    }

    // true면 종료
    static boolean checkAll() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(horse[i][j].size() >= 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                horse[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < k; i++) {
            int tempY = sc.nextInt() - 1;
            int tempX = sc.nextInt() - 1;
            loca[i] = new Pair(tempY, tempX);
            horse[tempY][tempX].add(i);
            flag[i] = sc.nextInt() - 1;
        }

        while(true) {
            ret++;
            for(int i = 0; i < k; i++) {
                int y = loca[i].y;
                int x = loca[i].x;
                int ny = y + dy[flag[i]];
                int nx = x + dx[flag[i]];

                // 옮길 말
                int s = horse[y][x].indexOf(i);
                ArrayList<Integer> temp = new ArrayList<>(horse[y][x].subList(s, horse[y][x].size()));
                // horse[y][x] = new ArrayList<>(horse[y][x].subList(0, s));

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                else if(a[ny][nx] == 0) {
                    // 말 제거
                    horse[y][x] = new ArrayList<>(horse[y][x].subList(0, s));

                    for(int j = 0; j < temp.size(); j++) {
                        // 말 추가
                        horse[ny][nx].add(temp.get(j));
                        
                        // 말 위치 갱신
                        loca[temp.get(j)].y = ny;
                        loca[temp.get(j)].x = nx;

                    }
                    
                }
                else if(a[ny][nx] == 1) {

                    Collections.reverse(temp);

                    // 말 제거
                    horse[y][x] = new ArrayList<>(horse[y][x].subList(0, s));

                    for(int j = 0; j < temp.size(); j++) {
                        // 말 추가
                        horse[ny][nx].add(temp.get(j));
                        
                        // 말 위치 갱신
                        loca[temp.get(j)].y = ny;
                        loca[temp.get(j)].x = nx;

                    }

                }
                else {
                    if(flag[i] % 2 == 0) {
                        flag[i] += 1;
                    }
                    else {
                        flag[i] -= 1;
                    }

                    ny = y + dy[flag[i]];
                    nx = x + dx[flag[i]];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2) {
                        continue;
                    }

                    // 말 제거
                    horse[y][x] = new ArrayList<>(horse[y][x].subList(0, s));

                    for(int j = 0; j < temp.size(); j++) {
                        // 말 추가
                        horse[ny][nx].add(temp.get(j));
                        
                        // 말 위치 갱신
                        loca[temp.get(j)].y = ny;
                        loca[temp.get(j)].x = nx;

                    }

                }

                

                if(check(ny, nx) == true) {
                    System.out.println(ret);
                    return;
                }
            }

            if(ret > 1000) {
                System.out.println(-1);
                return;
            }

        }
    }
}
// 오버플로우