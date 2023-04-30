import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[] number, result;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        ans = Integer.MIN_VALUE;
        number = new int[N];
        result = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(ans);
    }

    static void perm(int cnt){
        if(cnt == N){
//            cal();
            ans = Math.max(cal(), ans);
//            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visit[i]) continue;
            result[cnt] = number[i];
            visit[i] = true;
            perm(cnt + 1);
            visit[i] = false;
        }
    }
    static int cal(){
        int calresult = 0;
        for (int i = 0; i < N - 1; i++) {
            calresult += Math.abs(result[i] - result[i + 1]);
        }
        return calresult;

    }
}