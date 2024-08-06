import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n, ans;
    static int[] grape;
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(recur(0, 0));
    }

    public static int recur(int cnt, int seleted){
        if(cnt == n){
            return 0 ;
        }
        if(dp[cnt][seleted] != -1) return dp[cnt][seleted];
        dp[cnt][seleted]= recur(cnt + 1, 0);
        if(seleted < 2) dp[cnt][seleted] = Math.max(dp[cnt][seleted], recur(cnt + 1, seleted + 1) + grape[cnt]);
        return dp[cnt][seleted];
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        grape = new int[n];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            grape[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], -1);
        }
    }
}