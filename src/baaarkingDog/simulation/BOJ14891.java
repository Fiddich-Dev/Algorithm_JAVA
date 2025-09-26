package baaarkingDog.simulation;

import java.util.*;

public class BOJ14891 {

    static int[][] a = new int[4][8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 4; i++) {
            String s = sc.next();
            for(int j = 0; j < 8; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            int num = sc.nextInt() - 1;
            int dir = sc.nextInt();

            int[] roll = new int[4];
            roll[num] = 1;
            for(int j = num+1; j < 4; j++) {
                if(a[j-1][2] != a[j][6]) {
                    roll[j] = 1;
                }
                else {
                    break;
                }
            }
            for(int j = num-1; j >= 0; j--) {
                if(a[j+1][6] != a[j][2]) {
                    roll[j] = 1;
                }
                else {
                    break;
                }
            }

            for(int j = 0; j < 4; j++) {
                if(roll[j] == 1) {
                    int dis = Math.abs(num - j);
                    if(dis % 2 == 0) {
                        roll(j, dir);
                    }
                    else {
                        roll(j, dir * -1);
                    }
                }
            }
        }

        int ret = 0;
        for(int i = 0; i < 4; i++) {
            if(a[i][0] == 1) {
                ret += (1 << i);
            }
        }

        System.out.println(ret);
    }

    static void roll(int num, int dir) {
        if(dir == 1) {
            int temp = a[num][7];
            for(int i = 7; i >= 1; i--) {
                a[num][i] = a[num][i-1];
            }
            a[num][0] = temp;
        }

        else if(dir == -1) {
            int temp = a[num][0];
            for(int i = 0; i < 7; i++) {
                a[num][i] = a[num][i+1];
            }
            a[num][7] = temp;
        }
    }
}

// 다르면 반대 방향으로 회전
// 같으면 회전 안함
