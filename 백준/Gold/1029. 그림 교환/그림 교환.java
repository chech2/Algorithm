import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] prices;
    static int[][][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        bw.append(String.valueOf(buy(0, 0, 1) + 1));
        bw.close();
    }
    static int buy(int seller, int buy_price, int visited){
        if(dp[visited][seller][buy_price] != -1) return dp[visited][seller][buy_price];

        int rot = 0;
        for(int i = 0; i < n; i++){
            if(0 < (visited & (1 << i))) continue;
            if(buy_price <= prices[seller][i]) rot = Math.max(buy(i, prices[seller][i], visited | (1 << i)) + 1, rot);
        }
//        return rot;
        return dp[visited][seller][buy_price] = rot;
    }

    static void pre_setting() throws Exception{
        n = Integer.parseInt(br.readLine());
        prices = new int[n][n];
        dp = new int[1 << n][n][10];

        String[] tmp;
        for (int i = 0; i < n; i++){
            tmp = br.readLine().split("");

            for(int j = 0; j < n; j++) prices[i][j] = Integer.parseInt(tmp[j]);
        }

        for(int i = 0; i < (1 << n); i++){
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
}