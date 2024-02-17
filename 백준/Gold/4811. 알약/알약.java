import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static long[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{

        while(true){
            input();
            if(n == 0) break;
            sb.append(recur(n, 0, "")).append("\n");
        }
        System.out.println(sb);
    }
    public static long recur(int all, int half, String str){
        if(all < 0 || half < 0) return 0;
        if(all == 0 && half == 0){
            if(!set.contains(str)) {
                set.add(str);
                return 1;
            }
            return 0;
        }
        if(dp[all][half] != -1) return dp[all][half];

        //알약을 쪼갠 경우
        return dp[all][half] = recur(all - 1, half + 1, str + "w") + recur(all, half - 1, str + "s");
    }
    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        dp = new long[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        set = new HashSet<>();
        ans = 0;
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}