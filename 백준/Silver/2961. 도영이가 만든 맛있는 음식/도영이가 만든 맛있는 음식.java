import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] list;
    static long ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new int[n][2];
        ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        combi(0, 1, 0);


        System.out.println(ans);
    }

    public static void combi (int cnt, long s, long b){
        if(cnt == n){
            if(b != 0) ans = Math.min(ans, Math.abs(s - b));
            return;
        }
        combi(cnt + 1, s * list[cnt][0], b + list[cnt][1]);
        combi(cnt + 1, s, b);
    }
}