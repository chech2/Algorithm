import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

    static int right, left, high, width, ans;
    static int[] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        high = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = Stream.of(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        for (int now = 1; now < map.length - 1; now++) {
          right = 0;
          left = 0;

            for (int i = 0; i < now; i++) {
                left = Math.max(map[i], left);
            }
            for (int i = now + 1; i < map.length; i++) {
                right = Math.max(map[i], right);
            }
            if(map[now] < right && map[now] < left){
                ans += Math.min(right, left) - map[now];
            }
        }
        System.out.println(ans);
    }

}