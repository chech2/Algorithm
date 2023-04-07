import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long arr[], Tree[];
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        Tree = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Long.parseLong(br.readLine());
            update(i, arr[i]);
        }

        for (int change = 0; change < M + K; change++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1){
                update(b,c - arr[b]);
                arr[b] = c;
            }else{
                sb.append(sum((int)c) - sum(b - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void update(int idx, long num) {
        while (idx <= N) {
            Tree[idx] += num;
            idx += (idx & -idx);
        }
    }

    static long sum(int idx){
        long result = 0;
        while(0 < idx){
            result += Tree[idx];
            idx -= (idx & - idx);
        }
        return result;
    }
}