import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long[] S;
    static long ans;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        S = new long[N + 1];
        S[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());

            //0 ~ S[i]까지의 누적합이 K인 경우
            if(S[i] == K) ans++;

            //S[i] - K == B인데 B값을 키로 가지고 있는 경우, 즉 누적합이 B인 경우, S[i] - B = K
            if(map.containsKey(S[i] - K)) ans += map.get(S[i] - K);
            if(map.containsKey(S[i])) map.put(S[i], map.get(S[i]) + 1);
            else map.put(S[i], 1L);
        }
        System.out.println(ans);
    }
}