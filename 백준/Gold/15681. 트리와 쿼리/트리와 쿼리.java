import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, r, q;
    static ArrayList<Integer>[] graph;
    static int[] sub, ans;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        cntsub(r, r);

        for (int i = 0; i < q; i++) {
            sb.append((sub[ans[i]] + 1)).append("\n");
        }
        System.out.println(sb);
    }

    public static void cntsub(int now, int pre){

        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);

            if(next == pre) continue;
            cntsub(next, now);
            sub[now] += sub[next] + 1;
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void input() throws Exception{
        strToken();

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        sub = new int[n + 1];
        ans = new int[q];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v;
        for (int i = 0; i < n - 1; i++) {
            strToken();
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < q; i++) {
            strToken();
            ans[i] = Integer.parseInt(st.nextToken());
        }
    }

}