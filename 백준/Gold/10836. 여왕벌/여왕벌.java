import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] bee, grow_info, diff;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        for(int i = 0; i < n; i++) grow(i);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(bee[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.append(sb);
        bw.close();
    }

    static void grow(int day){
        daily_setting(day);

        for(int i = 1; i < m; i++){
            for(int j = 1; j < m; j++){
                diff[i][j] = Math.max(diff[i][j - 1], Math.max(diff[i - 1][j - 1], diff[i - 1][j]));
                bee[i][j] += diff[i][j];
            }
        }
    }

    static void daily_setting(int day){
        for (int i = m - 1; 0 <= i; i--) {

            for(int j = 0; j < 3; j++) {
                if(0 < grow_info[day][j]){
                    diff[i][0] = j;
                    bee[i][0] += j;
                    grow_info[day][j]--;
                    break;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                if(0 < grow_info[day][j]){
                    diff[0][i] = j;
                    bee[0][i] += j;
                    grow_info[day][j]--;
                    break;

                }
            }
        }
    }
    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        bee = new int[m][m];
        diff = new int[m][m];
        grow_info = new int[n][3];

        for (int i = 0; i < m; i++) Arrays.fill(bee[i], 1);

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++) grow_info[i][j] = Integer.parseInt(st.nextToken());
        }
    }
}