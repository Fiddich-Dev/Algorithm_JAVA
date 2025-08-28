package implementation;

import java.util.*;
import java.io.*;

public class BOJ21608 {

    static int n;
    // 1 ~ n*n
    static int[][] a = new int[404][4];
    static int[][] map = new int[24][24];
    // 0 ~ n*n-1
    static int[] student = new int[404];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n*n; i++) {
            int num = sc.nextInt();
            student[i] = num;
            for(int j = 0; j < 4; j++) {
                a[num][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n*n; i++) {

            int nowStudent = student[i];
            List<Status> arr = new ArrayList<>();

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {

                    if(map[j][k] != 0) {
                        continue;
                    }

                    int empty = 0;
                    int like = 0;

                    int y = j;
                    int x = k;

                    for(int q = 0; q < 4; q++) {
                        int ny = y + dy[q];
                        int nx = x + dx[q];

                        if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                            continue;
                        }
                        if(map[ny][nx] == 0) {
                            empty++;
                        }
                        else if(map[ny][nx] == a[nowStudent][0] || map[ny][nx] == a[nowStudent][1] || map[ny][nx] == a[nowStudent][2] || map[ny][nx] == a[nowStudent][3]) {
                            like++;
                        }
                    }

                    arr.add(new Status(like, empty, y, x));
                }
            }

            arr.sort((s1, s2) -> {
                if(s1.like == s2.like) {
                    if(s1.empty == s2.empty) {
                        if(s1.y == s2.y) {
                            return s1.x - s2.x;
                        }
                        return s1.y - s2.y;
                    }
                    return s2.empty - s1.empty;
                }
                return s2.like - s1.like;
            });

            map[arr.get(0).y][arr.get(0).x] = nowStudent;

        }

        int ret = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                int y = i;
                int x = j;

                int nowStudent = map[y][x];

                int like = 0;

                for(int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }

                    else if(map[ny][nx] == a[nowStudent][0] || map[ny][nx] == a[nowStudent][1] || map[ny][nx] == a[nowStudent][2] || map[ny][nx] == a[nowStudent][3]) {
                        like++;
                    }
                }

//                System.out.println(like);

                if(like == 1) {
                    ret += 1;
                }
                else if(like == 2) {
                    ret += 10;
                }
                else if(like == 3) {
                    ret += 100;
                }
                else if(like == 4) {
                    ret += 1000;
                }

            }
        }

        System.out.println(ret);
    }

    static class Status {
        int like;
        int empty;
        int y;
        int x;

        public Status(int like, int empty, int y, int x) {
            this.like = like;
            this.empty = empty;
            this.y = y;
            this.x = x;
        }
    }
}

// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
// 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
// 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.

