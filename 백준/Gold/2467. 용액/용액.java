import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int[] arr;
    static int ansStart, ansEnd, ans, n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();

        int start = 0;
        int end = n - 1;
        ans = Integer.MAX_VALUE;
        int now;

        while(start < end){
            now = arr[start] + arr[end];

            if(Math.abs(now) < Math.abs(ans)){
                ansStart = start;
                ansEnd = end;
                ans = now;
            }
            if(now == 0) break;

            if(now < 0){
                start++;
            }else if(0 < now){
                end--;
            }
        }
        System.out.println(arr[ansStart] + " " + arr[ansEnd]);
    }
}