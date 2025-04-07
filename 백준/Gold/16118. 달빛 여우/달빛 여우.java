import java.io.*;
import java.util.*;

public class Main {
    static long MAX = 4000000000L;
    static List<node>[] graph;
    static int n, m, ans;
    static long[] f;
    static long[][] w;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        foxdijkstra();
        wolfdijkstra();

        for(int i = 2; i < n + 1; i++){
            if(f[i] < Math.min(w[i][0], w[i][1])) ans++;
        }
        System.out.println(ans);
    }

    static void foxdijkstra(){
        PriorityQueue<node> q = new PriorityQueue<>();
        q.add(new node(1, 0)); // 여우
        f[1] = 0;

        node now;
        while(!q.isEmpty()){
            now = q.poll();
            if(f[now.n] < now.d) continue;

            for(node next : graph[now.n]) {
                if (f[next.n] <= f[now.n] + next.d) continue;

                f[next.n] = f[now.n] + next.d;
                q.add(new node(next.n, f[next.n], now.speedUp));
            }
        }
    }

    static void wolfdijkstra(){
        PriorityQueue<node> q = new PriorityQueue<>();
        q.add(new node(1, 0, 1)); // 늑대
        w[1][1] = 0;

        long s;
        node now;
        while(!q.isEmpty()){
            now = q.poll();

            if(w[now.n][now.speedUp] < now.d) continue;

            for(node next : graph[now.n]) {

                if(now.speedUp == 1) s = next.d / 2;
                else s = next.d * 2;

                if(w[next.n][1 - now.speedUp] <= now.d + s) continue;

                w[next.n][1 - now.speedUp] = now.d + s;
                q.add(new node(next.n, w[next.n][1 - now.speedUp], 1 - now.speedUp));
            }
        }
    }

    static void inputSetting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        f = new long[n + 1];
        w = new long[n + 1][2];

        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();

            f[i] = MAX;
            w[i][0] = MAX;
            w[i][1] = MAX;
        }

        int a, b, c;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken()) * 2;

            graph[a].add(new node(b, c));
            graph[b].add(new node(a, c));
        }
    }

    static class node implements Comparable<node>{

        int n, speedUp;
        long d;

        node(int n, long d) {
            this.n = n;
            this.d = d;
        }

        node(int n, long d, int speedUp) {
            this.n = n;
            this.d = d;
            this.speedUp = speedUp;
        }

        @Override
        public int compareTo(node other){
            return Long.compare(this.d, other.d);
        }
    }
}