import java.util.*;
import java.io.*;
public class Main {
    static int n, k;
    static int[] coins;
    static int[][] dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        pre_setting();
        System.out.println(recur(0, 0));
    }


    static int recur(int now, int sum){
        if(k == sum) return 1;
        if(k < sum || n <= now) return 0;
        if(dp[now][sum] != -1) return dp[now][sum];

        int rot = 0;
        for(int i = 0;  sum + (i * coins[now]) <= k; i++){
            rot += recur(now + 1, sum +  coins[now] * i);
        }
        return dp[now][sum] = rot;
    }

    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n][k + 1];
        coins = new int[n];

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], -1);
        }
    }
}