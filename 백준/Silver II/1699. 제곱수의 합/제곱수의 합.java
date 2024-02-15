import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int n, size;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        Arrays.fill(dp, -1);
        setting(n);

        size = list.size();
        System.out.println(recur(0, 0));
    }

    public static int recur(int num, int start){
        if(n < num) return 200000;
        if(num == n) return 0;
        if(dp[num] != -1) return dp[num];

        int result = 200000;
        for (int i = start; i < size; i++) {
            result = Math.min(recur(num + list.get(i), i) + 1, result);
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