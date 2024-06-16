import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[] d, path;
    static ArrayList<node>[] graph;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        dijkstra();
        ans();
    }

    public static void ans() throws Exception{
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if(path[i] == 0) continue;
            cnt++;
            sb.append(i).append(" ").append(path[i]).append("\n");
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    public static void dijkstra(){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);

        int cur;
        node now;
        while(!q.isEmpty()) {
            cur = q.poll();

            for (int i = 0; i < graph[cur].size(); i++) {
                now = graph[cur].get(i);

                if (d[cur] + now.c < d[now.n]) {
                    d[now.n] = d[cur] + now.c;
                    q.add(now.n);
                    path[now.n] = cur;
                }
            }
        }
    }
    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        d = new int[n + 1];
        path = new int[n + 1];
        Arrays.fill(d, 100);
        d[1] = 0;
        d[0] = 0;
        for (int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();

        int t, f, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            f = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph[t].add(new node(f, c));
            graph[f].add(new node(t, c));
        }
    }

    public static class node{
        int n, c;
        node(int n, int c){
            this.n = n;
            this.c = c;
        }
    }

}