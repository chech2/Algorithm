import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int [] D;
    static List<Integer>[] graph;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        input();

        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        q.add(new node(X, 0));

        node now;
        int  next;
        while (!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < graph[now.n].size(); i++) {
                next = graph[now.n].get(i);
                if(D[now.n] + 1 < D[next]){
                    D[next] = D[now.n] + 1;
                    q.add(new node(next, D[now.n] + 1));
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if(i != X && K == D[i]) sb.append(i).append("\n");
        }
        if(sb.length() == 0) bw.append(String.valueOf(-1));
        else bw.append(sb);
        bw.flush();
        bw.close();
    }

    static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        D = new int[N + 1];
        Arrays.fill(D, 100000000);
        D[X] = 0;
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
        }
    }

    static class node{
        int n, d;
        node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
}