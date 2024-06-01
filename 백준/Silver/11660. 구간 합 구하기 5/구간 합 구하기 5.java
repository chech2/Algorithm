import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] s, info;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        input();
        sum();
        bw.append(sb);
        bw.flush();
        bw.close();
    }

    public static void sum(){
        int x1, x2, y1, y2;
        for (int i = 0; i < m; i++) {
            x1 = info[i][0];
            y1 = info[i][1];
            x2 = info[i][2];
            y2 = info[i][3];
            sb.append(s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1]).append("\n");
        }
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = new int[n + 1][n + 1];
        info = new int[m][4];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < n + 1; j++) s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) info[i][j] = Integer.parseInt(st.nextToken());
        }
    }

}