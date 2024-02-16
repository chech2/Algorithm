import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static long[][] memo;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(recur( arr[0], 1));
    }
        public static long recur(int num, int cnt){
        if(num < 0 || 20 < num) return 0;
        if(cnt == n - 1) {
            if(num == arr[n - 1]){
                return 1;
            }
            return 0;
        }
        if(memo[cnt][num] != -1) return memo[cnt][num];

        return memo[cnt][num] = recur(num + arr[cnt], cnt + 1) + recur(num - arr[cnt], cnt + 1);
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        memo = new long[n][n * 9 + 1];
        strToken();

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}