import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[] kList;
    static boolean[] visited;
    static PriorityQueue<Integer> result;
    static PriorityQueue<node> q;
    static ArrayList<node>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        bfs();
        print();
    }

    public static void bfs(){
        visited[1] = true;
        q.add(new node(1, 0, 1));

        node now, next;
        while (!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < graph[now.n].size(); i++) {
                next = graph[now.n].get(i);

                if(visited[next.n]) continue;
                if(now.white == 1) result.add(next.n);
                visited[next.n] = true;

                q.add(new node(next.n, now.t + next.t, now.white));
            }
        }
    }

    public static void print() throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(result.isEmpty()) sb.append(0);
        while (!result.isEmpty()) {
            sb.append(result.poll()).append(" ");
        }

        bw.append(sb);
        bw.flush();
        bw.close();
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        kList = new int[k];
        visited = new boolean[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int n1, n2, p;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            graph[n1].add(new node(n2, p, -1));
            graph[n2].add(new node(n1, p, -1));
        }

        result = new PriorityQueue<>();
        q = new PriorityQueue<>((o1, o2) -> {
            if(o1.t == o2.t) return o1.white - o2.white;
            return o1.t - o2.t;
        });

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            kList[i] = Integer.parseInt(st.nextToken());
            q.add(new node(kList[i], 0, 0));
            visited[kList[i]] = true;

        }
    }

    // 0: 추종자, 1: 백채원, -1: 초기값
    static class node{
        int n, t, white;
        node(int n, int t, int white){
            this.n = n;
            this.t = t;
            this.white = white;
        }
    }
}