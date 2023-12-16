import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long ans;
    static long[] mod, modCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mod = new long[N + 1];
        modCnt = new long[M];

        st = new StringTokenizer(br.readLine());
        long input = 0;
        for (int i = 1; i < N + 1; i++) {
            input += Long.parseLong(st.nextToken());
            mod[i] = input % M;
            if(mod[i] == 0) ans++;
            modCnt[(int)mod[i]]++;
        }
        for (int i = 0; i < M; i++) {
            ans += (modCnt[i] * (modCnt[i] - 1)) / 2;
        }
        System.out.println(ans);
    }
}