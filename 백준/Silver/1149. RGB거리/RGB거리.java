import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] house, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        house = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0,  -1);
        System.out.println(Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2])));
    }

    public static int recur(int cnt, int pre){
        if(cnt == n) return 0;
        int ret = isSave(cnt, pre);
        if(ret != -1) return ret;

        ret = 100000000;
        for (int i = 0; i < 3; i++) {
            if(i == pre) continue;
            dp[cnt][i] = recur(cnt + 1, i) + house[cnt][i];
            ret = Math.min(ret, dp[cnt][i]);
        }
        return ret;
    }

    public static int isSave(int cnt, int pre){
        if(pre == 0){
            if(dp[cnt][1] != -1 && dp[cnt][2] != -1) {
                return Math.min(dp[cnt][1], dp[cnt][2]);
            }
        }else if(pre == 1){
            if(dp[cnt][0] != -1 && dp[cnt][2] != -1) {
                return Math.min(dp[cnt][0], dp[cnt][2]);
            }

        }else if(pre == 2){
            if(dp[cnt][0] != -1 && dp[cnt][1] != -1) {
                return Math.min(dp[cnt][0], dp[cnt][1]);
            }
        }
        return -1;
    }
}