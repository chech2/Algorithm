import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final String NO = "GOOD BYE";
    static final String YES = "SAVE HIM";
    static ArrayList<node>[] graph;
    static int v,e,p, mtog;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class node{
        int n, price;
        node(int n, int price){
            this.n = n;
            this.price = price;
        }
    }
    public static void main(String[] args) throws Exception{
        input();
        int mtom = dijkstra(1);
        int gtom = dijkstra(p);

        if (mtog + gtom <= mtom) {
            System.out.println(YES);
        } else {
            System.out.println(NO);
        }
    }
    public static int dijkstra(int start) {
        int[] d = new int[v + 1];
        boolean[] visited = new boolean[v + 1];
        PriorityQueue<node> q = new PriorityQueue<>(((o1, o2) -> {
            if(o1.price == o2.price) return o2.n - o1.n;
            return o1.price - o2.price;
        }));

        Arrays.fill(d, 20000);
        visited[start] = true;
        d[start] = 0;
        q.add(new node(start, 0));

        node now, next;
        int nextPrice, nextN;
        while (!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < graph[now.n].size(); i++) {
                next = graph[now.n].get(i);

                if(d[now.n] + next.price < d[next.n]){
                    d[next.n] = d[now.n] + next.price;
                }
            }

            nextPrice = 20000;
            nextN = 0;
            for (int i = 1; i < v + 1; i++) {
                if(visited[i]) continue;

                if(d[i] < nextPrice){
                    nextPrice = d[i];
                    nextN = i;
                }
            }

            if(nextN != 0) {
                visited[nextN] = true;
                q.add(new node(nextN, nextPrice));
            }
        }
        if(start == 1) mtog = d[p];
        return d[v];
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void input() throws Exception{
        strToken();
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        graph = new ArrayList[v + 1];

        for (int i = 0; i < v + 1; i++) graph[i] = new ArrayList<>();

        int n1, n2, price;
        for (int i = 0; i < e; i++) {
            strToken();
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            price = Integer.parseInt(st.nextToken());

            graph[n1].add(new node(n2, price));
            graph[n2].add(new node(n1, price));
        }
    }
}