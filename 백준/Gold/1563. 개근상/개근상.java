import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][][] dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(recur(0, 0, 0));
    }

    public static int recur(int day, int l, int a){
        if(2 <= l || 3 <= a) return 0;
        if(day == n) return 1;
        if(dp[day][l][a] != -1) return dp[day][l][a];


        return dp[day][l][a] = (recur(day + 1,  l, 0) + recur(day + 1, l, a + 1) + recur(day + 1, l + 1, 0)) % 1000000; // 지각
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}