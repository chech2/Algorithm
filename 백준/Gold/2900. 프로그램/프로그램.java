import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k, q, L,R;
    static int[] jump, a;
    static long[] s;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
    }
    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void something(int idx, int j){

        for (int i = 0; i < n; i += idx) {
            a[i] += j;
        }
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        jump = new int[n];
        a = new int[n];
        s = new long[n + 1];

        strToken();
        for (int i = 0; i < k; i++) {
            jump[Integer.parseInt(st.nextToken())]++;
        }
        for (int i = 0; i < n; i++) {
            if(jump[i] != 0) something(i, jump[i]);
        }
        for (int i = 0; i < n; i++) s[i + 1] += s[i] + a[i];

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            strToken();
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            sb.append(s[R + 1] - s[L]).append("\n");
        }
        System.out.println(sb);
    }
}