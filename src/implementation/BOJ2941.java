package implementation;

import java.util.*;

public class BOJ2941 {
    static String s = "";
    static int[] visited = new int[104];
    static String[] a = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    static int ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        // i는 start
        for(int i = 0; i < s.length(); i++) {
            if(visited[i] == 1) {
                continue;
            }

            for(int j = 0; j < 8; j++) {
                int l = a[j].length();
                // 오버플로우 검사
                if(i+l <= s.length() && s.substring(i, i+l).equals(a[j])) {
                    ret++;
                    // 방문처리
                    for(int k = i; k < i+l; k++) {
                        visited[k] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(visited[i] == 0) {
                ret++;
            }
        }

        System.out.println(ret);
    }
}


