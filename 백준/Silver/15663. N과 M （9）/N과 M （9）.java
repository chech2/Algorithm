import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result[], number[], pre[];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        pre = new int[M];
        number = new int[N];
        visited = new boolean[N];

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
//            if(Arrays.toString(pre).equals(Arrays.toString(result))) return;
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            pre = result.clone();
            return;
        }
        for (int i = 0; i < N; i++) {

            if(visited[i]) continue;
            if(result[cnt] == number[i] && Arrays.toString(pre).equals(Arrays.toString(result))) continue;

            visited[i] = true;
            result[cnt] = number[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}