import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long MAXNUM, MINNUN, MIDNUM, result;
    static long[] Immigration;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Long.MAX_VALUE;

        Immigration = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Immigration[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(Immigration);
        MAXNUM = Immigration[N - 1] * M;
        MINNUN = 0;

        while(MINNUN <= MAXNUM){
            long tmp = 0;
            MIDNUM = (MAXNUM + MINNUN) / 2;
            for (int i = 0; i < N; i++) {
                tmp += MIDNUM / Immigration[i];
                if(tmp >= M) break;
            }
            if(tmp < M)  MINNUN = MIDNUM + 1;
            else{
                MAXNUM = MIDNUM - 1;
                result = Math.min(result, MIDNUM);
            }
        }
        System.out.println(result);

    }
}