import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        int[][] sum;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sum = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j < n + 1; j++){
                sum[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        int sx, sy, ex, ey;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            sb.append(sum[ex][ey] - (sum[sx - 1][ey] + sum[ex][sy - 1]) + sum[sx - 1][sy - 1]);
            if(i != m - 1) sb.append("\n");
        }
        bw.append(sb);
        bw.close();
    }
}
