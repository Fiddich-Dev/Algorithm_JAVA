package ssafy;

import java.util.*;

public class SWEA25471 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            long n = sc.nextLong();

            int turn = 0; // 0이면 A, 1이면 B

            while(true) {
                long temp = check(n);
                if(temp == 0) {
                    break;
                }
                n -= temp;
                turn ^= 1;
            }

            if(turn == 0) {
                System.out.println("B");
            }
            else {
                System.out.println("A");
            }
        }
    }

    static long check(long n) {
        for(long i = n-1; i*i >= n; i--) {
            if(i == 0) {
                return 0;
            }
            if(n % i == 0) {
                return i;
            }
        }
        return 0;
    }
}

//Alice와 Bob이 자연수 변수 N을 갖고 간단한 게임을 할 것이다. 두 사람은 Alice부터 시작해서 번갈아 가면서, 2 이상 N-1 이하인 N의 약수 C를 고른 뒤, N에서 C를 뺀다.
//한 턴이 끝날 때마다 N은 적어도 2씩 감소할 것이다. 2 이상 N-1 이하인 N의 약수가 존재하지 않아서 아무것도 할 수 없는 사람이 패배한다.

