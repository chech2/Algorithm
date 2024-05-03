import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r, x, ans;
    static int[] number;
    static boolean[] visited;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        subset(0, 0, 0);
        System.out.println(ans);
    }

    public static void subset(int cnt, int select, long num){
        if(cnt == n){
            if(2 <= select){
                if(l <= num && num <= r){
                        int minVal = 2000000000;
                        int maxVal = -1;

                    for (int i = 0; i < n; i++) {
                        if(visited[i]){
                            minVal = Math.min(minVal, number[i]);
                            maxVal = Math.max(maxVal, number[i]);
                        }
                    }
                    if(x <= maxVal - minVal) ans++;
                }
            }
            return;
        }
        visited[cnt] = true;
        subset(cnt + 1, select + 1, num + number[cnt]);
        visited[cnt] = false;
        subset(cnt + 1, select, num);
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        number = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);
    }
}