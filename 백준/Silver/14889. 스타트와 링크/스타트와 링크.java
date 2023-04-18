import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, ansMIN, ability[][];
    static boolean selected[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        selected = new boolean[N];
        ansMIN = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        subset(0, 0);
        System.out.println(ansMIN);
    }
    static void subset(int cnt, int truechk){
        if(cnt == N){
            if(truechk * 2 == N) {
                int tmp = Math.abs(AbilitySum(true) - AbilitySum(false));
                ansMIN = Math.min(ansMIN, tmp);
            }
            return;
        }
        selected[cnt] = true;
        subset(cnt + 1, truechk + 1);
        selected[cnt] = false;
        subset(cnt + 1, truechk);
    }

    static int AbilitySum(boolean team) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            if(team == selected[i]){
                for (int j = 0; j < N; j++) {
                    if(team == selected[j] && i != j)
                        result += ability[i][j];
                }
            }
        }
        return result;
    }


}