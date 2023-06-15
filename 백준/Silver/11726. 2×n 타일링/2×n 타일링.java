import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int memo[];
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new int[N + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= 3; i++) {
            if(N < i) break;
            memo[i] = i;
        }
        memo[N] = dp(N);
        System.out.println(memo[N] % 10007);
//        System.out.println(Arrays.toString(memo));
    }

    static int dp(int n){
        if(memo[n] == -1) {
            memo[n - 1] = dp(n - 1);
            memo[n - 2] = dp(n - 2);
            int num = memo[n- 1] + memo[n - 2];
            if(num > 10007) return num % 10007;
            else return num;
//            return memo[n- 1] + memo[n - 2];
        }
        return memo[n];
    }
}