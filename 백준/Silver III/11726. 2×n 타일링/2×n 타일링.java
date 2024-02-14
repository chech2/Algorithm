import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];

        System.out.println(recur(0));
    }

    //true: 세로, false: 가로
    public static int recur(int cnt){
        if(cnt == n) return 1;
        if(n < cnt) return 0;
        if(dp[cnt] != 0) return dp[cnt];

        //세로로 놨을 때
        return dp[cnt] = (recur(cnt + 1) + recur(cnt + 2)) % 10007;
    }
}