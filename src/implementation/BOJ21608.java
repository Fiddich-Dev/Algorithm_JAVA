package implementation;

import java.util.*;
import java.io.*;

public class BOJ21608 {

    static int n;
    static int[][] a = new int[24][24];
    static List<Integer>[] b = new ArrayList[408];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n*n; i++) {
            st = new StringTokenizer(br.readLine());
            // 1부터 n*n까지
            int student = Integer.parseInt(st.nextToken());
            b[student] = new ArrayList<>();
            // 좋아하는 친구
            int[] friends = new int[4];
            friends[0] = Integer.parseInt(st.nextToken());
            b[student].add(friends[0]);
            friends[1] = Integer.parseInt(st.nextToken());
            b[student].add(friends[1]);
            friends[2] = Integer.parseInt(st.nextToken());
            b[student].add(friends[2]);
            friends[3] = Integer.parseInt(st.nextToken());
            b[student].add(friends[3]);

            solve(student, friends);
        }

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(calc());
    }

    static int calc() {

        int sum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int cnt = 0;
                int student = a[i][j];
                int y = i;
                int x = j;
                for(int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    if(a[ny][nx] == b[student].get(0) || a[ny][nx] == b[student].get(1) || a[ny][nx] == b[student].get(2) || a[ny][nx] == b[student].get(3)) {
                        cnt++;
                    }
                }
                if(cnt == 1) {
                    sum += 1;
                }
                else if(cnt == 2) {
                    sum += 10;
                }
                else if(cnt == 3) {
                    sum += 100;
                }
                else if(cnt == 4) {
                    sum += 1000;
                }
            }
        }
        return sum;
    }

    static void solve(int student, int[] friends) {

        List<Status> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(a[i][j] != 0) {
                    continue;
                }

                int y = i;
                int x = j;

                Status status = new Status(y, x, 0, 0);

                for(int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    if(a[ny][nx] == 0) {
                        status.blank++;
                    }
                    if(a[ny][nx] == friends[0] || a[ny][nx] == friends[1] || a[ny][nx] == friends[2] || a[ny][nx] == friends[3]) {
                        status.friends++;
                    }
                }

                arr.add(status);

            }
        }

        arr.sort((s1, s2) -> {
            if(s1.friends == s2.friends) {
                if(s1.blank == s2.blank) {
                    if(s1.y == s2.y) {
                        return s1.x - s2.x;
                    }
                    return s1.y - s2.y;
                }
                return s2.blank - s1.blank;
            }
            return s2.friends - s1.friends;
        });

        Status status = arr.get(0);
        a[status.y][status.x] = student;
    }


    static class Status {
        int y;
        int x;
        int friends;
        int blank;

        public Status(int y, int x, int friends, int blank) {
            this.y = y;
            this.x = x;
            this.friends = friends;
            this.blank = blank;
        }
    }
}

