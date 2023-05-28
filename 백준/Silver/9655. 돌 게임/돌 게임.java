import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int N;
    static int memo[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new int[N + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        if(1 < N)
        memo[2] = 2;

        memo[N] = dp(N);
        if(memo[N] % 2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }

    static int dp(int n){
        if(n < 0) return Integer.MAX_VALUE;
        if(memo[n] == -1){
            memo[n] = Math.min(dp(n - 3), dp(n - 1)) + 1;
        }
        return memo[n];
    }
}