import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static int[] p;
    static List<Integer>[] graph;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        dfs(1, 0);
        for (int i = 2; i < n + 1; i++) {
            sb.append(p[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int now, int pre){

        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);
            if(next == pre) continue;

            p[next] = now;
            dfs(next, now);
        }
    }

    public static void input () throws Exception{
        n = Integer.parseInt(br.readLine());
        p = new int[n + 1];
        graph = new ArrayList[n + 1];
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
    }

}