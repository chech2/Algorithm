import java.io.*;
import java.util.*;

public class Main {
    static int n, ans , MOD;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][10];
        MOD = 1000000000;
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        for (int i = 1; i < 10; i++) {
            ans += recur(1, i);
            ans %= MOD;
        }

        System.out.println(ans);
    }

    static int recur(int cnt, int now){
        if(cnt == n)return 1;
        if(dp[cnt][now] != -1) return dp[cnt][now];

        int rot = 0;
        if(0 < now) rot += recur(cnt + 1, now - 1);
        if(now < 9) rot += recur(cnt + 1, now + 1);
        return dp[cnt][now] = rot % MOD;
    }
}