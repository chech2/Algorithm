import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] selected;
    static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        combi(0);
        bw.append(sb);
        bw.close();
    }

    static void combi(int cnt){
        if(cnt == m){
            print();
            return;
        }

        for(int i = 1; i < n + 1; i++){
            if(visited[i]) continue;
            selected[cnt] = i;
            visited[i] = true;
            combi( cnt + 1);
            visited[i] = false;
        }
    }

    static void print(){
        for(int i = 0; i < m; i++){
            sb.append(selected[i]).append(" ");
        }
        sb.append("\n");
    }

    static void inputSetting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m];
        visited = new boolean[n + 1];
    }
}
