import java.io.*;
import java.util.*;

public class Main {
    static int n, answer;
    static int[] numbers;
    static int[][] dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        preSetting();
        for(int i = 1; i < n; i++){
            dp[0][i] = Math.max(dp[0][i - 1] + numbers[i], numbers[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + numbers[i]);
            
            answer = Math.max(answer, Math.max(dp[0][i], dp[1][i]));
        }

        System.out.println(answer);
    }

    private static void preSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        dp = new int[3][n + 1];
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = numbers[0];
        dp[1][0] = numbers[0];
        answer = numbers[0];
    }
}
