import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] bee;
    static int[] zero, one, two;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        daily_grow();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(bee[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.append(sb);
        bw.close();
    }

    static void daily_grow(){
        for(int day = 0; day < n; day++) {

            for (int i = m - 1; 0 <= i; i--) {

                if(0 < zero[day]--) bee[i][0] += 0;
                else if(0 < one[day]--) bee[i][0] += 1;
                else if(0 < two[day]--) bee[i][0] += 2;
            }

            for (int i = 1; i < m; i++) {

                if(0 < zero[day]--) bee[0][i] += 0;
                else if (0 < one[day]--) bee[0][i] += 1;
                else if (0 < two[day]--) bee[0][i] += 2;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < m; j++){
                bee[i][j] += Math.max(bee[i][j - 1], Math.max(bee[i - 1][j - 1], bee[i - 1][j])) - 1;
            }
        }
    }
    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        bee = new int[m][m];
        zero = new int[n];
        one = new int[n];
        two = new int[n];

        for (int i = 0; i < m; i++) Arrays.fill(bee[i], 1);

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            zero[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
            two[i] = Integer.parseInt(st.nextToken());
        }
    }
}