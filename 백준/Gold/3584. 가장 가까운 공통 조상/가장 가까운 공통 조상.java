import java.io.*;
import java.util.*;

public class Main {

    static int T, n, r, s, e;
    static int[] p, level;
    static List<Integer>[] graph;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input();
            dfs(r, 0);
            sb.append(findParent()).append("\n");
        }
        System.out.println(sb);
    }

    public static int findParent(){

        // 둘의 레벨이 다를 경우, 레벨을 맞춰서 부모가 같은지 확인
        if(level[s] > level[e]) s = adjustLevel(e, s);
        if(level[s] < level[e]) e = adjustLevel(s, e);

        // 둘의 레벨이 같을 경우, 레벨을 같이 올리면서 공통 부모 찾기
        if (s == e) return s;

        while(s != e){
            s = p[s];
            e = p[e];
        }
        return s;
    }

    public static int adjustLevel(int small, int big){
        while(level[small] != level[big]){
            big = p[big];
        }
        return big;
    }

    public static void dfs(int now, int pre){

        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);

            if(next == pre) continue;
            level[next] = level[now] + 1;
            dfs(next, now);
        }
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());

        p = new int[n + 1];
        level = new int[n + 1];
        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            p[v] = u;
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i < n + 1; i++) {
            if(p[i] != 0) continue;
            r = i;
            break;
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
    }

}