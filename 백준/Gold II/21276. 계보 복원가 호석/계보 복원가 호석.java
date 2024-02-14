import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] parent;
    static String[] name;
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        input();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(parent[i] == i){
                cnt++;
                sb.append(name[i] + " ");
                q.add(i);
            }else {
                list[parent[i]].add(i);
            }
        }
        sb.append("\n");
        

        int size;
        for (int i = 0; i < n; i++) {
            size = list[i].size();
            sb.append(name[i]).append(" ").append(size).append(" ");
            for (int j = 0; j < size; j++) {
                sb.append(name[list[i].get(j)]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());

        parent = new int[n];
        name = new String[n];
        list = new ArrayList[n];

        strToken();
        for (int i = 0; i < n; i++) {
            name[i] = st.nextToken();
            parent[i] = i;
            list[i] = new ArrayList<>();
        }

        Arrays.sort(name);
        for (int i = 0; i < n; i++) {
            map.put(name[i], i);
        }


        strToken();
        m = Integer.parseInt(st.nextToken());
        int c, p;
        for (int i = 0; i < m; i++) {
            strToken();
            c = map.get(st.nextToken());
            p = map.get(st.nextToken());

            union(c, p);
        }
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    public static void union(int child, int ancestor){
        if(find(child) == find(ancestor)) return;
        parent[child] = ancestor;
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}