import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, l, k, ans;
    static int[] x, y;
    static int[][] start;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
        selectT();
        System.out.println(ans);
    }

    public static void selectT(){

        int tX, tY;
        for (int i = 0; i < k; i++) {
            tX = x[i];
            for (int j = 0; j < k; j++) {
                tY = y[j];
                cntStart(tX, tY);
            }
        }
    }

    public static void cntStart(int tX, int tY){
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            if(l < start[i][0] - tX || start[i][0] - tX < 0) continue;
            if(l < start[i][1] - tY || start[i][1] - tY < 0) continue;
            cnt++;
        }
        ans = Math.min(ans, k - cnt);
    }
    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = k;
        x = new int[k];
        y = new int[k];
        start = new int[k][2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
               start[i][j] = Integer.parseInt(st.nextToken());
            }
            x[i] = start[i][0];
            y[i] = start[i][1];
        }
        Arrays.sort(x);
        Arrays.sort(y);
    }

}