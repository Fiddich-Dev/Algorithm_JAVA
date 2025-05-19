package week3;

public class BitMasking {
    public static void main(String[] args) {
        int num = 4;
        // 비트 켜기
        num |= (1 << 1);
        System.out.println(num);

        // 비트 끄기
        num &= ~(1 << 1);
        System.out.println(num);

        // 비트 켜져있는지 확인
        if((num & (1 << 2)) != 0) {
            System.out.println("2번쨰 비트 켜져있음");
        }
        if((num & (1 << 1)) != 0) {
            System.out.println("1번쨰 비트 켜져있음");
        }

        // XOR
        System.out.println(num ^ 1);
        System.out.println(num ^ 2);
        System.out.println(num ^ 4);

        
        // 보수
        // ~num + 1 = -num

        // 토글
        System.out.println(num ^ (1 << 1));
        System.out.println(num ^ (1 << 2));
    }
}
