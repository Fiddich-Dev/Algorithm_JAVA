package baaarkingDog.deque;

import java.util.*;
import java.io.*;

public class BOJ5430 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 0; q < t; q++) {
            String s = sc.next();
            int n = sc.nextInt();
            String numbers = sc.next();
            numbers = numbers.substring(1, numbers.length()-1);

            String[] nums = numbers.split(",");

            int flag = 0; // 0은 정방향, 1은 역방향
            Deque<Integer> dq = new ArrayDeque<>();

            if(!nums[0].isEmpty()) {
                for(String now : nums) {
                    int num = Integer.parseInt(now);
                    dq.addLast(num);
                }
            }



            StringBuilder sb = new StringBuilder();
            sb.append("[");

            boolean isError = false;

            for(char c : s.toCharArray()) {
                if(c == 'R') {
                    flag ^= 1;
                }
                else if(c == 'D') {
                    if(dq.isEmpty()) {
                        break;
                    }

                    if(flag == 0) {
                        if(!dq.isEmpty()) {
                            dq.pollFirst();
                        }

                    }
                    else if(flag == 1) {
                        if(!dq.isEmpty()) {
                            dq.pollLast();
                        }
                    }
                }
            }

            if(dq.isEmpty()) {
                System.out.println("error");
                continue;
            }

            if(flag == 0) {
                while(!dq.isEmpty()) {
                    sb.append(dq.pollFirst()).append(",");
                }
            }
            else if(flag == 1) {
                while(!dq.isEmpty()) {
                    sb.append(dq.pollFirst()).append(",");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]");


            System.out.println(sb);
        }
    }
}
