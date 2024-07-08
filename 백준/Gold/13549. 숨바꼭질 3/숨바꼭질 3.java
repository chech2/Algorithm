import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] d = {0, -1, 1};
    static boolean[] visited;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        if (k <= n) System.out.println(n - k);
        else System.out.println(bfs());
    }

    public static int bfs(){
        node now, next;
        int x, size;
        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);

        q.add(new node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()){
            now = q.poll();

            if(now.x == k) return now.t;

            d[0] = now.x;
            for (int j = 0; j < 3; j++) {
                x = now.x + d[j];

                if(x < 0 || k * 2 < x || x == 0) continue;
                if(j != 0 && visited[x]) continue;
                visited[x] = true;

                if(j == 0) next = new node(x, now.t);
                else next = new node(x, now.t + 1);
                q.add(next);
            }
        }

        return 0;
    }

    public static void input () throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[200001];
    }

    public static class node{
        int x, t;
        node(int x, int t){
            this.x = x;
            this.t = t;
        }
    }
}