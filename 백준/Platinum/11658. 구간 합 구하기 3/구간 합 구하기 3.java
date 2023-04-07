import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //배열크기, 연산 횟수
    static int N, M;
    static long arr[][], Tree[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1][N + 1];
        Tree = new long[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
                update(i, j, arr[i][j]);
            }
        }

        int w, x, y, x2, y2;
        long c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());

            //update
            if(w == 0) {
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                update(x, y, c - arr[x][y]);
                arr[x][y] = c;
            }
            //sum
            else{
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                x2 = Integer.parseInt(st.nextToken());
                y2 =Integer.parseInt(st.nextToken());
                sb.append(sum(x, y, x2, y2)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void update(int row, int i, long num){
        while (i <= N){
            Tree[row][i] += num;
            i += (i & -i);
        }
    }

    static long sum(int row, int i){
        long result = 0;
        while(0 < i){
            result += Tree[row][i];
            i -= (i & -i);
        }
        return result;
    }

    static long sum(int x1, int y1, int x2, int y2){
        long result = 0;
        for (int i = x1; i < x2 + 1; i++) {
            result += sum(i, y2) - sum(i, y1 - 1);
        }
        return result;
    }
}