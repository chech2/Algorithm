import java.io.*;
import java.util.*;

public class Main {
    static int INF = 100000;
    static String OHNO = "Oh no";
    static int n, m, k;
    static int[] fee, p;
    static List<Integer>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        int ans = calFee();

        if (ans == INF) System.out.println(OHNO);
        else System.out.println(ans);
    }

    static int calFee(){
        Map<Integer, Integer> cal = new HashMap<>();

        int pre;
        for(int i = 1; i < n + 1; i++){
            find(i); // 혹시 친구가 없는 경우

            pre = cal.getOrDefault(p[i], INF);
            cal.put(p[i], Math.min(pre, Math.min(fee[p[i]], fee[i])));
        }

        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : cal.entrySet()){
            sum += entry.getValue();
        }
        if(sum <= k) return sum;
        else return INF;
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return true;
        else {
            p[a] = b;
            return false;
        }
    }

    static int find(int a){
        if(p[a] == -1) return p[a] = a;
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    static void inputSetting() throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        fee = new int[n + 1];
        graph = new List[n + 1];
        p = new int[n + 1];
        Arrays.fill(p, -1);

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            fee[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        int u, v;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);

            union(u, v);
        }
    }
}