import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, ans, resent;
    static long x;
    static long[] input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Long.parseLong(st.nextToken());
        input = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Long.parseLong(st.nextToken());
            if(input[i] == x) ans++;

        }
        resent = n - ans;
        Arrays.sort(input);

        int start = 0;
        int end = resent - 1;
        while(start < end){
            if(x / 2.0 <= input[start] + input[end]){
                ans++;
                resent -= 2;
                start++;
                end--;
            }else{
                start++;
            }
        }
        System.out.println(ans + (resent / 3));
    }
}