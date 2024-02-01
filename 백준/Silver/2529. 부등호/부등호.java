import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long maxValue, minValue;
    static char[] sign;
    static int[] selected;
    static boolean[] visited;
    static HashMap<Long, String> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        sign = new char[n];
        selected = new int[n + 1];
        visited = new boolean[10];
        maxValue = -1;
        minValue = 10000000000L;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            selected[0] = i;
            selectNumber(1, i, String.valueOf(i));
            visited[i] = false;
        }
        System.out.println(map.get(maxValue));
        System.out.println(map.get(minValue));


    }
    public static void selectNumber(int cnt, long num, String number){
        if(cnt == n + 1){
            map.put(num, number);
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            return;
        }

        if (sign[cnt - 1] == '<') {
            for (int i = selected[cnt - 1]; i < 10; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                selected[cnt] = i;
                selectNumber(cnt + 1, num * 10 + i, number + i);
                visited[i] = false;
            }
        }else{
            for (int i = 0; i < selected[cnt - 1]; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                selected[cnt] = i;
                selectNumber(cnt + 1, num * 10 + i, number + i);
                visited[i] = false;
            }
        }

    }
}