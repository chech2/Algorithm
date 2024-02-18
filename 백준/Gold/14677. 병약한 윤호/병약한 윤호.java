import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static char[] pill, compare;
    static int[][][] dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(recur(0, 0, 3 * n - 1));
    }

    public static int recur(int now, int f, int b) { //직전에 먹은 약의 종류, 앞에서부터 먹은 개수, 뒤에서부터 먹은 개수

        if (b < f || 3 * n < f || b < 0) return 0; // 이미 먹은 약을 먹게 되는 경우
        if (pill[f] != compare[now] && pill[b] != compare[now]) return 0; // 앞,뒤로 먹을 수 있는 약이 없는 경우

        int result = 0;
        int next = 0;

        if(now == 0) next = 1;
        else if(now == 1) next = 2;

        if(dp[now][f][b] != -1) return dp[now][f][b];

        if(compare[now] == pill[f] && f + 1 < 3 * n) result = Math.max(recur(next, f + 1, b), result);
        if(compare[now] == pill[b] && 0 <= b - 1) result = Math.max(recur(next, f, b - 1), result);

        return dp[now][f][b] = result + 1;
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());

        pill = br.readLine().toCharArray();
        dp = new int[3][3 * n][3 * n];
        compare = new char[3];
        compare[0] = 'B';
        compare[1] = 'L';
        compare[2] = 'D';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 * n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}