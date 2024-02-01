import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static double ans;
    static int[] parent;
    static star[] info;
    static class star{
        double x, y;
        star(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    static class node{
        int n1, n2;
        double len;
        node(int n1, int n2, double s1X, double s1Y, double s2X, double s2Y){
            this.n1 = n1;
            this.n2 = n2;
            this.len = Math.sqrt(Math.pow((s1X - s2X), 2) + Math.pow((s1Y - s2Y), 2));
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        info = new star[n];
        parent = new int[n];

        double x, y;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());

            info[i] = new star(x, y);
            parent[i] = i;
        }

        PriorityQueue<node> q = new PriorityQueue<>(Comparator.comparingDouble(o -> o.len));

        star s1, s2;
        for (int i = 0; i < n; i++) {
            s1 = info[i];
            for (int j = i + 1; j < n; j++) {
                s2 = info[j];
                q.add(new node(i, j, s1.x, s1.y, s2.x, s2.y));
            }
        }


        node now;
        while(!q.isEmpty()){
            now = q.poll();

            // 아직 합쳐지지 않은 경우
            if(!union(now.n1, now.n2)){
                ans += now.len;
            }
        }
        ans = Math.floor(ans * 100) / 100;
        bw.append(ans + "");
        bw.flush();
        bw.close();
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return true;

        if(x < y) parent[y] = x;
        else parent[x] = y;
        return false;
    }

    public static int find(int x){
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }
}