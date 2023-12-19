import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int region, searchRange, roads, result;
    static int[] item;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        region = Integer.parseInt(st.nextToken());
        searchRange = Integer.parseInt(st.nextToken());
        roads = Integer.parseInt(st.nextToken());

        item = new int[region + 1];
        map = new int[region + 1][region + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < region + 1; i++) {
            item[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(map[i], 100);
            map[i][i] = 0;
        }

        int start, end, distance;
        for (int i = 0; i < roads; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            map[start][end] = distance;
            map[end][start] = distance;
        }

        for (int k = 1; k < region + 1; k++) {
            for (int i = 1; i < region + 1; i++) {
                for (int j = 1; j < region + 1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 1; i < region + 1; i++) {
            int sum = 0;
            for (int j = 1; j < region + 1; j++) {
                if(map[i][j] <= searchRange){
                    sum += item[j];
                }
            }
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}