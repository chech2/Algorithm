import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, result;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        Arrays.fill(arr, -10001);

        StringTokenizer st = new StringTokenizer(br.readLine());
        result = -10001;
        int num;
        for (int i = 1; i < n + 1; i++) {
            num = Integer.parseInt(st.nextToken());
            arr[i] = Math.max(num, arr[i - 1] + num);

            result = Math.max(arr[i], result);
        }
        System.out.println(result);
    }

}