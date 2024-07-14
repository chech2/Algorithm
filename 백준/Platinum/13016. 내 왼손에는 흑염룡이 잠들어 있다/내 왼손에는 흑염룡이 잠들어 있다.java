import java.io.*;
import java.util.*;

public class Main {
    static class node{
        int v, l;
        node(int v, int l){
            this.v = v;
            this.l = l;
        }
    }

    static int n, l;
    static int[] d;
    static List<node>[] graph;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        input();

        dfs(1, 0, 0);
        dfs(findLongcontry(), 0, 0);
        dfs(findLongcontry(), 0, 0);

        print();
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            sb.append(d[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static int findLongcontry(){
        int max = 0;
        int idx = 0;
        for (int i = 1; i < n + 1; i++) {
            if(max < d[i]){
                max = d[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void dfs(int now, int pre, int len){
        node next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);

            if(next.v == pre) continue;
            d[next.v] = Math.max(d[next.v], len + next.l);
            dfs(next.v, now, len + next.l);
        }
    }


    public static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        graph = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v, l;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            graph[u].add(new node(v, l));
            graph[v].add(new node(u, l));
        }
    }
}