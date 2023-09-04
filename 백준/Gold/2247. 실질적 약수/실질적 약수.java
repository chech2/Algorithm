import java.util.Scanner;

public class Main {
    static int N;
    static long result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 2; i <= N / 2; i++) {
            result += (N/i - 1) * i;
        }
        System.out.println(result % 1000000);
    }
}