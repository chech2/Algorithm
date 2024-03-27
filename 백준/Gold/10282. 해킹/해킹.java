import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int T, n, d, c;
    static int[] dist;
    static ArrayList<node>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input();
            dijkstra();
        }
        System.out.println(sb);
    }

    public static void dijkstra(){
        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.s - o2.s);
        q.add(new node(c, 0));

        node now, tmp;
        while(!q.isEmpty()){
            now = q.poll();

            node next = null;
            for (int i = 0; i < graph[now.n].size(); i++) {
                tmp = graph[now.n].get(i);

                if(dist[now.n] + tmp.s < dist[tmp.n]){
                    dist[tmp.n] = dist[now.n] + tmp.s;
                    q.add(tmp);
                    if(next == null || next.s < tmp.s) {
                        next = tmp;
                    }
                }
            }
            if(next != null) q.add(next);
        }
        int tatalc = 0;
        int totals = 0;
        for (int i = 1; i < n + 1; i++) {
            if(dist[i] != 2000000000){
                tatalc++;
                totals = Math.max(totals, dist[i]);
            }
        }
        sb.append(tatalc).append(" ").append(totals).append("\n");
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void input() throws Exception{
        int a, b, s;

        strToken();
        n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
        d = Integer.parseInt(st.nextToken()); // 간선 수
        c = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];

        Arrays.fill(dist, 2000000000);
        dist[c] = 0;
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < d; i++) {
            strToken();
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            graph[b].add(new node(a, s));
        }
    }
    public static class node{
        int n, s;

        node(int n, int s){
            this.n = n;
            this.s = s;
        }
    }

}