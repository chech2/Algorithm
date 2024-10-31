import java.io.*;
import java.util.*;
public class Main {
    static int n, m, ans;
    static Set<Integer> cd;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        while(true){
            pre_setting();
            if(n == 0 && m == 0) break;
        }
        bw.append(sb);
        bw.close();
    }

    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int ans = 0;

        cd = new HashSet();
        for(int i = 0; i < n; i++){
            cd.add(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < m; i++){
            if(cd.contains(Integer.parseInt(br.readLine()))) ans++;
        }
        if(n != 0 && m != 0) sb.append(ans).append("\n");
    }
}