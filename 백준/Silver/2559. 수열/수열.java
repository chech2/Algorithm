import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m, ans;
        int[] sum;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = -10000000;
        sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        for(int i = m; i < n + 1; i++){
            ans = Math.max(ans, sum[i] - sum[i - m]);
        }
        System.out.println(ans);
    }
}
