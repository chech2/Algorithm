import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, ans;
    static int[] d;
    static String[] name;
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<Integer>[] list, result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{

        input();
        phasealignment();
        ouput();

    }
    public static void phasealignment(){

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if(d[i] == 0){
                ans++;
                d[i]--;
                q.add(i);
                sb.append(name[i] + " ");
            }
        }
        sb.append("\n");

        int now, next, size;
        while(!q.isEmpty()){
            now = q.poll();

            size = list[now].size();
            for (int i = 0; i < size; i++) {
                next = list[now].get(i);
                d[next]--;
                if(d[next] == 0){
                    result[now].add(next);
                    d[next]--;
                    q.add(next);
                }
            }
        }
    }
    public static void ouput(){
        int size;
        System.out.println(ans);

        for (int i = 0; i < n; i++) {
            size = result[i].size();
            sb.append(name[i]).append(" ").append(size).append(" ");
            Collections.sort(result[i]);
            for (int j = 0; j < size; j++) {
                sb.append(name[result[i].get(j)]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());

        d = new int[n];
        name = new String[n];
        list = new ArrayList[n];
        result = new ArrayList[n];

        strToken();
        for (int i = 0; i < n; i++) {
            name[i] = st.nextToken();
            list[i] = new ArrayList<>();
            result[i] = new ArrayList<>();
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

            list[p].add(c);
            d[c]++;
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}