import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] passenger;
    static int[][] dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        preSetting();

        System.out.println(recur(0, 0));
    }

    static int recur(int cnt, int select){
        if(select == 3) return 0;
        if(n <= cnt) return 0;
        if(dp[cnt][select] != -1) return dp[cnt][select];

        int rot = 0;
        for(int i = 0; i < m; i++){
            if(n <= cnt + i) break;

            rot += passenger[cnt + i];
        }

        return dp[cnt][select] = Math.max(recur(cnt + m, select + 1) + rot, recur(cnt + 1, select));
    }

    static void preSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        passenger = new int[n];
        dp = new int[n][3];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            passenger[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        m = Integer.parseInt(br.readLine());
    }

}