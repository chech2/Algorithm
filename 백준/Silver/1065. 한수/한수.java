import java.util.Scanner;

public class Main {
    static int N, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if(N < 100) result = N;
        if (N > 99) {
            result = 99;
            for (int i = 100; i <= N; i++) {
                result += oneNum(i);
            }
        }
        System.out.println(result);
    }
    private static int oneNum (int num){
        int dist = num < 10 ? 1 : num < 100 ? 2 : num < 1000 ? 3 : 4;

        int d = (num / 10) % 10 -  num % 10;
        for (int i = 0; i < dist - 1; i++) {
            if((num / 10) % 10 -  num % 10 != d) return 0;
            num /= 10;
        }
        return 1;
    }
}

// 2의 자리까지는 => 100이하는 무조건 카운트
// 100 101 102 103 104 105 106 107 108 109 110