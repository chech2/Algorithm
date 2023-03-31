import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int [] arr, memo;
    static int TC, N, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            memo = new int[N];
            st = new StringTokenizer(br.readLine());
            Arrays.fill(memo, 1);
            result = 1;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp();
            
//            System.out.println(Arrays.toString(memo));
            System.out.println(result);
        


    }

    static void dp (){

        for (int i = 1; i < N; i++) {

            for (int j = 0; j < i; j++) {

                //앞에보다 큰 수이면
                if(arr[j] < arr[i]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                    result = Math.max(result, memo[i]);
                }
            }
        }
    }

}