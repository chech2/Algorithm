import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] bord, s;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        inputSetting();
        bw.append(String.valueOf(find()));
        bw.close();
    }

    static int find(){
        int ans, now;
        ans = Integer.MIN_VALUE;

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){

                now = s[i][j];
                for(int a = 1; a < i + 1; a++){
                    for(int b = 1; b < j + 1; b++){
                        ans = Math.max(ans, now - s[i - a][j] - s[i][j - b] + s[i - a][j - b]);
                    }
                }
            }
        }
        return ans;
    }

    static void inputSetting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bord = new int[n][m];
        s = new int[n + 1][m + 1];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                bord[i][j] = Integer.parseInt(st.nextToken());

                s[i + 1][j + 1] = s[i][j + 1] + s[i + 1][j] - s[i][j] + bord[i][j];
            }
        }
    }
}