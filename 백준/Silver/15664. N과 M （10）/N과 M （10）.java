import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int result[],  number[];
    static int N, M, lastIdx;
    static StringBuilder sb = new StringBuilder();
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        number = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);
        combi(0, 0);
        System.out.println(sb);
    }
    static void combi(int cnt, int start) {
        if(cnt == M){
            int tmp = 0;
            for (int i = 0; i < M; i++) {
                tmp += tmp * 10 + result[i];
            }
            if(!set.contains(tmp)){
                set.add(tmp);
                for (int i = 0; i < M; i++) {
                    sb.append(result[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < N; i++) {
            result[cnt] = number[i];
            combi(cnt + 1, i + 1);
        }
    }

}