import java.util.*;
import java.io.*;
public class Main {
    static int n, k;
    static int[] w, v;
    static int[][] dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        test();
        System.out.println(dp[n][k]);
    }

    public static void test(){
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                // 무게 한도별 최대 가치 저장
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                // 이번 물건을 선택했을 때, 최대 무게를 초과하지 않을 경우 업데이트
                if(j + w[i] <= k) dp[i][j + w[i]] = Math.max(dp[i - 1][j + w[i]], dp[i - 1][j] + v[i]);
            }
        }
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        w = new int[n + 1];
        v = new int[n + 1];
        dp = new int[n + 1][k + 1];


        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
    }

}