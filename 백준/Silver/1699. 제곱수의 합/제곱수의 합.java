import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] dp;
    static List<Integer> number;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        preSetting();

        System.out.println( recur(number.size() - 1, n));
    }

    static int recur(int cnt, int total){
        if(cnt < 0){
            if(total == 0) return 0;
            return 100001;
        }
        if(dp[cnt][total] != -1) return dp[cnt][total];
        int now = number.get(cnt);
        int nowTerm = (total / now);

        // 이번꺼 스킵
        return dp[cnt][total] = Math.min(recur(cnt - 1, total), recur(cnt - 1, total - nowTerm * now) + nowTerm);
    }

    static void preSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        number = new ArrayList();
        for(int i = 1; i <= n / i; i++) number.add(i * i);

        dp = new int[number.size()][n + 1];
        for(int i = 0; i < number.size(); i++) Arrays.fill(dp[i], -1);
    }
}