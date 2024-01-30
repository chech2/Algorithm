import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, c;
    static long[] arr;
    static long ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        long start = 1;
        long end = arr[n - 1];
        long mid;

        while(start <= end){
            mid = (start + end) / 2;

            if(isPossible(mid)){
                start = mid + 1;
                ans = mid;
            }else {
                end = mid - 1;
            }
        }
        bw.append(ans + " ");
        bw.flush();
        bw.close();
    }

    public static boolean isPossible(long number){
        int cnt = 1;
        long pre = arr[0];

        for (int i = 1; i < n; i++) {
            if(number <= arr[i] - pre) {
                pre = arr[i];
                cnt++;
            }
        }
        if(c <= cnt) return true;
        return false;
    }
}