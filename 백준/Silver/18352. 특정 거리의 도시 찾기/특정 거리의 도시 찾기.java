import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, x;
    static ArrayList<Integer>[] map;
    static int[] d;
    static boolean[] visited;
    static PriorityQueue<Integer> result = new PriorityQueue<>(((o1, o2) -> o1 - o2));
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new ArrayList[n + 1];
        d = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }
        Arrays.fill(d, Integer.MAX_VALUE);
        d[x] = 0;

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            if(a == x) d[b] = 1;
        }

        //n개의 노드에 대해서 다 해당 방법이 실행될 것임
        // 처음에는 x부터
//        int start = x;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(x);
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 0; i < map[now].size(); i++) {
                int next = map[now].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                d[next] = Math.min(d[now] + 1, d[next]);
                q.add(next);

            }
        }
        for (int i = 1; i < n + 1; i++) {
            if(d[i] == k) result.add(i);
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        }else {
            while (!result.isEmpty()) {
                System.out.println(result.poll());
            }
        }
    }
}