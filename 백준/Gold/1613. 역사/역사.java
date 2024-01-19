import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//    static ArrayList<Integer>[] forward, backward;
    static int[][] forward, backward;
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static int n, s, k;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        forward = new int[n + 1][n + 1];
        backward = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(forward[i], 10000);
            Arrays.fill(backward[i], 10000);
        }

        int start, end;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            forward[start][end] = 1;
            backward[end][start] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if(k == i || j == i || k == j) continue;
                    forward[i][j] = Math.min(forward[i][j], forward[i][k] + forward[k][j]);
                    backward[i][j] = Math.min(backward[i][j], backward[i][k] + backward[k][j]);
                }
            }
        }




        s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            if(forward[start][end] != 10000){
                bw.append("-1\n");
            }else if(backward[start][end] != 10000){
                bw.append("1\n");
            }else{
                bw.append("0\n");
            }
        }
        bw.flush();
        bw.close();
    }
}