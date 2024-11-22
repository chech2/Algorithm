import java.io.*;
import java.util.*;

public class Main {
    static final int COLOR_SET = 3;
    static int n, answer;
    static int[] bear_color;
    static int[][] colors;
    static StringTokenizer st;
    static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        int size = Math.min(7, n);
        for(int i = 2; i <= size; i++){
            recur(i, 0, 0, 0, 0, 0);
        }
        System.out.println(answer);

    }

    static void recur(int mix_color, int cnt, int start, int r, int g, int b){
        if(mix_color == cnt){
            answer = Math.min(answer, Math.abs(r / mix_color - bear_color[0]) + Math.abs(g / mix_color - bear_color[1]) + Math.abs(b / mix_color- bear_color[2]));
            return;
        }

        for(int i = start; i < n; i++){
            recur(mix_color, cnt + 1, i + 1, r + colors[i][0], g + colors[i][1], b + colors[i][2]);
        }
    }

    static void pre_setting() throws Exception{
        n = Integer.parseInt(br.readLine());
        answer = 255 * 3;
        colors = new int[n][COLOR_SET];
        bear_color = new int[COLOR_SET];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < COLOR_SET; j++){
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < COLOR_SET; j++){
            bear_color[j] = Integer.parseInt(st.nextToken());
        }
    }

}