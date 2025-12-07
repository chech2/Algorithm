import java.io.*;
import java.util.*;

public class Main {

    static int[] info;
    static int[][] arr, copyArr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        info = new int[4];
        for (int i = 0; i < 4; i++) info[i] = Integer.parseInt(st.nextToken());
        arr = new int[info[0]][info[1]];
        copyArr = new int[info[0] + info[2]][info[1] + info[3]];
        int x, y;
        for (int i = 0; i < info[0] + info[2]; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < info[1] + info[3]; j++) {
                copyArr[i][j] = Integer.parseInt(st.nextToken());

                x = i - info[2];
                y = j - info[3];

                if (i < info[0] && j < info[1]) {
                    if (0 <= x && x < info[0] && 0 <= y && y < info[1]) arr[i][j] = copyArr[i][j] -  arr[x][y];
                    else arr[i][j] = copyArr[i][j];

                    if(j < info[1] - 1) sb.append(arr[i][j]).append(" ");
                    else sb.append(arr[i][j]);
                }
            }
            if(i < info[0]) sb.append("\n");
        }

        bw.append(sb);
        bw.close();
    }
}
