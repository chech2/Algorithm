import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, TC;
    static int memo[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TC = sc.nextInt();
        for (int t = 0; t < TC; t++) {
            N = sc.nextInt();
            memo = new int[11];
            Arrays.fill(memo, -1);
            memo[0] = 0;
            memo[1] = 1;
            memo[2] = 2;
            memo[3] = 4;
            memo[N] = dp(N);
            System.out.println(memo[N]);
        }



    }

    static int dp(int n){
        if(memo[n] == -1){
            memo[n] = dp(n - 1) + dp(n - 2) + dp(n - 3) ;
        }
        return memo[n];
    }
}