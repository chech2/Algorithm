import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
//
    static ArrayList<node>[] graph;
    static boolean[] visited;
    static ArrayDeque<node> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<node>();
        }

        int start, end, d;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            graph[start].add(new node(end, d));
            graph[end].add(new node(start, d));
        }

        node now;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            d = 0;
            Arrays.fill(visited, false);
            q.clear();
            q.add(new node(start, 0));
            while(!q.isEmpty()){
                now = q.poll();

                if(now.connection == end){
                    sb.append(now.d).append("\n");
                    break;
                }

                for (int j = 0; j < graph[now.connection].size(); j++) {
                    node next = graph[now.connection].get(j);
                    if(visited[next.connection]) continue;
                    visited[next.connection] = true;

                    q.add(new node(next.connection, now.d + next.d));

                }
            }
        }
        System.out.println(sb);

    }

    public static class node{
        int connection, d;
        node(int connection, int d){
            this.connection = connection;
            this.d = d;
        }
    }
}