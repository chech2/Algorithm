import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[] p, c, ans;
    static List<Integer>[] graph;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        dfs(r, -1);
        print();
    }

    public static void dfs(int now, int pre){
        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);

            if(next == pre) continue;
            ans[next] = ans[now] + c[next];
            dfs(next, now);
        }
    }

    public static void print(){
        for (int i = 1; i < n + 1; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void input () throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        c = new int[n + 1];
        ans = new int[n + 1];
        graph = new List[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            p[i] = Integer.parseInt(st.nextToken());

            if(p[i] == -1) r = i;
            else graph[p[i]].add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            c[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }
    }
}