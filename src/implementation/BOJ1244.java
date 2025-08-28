package implementation;

import java.util.*;

public class BOJ1244 {

    static int n;
    static int[] s = new int[104];
    static int m;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
        }
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int g = sc.nextInt();
            int num = sc.nextInt();
            solve(g, num);
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(s[i] + " ");
            if(i % 20 == 0) {
                System.out.println();
            }
        }
    }

    static void solve(int g, int num) {
        if(g == 1) {
            for(int i = num; i <= n; i += num) {
                s[i] ^= 1;
            }
        }
        else if(g == 2) {
            List<Integer> arr = new ArrayList<>();
            arr.add(num);
            for(int i = 1; i <= n; i++) {
                int l = num - i;
                int r = num + i;
                if(r > n || l < 1) {
                    break;
                }

                if(s[l] == s[r]) {
                    arr.add(l);
                    arr.add(r);
                }
                else {
                    break;
                }
            }

            for(int i : arr) {
                s[i] ^= 1;
            }
        }
    }
}
// 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다
// 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.
