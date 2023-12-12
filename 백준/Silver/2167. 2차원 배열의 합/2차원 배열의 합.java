import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

    static int N, M, startX, startY, endX, endY, K;
    static long[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N][M];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken()) - 1;
            startY = Integer.parseInt(st.nextToken()) - 1;
            endX = Integer.parseInt(st.nextToken()) - 1;
            endY = Integer.parseInt(st.nextToken()) - 1;
            long sum = 0;
            for (int j = startX; j <= endX; j++) {
                for (int k = startY; k <= endY; k++) {
                    sum += arr[j][k];
                }
            }
            System.out.println(sum);
        }
    }
}