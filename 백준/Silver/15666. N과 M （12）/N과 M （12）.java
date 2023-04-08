import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result[], number[];
    static HashSet<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[N];
        result = new int[M];
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
            int tmp = 0;
            for (int i = 0; i < M; i++) {
                if(i != 0 && result[i] < result[i - 1]) return;
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
        for (int i = 0; i < N; i++) {
            result[cnt] = number[i];
            perm(cnt + 1);
        }
    }
}