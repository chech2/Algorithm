import java.io.*;
import java.util.*;

public class Main {

    static int n, r, q;
    static int[] sub, query;
    static List<Integer>[] graph;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        input();
        dfs(r, 0);
        for (int i = 0; i < q; i++) {
            sb.append(sub[query[i]]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int now, int pre){

        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);

            if(next == pre) continue;
            dfs(next, now);
            sub[now] += sub[next];
        }
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        sub = new int[n + 1];
        query = new int[q];
        Arrays.fill(sub, 1);

        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < q; i++) {
            query[i] = Integer.parseInt(br.readLine());
        }
    }

}