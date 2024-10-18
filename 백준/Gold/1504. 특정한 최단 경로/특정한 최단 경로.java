import java.io.*;
import java.util.*;

public class Main {
    static final int max = 100000000;
    static int N, E, N1, N2;
    static int[] D, nD1, nD2;
    static List<node>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        input();
        D = dijkstra(1);
        nD1 = dijkstra(N1);
        nD2 = dijkstra(N2);

        int result = Math.min(D[N1] + nD1[N2] + nD2[N], D[N2]  + nD2[N1] + nD1[N]);
        if(max <= result) bw.append(String.valueOf(-1));
        else bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static int[] dijkstra(int start){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(start);
        int[] d = new int[N + 1];
        Arrays.fill(d, max);
        d[start] = 0;

        int now;
        node next;
        while(!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < graph[now].size(); i++) {
                next = graph[now].get(i);

                if(d[now] + next.d < d[next.n]){
                    d[next.n] = d[now] + next.d;
                    q.add(next.n);
                }
            }
        }
        return d;
    }




    static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();

        int a, b, c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[a].add(new node(b, c));
            graph[b].add(new node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
    }

    static class node{
        int n, d;
        node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
}