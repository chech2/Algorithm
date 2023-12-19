import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] time, map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new int[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(time[i], 10000);
            time[i][i] = 0;
        }

        int start, end, distance;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()) - 1;
            end = Integer.parseInt(st.nextToken()) - 1;
            distance = Integer.parseInt(st.nextToken());
            time[start][end] = distance;
            time[end][start] = distance;
            map[start][end] = end;
            map[end][start] = start;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (time[i][k] + time[k][j] < time[i][j]){
                        map[i][j] = map[i][k];
                        time[i][j] = time[i][k] + time[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                if(i == j)sb.append("-").append(" ");
                else sb.append(map[i][j] + 1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}