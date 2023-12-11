import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static StringBuilder sb;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(list[i]);
        }

        dfs(V);
        sb.append("\n");
        bfs();
        System.out.println(sb);
    }

    static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i < list[start].size(); i++) {
            int now = list[start].get(i);
            if(visited[now]) continue;

            dfs(now);
        }
    }

    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        Arrays.fill(visited, false);
        visited[V] = true;
        q.add(V);
        sb.append(V).append(" ");

        while (!q.isEmpty()){
            int now = q.poll();
            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);
                if(visited[next]) continue;

                visited[next] = true;
                q.add(next);
                sb.append(next).append(" ");
            }
        }
    }

}