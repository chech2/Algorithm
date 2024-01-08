import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] map;
    static int[] memo;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1];
        memo = new int[n + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int start, end, d;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            memo[start] += d;
            memo[end + 1] -= d;
        }

        for (int i = 1; i < n + 1; i++) {
            memo[i] += memo[i - 1];
            map[i] += memo[i];
        }

        for (int i = 1; i < n + 1; i++) {
            sb.append(map[i]).append(" ");
        }
        System.out.println(sb);
    }
}