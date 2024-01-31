import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] seleted;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seleted = new int[m];
        visited = new boolean[n + 1];

        perm(0);
        System.out.println(sb);
    }

    public static void perm(int cnt){
        if(cnt == m){
            for (int i = 0; i < m; i++) {
                sb.append(seleted[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            seleted[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}