import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int result[], number[];
    static int N, M;
    static StringBuilder sb = new StringBuilder();
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
        perm(0);
        System.out.println(sb);
    }

    static void perm(int cnt){
        if(cnt == M){
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(cnt == 0){
                result[cnt] = number[i];
            }else {
                for (int j = i; j < N; j++) {
                    if (result[cnt - 1] < number[j]) {
                        result[cnt] = number[j];
                        i = j;
                        break;
                    }
                    if (j == N - 1) return;
                }
            }
            perm(cnt + 1);
        }
    }
}