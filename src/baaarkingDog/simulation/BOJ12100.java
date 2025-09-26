package baaarkingDog.simulation;

import java.util.*;

public class BOJ12100 {

    static int n;
    static int[][] a;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        go(0);

        System.out.println(ret);

    }

    static void go(int cnt) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ret = Math.max(ret, a[i][j]);
            }
        }

        if(cnt == 5) {
            return;
        }

        for(int i = 0; i < 4; i++) {
            int[][] temp = new int[n][n];
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    temp[j][k] = a[j][k];
                }
            }

            roll(i);

            go(cnt+1);

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    a[j][k] = temp[j][k];
                }
            }

        }
    }

    static void roll(int dir) {

        if(dir == 0) {
            for(int i = 0; i < n; i++) {
                List<Integer> arr = new ArrayList<>();
                int[] temp = new int[n];

                for(int j = 0; j < n; j++) {
                    if(a[j][i] != 0) {
                        arr.add(a[j][i]);
                    }
                }

                int now = 0;
                for(int j : arr) {
                    if(temp[now] == 0) {
                        temp[now] += j;
                    }
                    else {
                        // 합칠 수 있으면
                        if(temp[now] == j) {
                            temp[now] += j;
                            now++;
                        }
                        else {
                            now++;
                            temp[now] += j;
                        }
                    }
                }

                for(int j = 0; j < n; j++) {
                    a[j][i] = temp[j];
                }
            }
        }

        else if(dir == 2) {
            for(int i = 0; i < n; i++) {
                List<Integer> arr = new ArrayList<>();
                int[] temp = new int[n];

                for(int j = n-1; j >= 0; j--) {
                    if(a[j][i] != 0) {
                        arr.add(a[j][i]);
                    }
                }

                int now = n-1;
                for(int j : arr) {
                    if(temp[now] == 0) {
                        temp[now] += j;
                    }
                    else {
                        // 합칠 수 있으면
                        if(temp[now] == j) {
                            temp[now] += j;
                            now--;
                        }
                        else {
                            now--;
                            temp[now] += j;
                        }
                    }
                }

                for(int j = n-1; j >= 0; j--) {
                    a[j][i] = temp[j];
                }
            }
        }

        else if(dir == 3) {
            for(int i = 0; i < n; i++) {
                List<Integer> arr = new ArrayList<>();
                int[] temp = new int[n];

                for(int j = 0; j < n; j++) {
                    if(a[i][j] != 0) {
                        arr.add(a[i][j]);
                    }
                }

                int now = 0;
                for(int j : arr) {
                    if(temp[now] == 0) {
                        temp[now] += j;
                    }
                    else {
                        // 합칠 수 있으면
                        if(temp[now] == j) {
                            temp[now] += j;
                            now++;
                        }
                        else {
                            now++;
                            temp[now] += j;
                        }
                    }
                }

                for(int j = 0; j < n; j++) {
                    a[i][j] = temp[j];
                }
            }
        }

        else if(dir == 1) {
            for(int i = 0; i < n; i++) {
                List<Integer> arr = new ArrayList<>();
                int[] temp = new int[n];

                for(int j = n-1; j >= 0; j--) {
                    if(a[i][j] != 0) {
                        arr.add(a[i][j]);
                    }
                }

                int now = n-1;
                for(int j : arr) {
                    if(temp[now] == 0) {
                        temp[now] += j;
                    }
                    else {
                        // 합칠 수 있으면
                        if(temp[now] == j) {
                            temp[now] += j;
                            now--;
                        }
                        else {
                            now--;
                            temp[now] += j;
                        }
                    }
                }

                for(int j = n-1; j >= 0; j--) {
                    a[i][j] = temp[j];
                }
            }
        }
    }
}
