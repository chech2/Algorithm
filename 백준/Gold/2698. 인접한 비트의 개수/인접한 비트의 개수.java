import java.io.*;
import java.util.*;
public class Main {
    static int T, n, k;
    static int[][][] dp;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input();
            bw.append(recur(0, 0, 0) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int recur(int cnt, int conti, int now) {
        if(cnt == n){
            if (conti == k) return 1;
            return 0;
        }
        if(k < conti) return 0;
        if(dp[cnt][conti][now] != -1) return dp[cnt][conti][now];
        return dp[cnt][conti][now] = recur(cnt + 1, conti, 0) + recur(cnt + 1, conti + now, 1);
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
}