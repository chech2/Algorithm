import java.io.*;
import java.util.*;

public class Main {
    static final String Y = "YES\n";
    static final String N = "NO\n";
    static int n, m;
    static int[] p;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n + 1];

        for(int i = 0; i < n + 1; i++) p[i] = i;

        int cal, a, b;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            cal = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(cal == 0){
                if(a == b) continue;
                union(a, b);
            }else{
                if(find(a) == find(b)) sb.append(Y);
                else sb.append(N);
            }
        }
        bw.append(sb);
        bw.close();
    }

    static int find(int a){
        if(p[a] == a) return p[a];
        return find(p[a]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b){
            return true;
        } else if(a < b){
            p[a] = b;
        } else{
            p[b] = a;
        }
        return false;
    }
}

