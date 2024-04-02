import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[][] map, dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(recur(0, -1));
    }

    public static int recur(int cnt, int pre){
        if(cnt == n) return 0;
        int ret = 1000000;
        for (int i = 0; i < 3; i++) {
            if(i == pre) continue;
            if(dp[cnt][i] == 0) dp[cnt][i] = recur(cnt + 1, i) + map[cnt][i];
            ret = Math.min(ret, dp[cnt][i]);
        }
        return ret;
    }
    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        map = new int[n][3];
        dp = new int[n][3];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            strToken();
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}