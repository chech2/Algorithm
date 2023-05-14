import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int N;
    static int parent[];
    static boolean[] visited;

    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;
        for (int i = 0; i < list[1].size(); i++) {
            int now = list[1].get(i);
            q.add(now);
            visited[now] = true;
            parent[now] = 1;
        }
        while (!q.isEmpty()){
            int now = q.poll();
            int size = list[now].size();
            for (int i = 0; i < size; i++) {
                int next = list[now].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                parent[next] = now;
                q.add(next);
            }
        }

        for (int i = 2; i < N + 1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}