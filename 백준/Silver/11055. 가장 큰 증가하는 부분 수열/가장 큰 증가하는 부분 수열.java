import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;

public class Main {

    static int N, ans;
    static int[] memo, origin;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        memo = new int[N + 1];
        origin = new int[N + 1];
        origin[0] = 0;
        memo[0] = 0;

        for (int i = 1; i < N + 1; i++) origin[i] = Integer.parseInt(st.nextToken());

        ans = origin[1];
        for (int i = 1; i < N + 1; i++) {
            memo[i] = origin[i];
            int num = 0;
            for (int j = 1; j < i; j++) {
                if(origin[j] < origin[i] && memo[i] < memo[j] + origin[i])
                    memo[i] = memo[j] + origin[i];
            }
            ans = Math.max(ans, memo[i]);

        }
//        System.out.println(Arrays.toString(memo));
        System.out.println(ans);
    }
}