import java.io.*;
import java.util.*;

public class Main {

    static int v, e, k;
    static final int INF = 5000000;
    static ArrayList<node>[] graph;
    static int[] d;
    static PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static class node{
        int n, w;
        node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        dijkstra();

        for (int i = 1; i < v + 1; i++) {
            if(d[i] == INF) sb.append("INF");
            else sb.append(d[i]);
            sb.append("\n");
        }
        System.out.println(sb);
//        bw.append(sb);
//        bw.flush();
//        bw.close();
    }

    public static void dijkstra(){
        q.add(new node(k, 0));

        node now, next;
        while(!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < graph[now.n].size(); i++) {
                next = graph[now.n].get(i);

                if(d[now.n] + next.w < d[next.n]){
                    d[next.n] = d[now.n] + next.w;
                    q.add(new node(next.n, d[next.n]));
                }
            }
        }
    }
    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[v + 1];
        d = new int[v + 1];
        Arrays.fill(d, INF);

        k = Integer.parseInt(br.readLine());
        d[k] = 0;

        for (int i = 0; i < v + 1; i++) graph[i] = new ArrayList<>();

        int n1, n2, w;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[n1].add(new node(n2, w));
        }
    }
}