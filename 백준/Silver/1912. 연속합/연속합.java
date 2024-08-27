import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class Main {
    static int n, ans;
    static int[] s;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        s = new int[n + 1];

        int now;
        ans = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            now = Integer.parseInt(st.nextToken());

            // 지금까지 값 중 최대 값 저장
            s[i] = Math.max(s[i - 1] + now, now);
            ans = Math.max(ans, s[i]);
        }
        System.out.println(ans);
    }

}