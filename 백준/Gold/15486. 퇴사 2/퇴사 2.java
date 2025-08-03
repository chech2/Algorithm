import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] days, money, dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        System.out.println(buttounUp());
    }

    static int buttounUp() {
        dp[n] = 0;

        for(int i = n - 1; 0 <= i; i--){
            dp[i] = Math.max(dp[i + 1], dp[i + days[i]] + money[i]);
        }
        return dp[0];
    }

    static void inputSetting() throws Exception{
        n = Integer.parseInt(br.readLine());

        days = new int[n];
        money = new int[n];
        dp = new int[n + 50];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer (br.readLine());

            days[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -10000);
    }
}