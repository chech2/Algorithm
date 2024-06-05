import java.io.*;
import java.util.*;
public class Main {
    static int n, k;
    static int[] map, sensor;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(buildBaseStation());
    }

    public static int buildBaseStation() {
        if(n <= k) return 0;
        int ans = 0;

        sensor = new int[n - 1];
        for (int i = 0; i < n - 1; i++) sensor[i] = map[i + 1] - map[i];
        Arrays.sort(sensor);

        for (int i = 0; i < n - k; i++) ans += sensor[i];
        return ans;
    }


    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) map[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(map);
    }

}