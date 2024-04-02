import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] p, ans;
    static int[][] info;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        dfs(1);
        for (int i = 1; i < n + 1; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int now) {
        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);
            ans[next] += ans[now];
            dfs(next);
        }
    }
    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        ans = new int[n + 1];

        info = new int[m][2];
        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        strToken();
        for (int i = 1; i < n + 1; i++) {
            p[i] = Integer.parseInt(st.nextToken());

            if (p[i] != -1) graph[p[i]].add(i);
        }

        for (int i = 0; i < m; i++) {
            strToken();
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            ans[info[i][0]] += info[i][1];
        }
    }
    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}