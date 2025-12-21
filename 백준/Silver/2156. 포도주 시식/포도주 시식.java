import java.io.*;
import java.util.*;

public class Main {

    static int n, ans;
    static int[] wine;
    static int[][] dp;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        wine = new int[n];
        dp = new int[n][3];

        for(int i = 0; i < n; i++){
            wine[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0, 0));
    }

    public static int recur(int cnt, int seq){
        if(cnt == n)return 0 ;
        if(dp[cnt][seq] != -1) return dp[cnt][seq];

        if(seq < 2){
            dp[cnt][seq] = Math.max(recur(cnt + 1, seq + 1) + wine[cnt], dp[cnt][seq]);
        }
        return  dp[cnt][seq] = Math.max(recur(cnt + 1, 0), dp[cnt][seq]);
    }
}
