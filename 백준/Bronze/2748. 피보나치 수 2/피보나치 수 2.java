import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static long memo[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new long[N + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        if(0 < N)
        memo[1] = 1;

        memo[N] = fibo(N);
        System.out.println(memo[N]);
    }

    static long fibo(int n){
        if(memo[n] == -1){
            memo[n] = fibo(n - 1) + fibo(n - 2);
        }
        return memo[n];
    }
}