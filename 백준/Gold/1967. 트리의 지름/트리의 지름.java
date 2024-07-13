import java.io.*;
import java.util.*;

public class Main {

    public static class node {
        int v, p;
        node(int v, int p){
            this.v = v;
            this.p = p;
        }
    }

    static int n, ans, l;
    static int[] d;
    static List<node>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        dfs(1, 0, 0);


        Arrays.fill(d, 0);
        dfs(l, 0, 0);
        System.out.println(ans);

    }

    public static void dfs(int now, int pre, int price){

        node next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);

            if(next.v == pre) continue;
            d[next.v] += d[now] + next.p;
            if(ans < d[next.v]){
                ans = d[next.v];
                l = next.v;
            }
            dfs(next.v, now, price + next.p);
        }
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        graph = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v, p;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            graph[u].add(new node(v, p));
            graph[v].add(new node(u, p));
        }
    }

}