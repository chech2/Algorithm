import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 4){
            dp = new long[4];

        }else {
            dp = new long[n + 1];
        }
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;


        System.out.println(fdp(n));
    }

    static long fdp(int n){
        if(dp[n] == -1){
            if(n % 6 == 0){
                dp[n] = Math.min(fdp(n / 2), fdp(n / 3)) + 1;
            }else if(n % 2 == 0){
                dp[n] = Math.min(fdp(n / 2), fdp(n -1 )) + 1;
            }else if(n % 3 == 0){
                dp[n] = Math.min(fdp(n / 3), fdp(n -1 )) + 1;
            }else{
                dp[n] = fdp(n - 1) + 1;
            }
        }
        return dp[n];
    }

}