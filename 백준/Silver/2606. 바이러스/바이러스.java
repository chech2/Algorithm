import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        input();
        dfs(1);
        System.out.println(ans);
    }

    public static void dfs(int now){

        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);

            if(visited[next]) continue;
            ans++;
            visited[next] = true;
            dfs(next);
        }

    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        visited[1] = true;
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int n1, n2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }
    }
}