import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long start, end, result, high;
    static long[] tree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(tree);
        end = tree[N - 1];
        result = Long.MIN_VALUE;
        while(start <= end){
            long sum = 0;
            high = (end + start) / 2;

            for (int i = 0; i < N; i++) {
                long tmp = tree[i] - high;
                if(tmp > 0) sum += tmp;
            }
            if(sum >= M){
                start = high + 1;
                result = Math.max(result, high);
            }else{
                end = high - 1;

            }
        }
        System.out.println(result);
    }

}