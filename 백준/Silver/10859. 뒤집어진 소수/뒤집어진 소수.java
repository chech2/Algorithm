import java.util.Scanner;

public class Main {
    static long N, reverse;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();

        //입력값 소수판정하기
        check(N);

        //숫자 뒤집기
        long tmp;
        while (N > 0) {
            tmp = N % 10;
            if (tmp == 3 || tmp == 4 || tmp == 7) {
                System.out.println("no");
                System.exit(0);
            }else if(tmp == 6 || tmp == 9){
                if(tmp == 6) tmp = 9;
                else tmp = 6;
            }
            reverse = reverse * 10 + tmp;
            N /= 10;
        }

        //소수 판정
        check(reverse);

        System.out.println("yes");
    }

    static void check(long num){
        if(num == 1){
            System.out.println("no");
            System.exit(0);
        }
        for (long i = 2; i <= num / i; i++) {
            if(num % i == 0){
                System.out.println("no");
                System.exit(0);
            }
        }
    }
}