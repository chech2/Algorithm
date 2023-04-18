import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int ansMAX, ansMIN, N;
    static int[] number, operator, selected;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        selected = new int[N - 1];
        operator = new int[N - 1];
        visited = new boolean[N - 1];
        ansMAX = Integer.MIN_VALUE;
        ansMIN = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            number[i] = Integer.parseInt(st.nextToken());

        int size = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int now = Integer.parseInt(st.nextToken());
            for (int j = size; j < size + now; j++) {
                operator[j] = i;
            }
            size += now;
        }
        perm(0);
        System.out.println(ansMAX);
        System.out.println(ansMIN);
    }

    static void perm(int cnt){
        if(cnt == N - 1){
            int tmp =calculator();
            ansMAX = Math.max(ansMAX, tmp);
            ansMIN = Math.min(ansMIN, tmp);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            selected[cnt] = operator[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    static int calculator(){
        int result = number[0];
        int operat;
        for (int i = 0; i < N - 1; i++) {
            operat = selected[i];
            if(operat == 0){
                result += number[i + 1];
            }else if (operat == 1) {
                result -= number[i + 1];
            }else if (operat == 2) {
                result *= number[i + 1];
            }else{
                result /= number[i + 1];
            }
        }
        return result;
    }
}