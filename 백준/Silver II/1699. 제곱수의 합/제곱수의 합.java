import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int n, ans;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        dp = new int[n];
        setting(n);

        Arrays.fill(dp, -1);

        System.out.println(recur(0));
    }

    public static int recur(int num){
        int result = 200000;
        if(n < num) return 200000;
        if(num == n) return 0;
        if(dp[num] != -1) return dp[num];

        for (int i = 0; i < list.size(); i++) {
            result = Math.min(recur(num + list.get(i)) + 1, result);
        }
        return dp[num] = result;
    }

    public static void setting(int n){
        list.add(1);

        for (int i = 2; i <= n / i; i++) {
            list.add(i * i);
        }
    }

}