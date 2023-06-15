import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    static int N, ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        memo = new int[N + 1];

        Arrays.fill(memo, Integer.MIN_VALUE);
        memo[0] = 0;
        ans = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            memo[i] = Math.max(memo[i - 1] + num, num);

            ans = Math.max(ans, memo[i]);
        }
        System.out.println(ans);
    }
    
}