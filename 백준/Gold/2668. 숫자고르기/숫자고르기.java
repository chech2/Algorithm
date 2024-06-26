import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        input();
        for (int i = 1; i < n + 1; i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        sb.append(ans.size()).append("\n");
        Collections.sort(ans);

        for (int i = 0; i < ans.size(); i++) sb.append(ans.get(i)).append("\n");
        bw.append(sb);
        bw.flush();
        bw.close();
    }

    public static void dfs(int now, int target){

        int next = arr[now];
        if(!visited[next]){
            visited[next] = true;
            dfs(next, target);
            visited[next] = false;
        }

        if(next == target) ans.add(now);
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) arr[i] = Integer.parseInt(br.readLine());
    }
}