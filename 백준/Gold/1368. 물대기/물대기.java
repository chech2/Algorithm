import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, ans, cnt;
    static int[] parents;
    static class node{
        // from -> to로 이동
        int to, from, cost;
        node(int from, int to, int cost){
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];

        PriorityQueue<node> pq = new PriorityQueue<node>((o1, o2) -> o1.cost - o2.cost);
        parents[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            pq.add(new node(0, i, Integer.parseInt(br.readLine())));
            parents[i] = i;
        }

        int cost;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                cost = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                pq.add(new node(i, j, cost));
            }
        }

        node now;
        while(!pq.isEmpty()){
            now = pq.poll();
            // 부모가 다름 => 연결 되어 있지 않음 => 근데 연결 비용이 제일 저렴한 경우
            if(!union(now.to, find(now.from)) && cnt < n){
                cnt++;
                ans += now.cost;
            }
        }
        System.out.println(ans);
    }
    public static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return true;

        if(x < y) parents[y] = x;
        else parents[x] = y;
        return false;
    }
}