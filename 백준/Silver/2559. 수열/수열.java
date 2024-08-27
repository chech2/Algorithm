import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] s;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(mintemp());
    }

    public static int mintemp(){
        int ans = -20000000;
        for (int i = n; -1 < i - k; i--) {
            ans = Math.max(ans, s[i] - s[i - k]);
        }
        return ans;
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++){
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }
    }
}