import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, MAXVALUE, idx;
    static int[] size, parent;
    static ArrayList<node>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        finddiameter(1, 0);

        Arrays.fill(size, 0);
        finddiameter(idx, 0);

        System.out.println(MAXVALUE);
    }
    public static void finddiameter(int cur, int pre){
        node next;

        for (int i = 0; i < graph[cur].size(); i++) {
            next = graph[cur].get(i);

            if(next.n == pre) continue;
            size[next.n] = size[cur] + next.w;
            if(MAXVALUE < size[next.n]){
                MAXVALUE = size[next.n];
                idx = next.n;
            }
            finddiameter(next.n, cur);
        }
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        size = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int p, c, w;
        for (int i = 0; i < n - 1; i++) {
            strToken();
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            parent[c] = p;
            graph[p].add(new node(c, w));
            graph[c].add(new node(p, w));
        }
    }
    public static class node{
        int n, w;
        node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}