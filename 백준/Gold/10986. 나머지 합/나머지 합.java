import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long ans;
    static long[] modArr, aSum, modCnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        modCnt = new long[M];
        aSum = new long[N + 1];
        modArr = new long[N + 1];
        long tmp;
        for (int i = 1; i < N + 1; i++) {
            tmp = Long.parseLong(st.nextToken());
            modArr[i] = (modArr[i - 1] + tmp) % M;
            if(modArr[i] == 0) ans++;
            modCnt[(int)modArr[i]]++;
        }
        for (int i = 0; i < M; i++) {
            tmp = modCnt[i];
            if(1 < tmp)
            ans += (modCnt[i] * (modCnt[i] - 1))/ 2;
        }
        System.out.println(ans);
    }
}