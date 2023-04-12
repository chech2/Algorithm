import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean visited[];
    static int N, result;
    static char str[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            visited = new boolean[26];
            str = br.readLine().toCharArray();
            result += cnt(str);
        }
        System.out.println(result);

    }

    private static int cnt(char[] str) {
        int now;
        int pre = -1;
        for (int i = 0; i < str.length; i++) {
            now = str[i] - 97;
            if(visited[now] && pre != now)
                return 0;
            if(!visited[now])
                visited[now] = true;
            pre = now;
        }
        return 1;
    }
}