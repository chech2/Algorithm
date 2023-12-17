import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long start, mid, end;
    static long[] LAN;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        LAN = new long[K];
        start = 1;
        for (int i = 0; i < K; i++) {
            LAN[i] = Long.parseLong(br.readLine());
            end = Math.max(LAN[i], end);
        }

        while (start <= end){
            long cnt = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < LAN.length; i++) cnt += LAN[i] / mid;

            if(N <= cnt) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(end);
    }
}