import java.io.*;
import java.util.*;

public class Main {
    static int h, w, x, y;
    static int[][] A, B;
    public static void main(String[] args) throws Exception {
        preSetting();
        findOriginArr();
    }

    static void findOriginArr(){
        int[][] origin = new int[h][w];

        for(int i = 0; i < x; i++){
            for(int j = 0; j < w; j++){
                origin[i][j] = B[i][j];
            }
        }
        for(int i = 0; i < h; i++){
            for(int j = 0; j < y; j++){
                origin[i][j] = B[i][j];
            }
        }
        for(int i = x; i < h; i++){
            for(int j = y; j < w; j++){
                origin[i][j] = B[i][j] - origin[i - x][j - y];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                sb.append(origin[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void preSetting() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        B = new int[h + x][w + y];
        for(int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
