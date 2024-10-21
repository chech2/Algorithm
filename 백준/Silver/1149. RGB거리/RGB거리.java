import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[][] map, dp;
    static final int max = 1000000;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(recur(0, 0));
    }

    static int recur(int cnt, int pre){
        if(cnt == n){
            return 0;
        }
        if(dp[cnt][pre] != 1000) return dp[cnt][pre];
        int rot = max;
        for(int i = 1; i < 4; i++) {
            if(i == pre) continue;
            rot = Math.min(rot, recur(cnt + 1, i) + map[cnt][i]);
        }
        return dp[cnt][pre] = rot;
    }

    static void input() throws Exception{
        n = Integer.parseInt(br.readLine());

        map = new int[n][4];
        dp = new int[n][4];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            Arrays.fill(dp[i], 1000);
            for(int j = 1; j < 4; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}