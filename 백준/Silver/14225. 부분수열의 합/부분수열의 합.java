import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited = new boolean[2_000_001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combi(0, 0);
        for (int i = 1; i < 2_000_001; i++) {
            if(!visited[i]){
                System.out.println(i);
                break;
            }
        }
    }

    public static void combi(int cnt, int number){
        if(cnt == n){
            visited[number] = true;
            return;
        }
        combi(cnt + 1, number + arr[cnt]);
        combi(cnt + 1, number);
    }
}