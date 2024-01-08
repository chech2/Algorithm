import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[][] map;
    static long ans;
    static int[] parent;
    static PriorityQueue<node> edge = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
            parent[i] = i;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                edge.add(new node(i, j, map[i][j]));
            }
        }

        while(!edge.isEmpty()){
            node now = edge.poll();

            if(find(now.start) != find(now.end)){
                union(now.start, now.end);
                ans += now.d;
            }
        }
//        System.out.println(Arrays.toString(parent));
        System.out.println(ans);

    }

    static int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return;
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }

    public static class node{
        int start, end, d;

        node(int start, int end, int d){
            this.start = start;
            this.end = end;
            this.d = d;
        }
    }
}