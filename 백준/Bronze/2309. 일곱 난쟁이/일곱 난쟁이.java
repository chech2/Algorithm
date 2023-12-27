import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] visited = new boolean[9];
    static int[] people = new int[9];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(people);
        combi(0, 0);

    }

    public static void combi(int start, int cnt){
        if(cnt == 7){
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                if(visited[i]) sum += people[i];
            }
            if(sum == 100){
                for (int i = 0; i < 9; i++) {
                    if(visited[i]) System.out.println(people[i]);
                }
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            visited[i] = true;
            combi(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}