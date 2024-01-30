import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, k; // n: 막걸리, k: 인간
    static long[] arr;  // 막걸리 용량 배열
    static long ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        long start = 1, end = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            end = Math.max(end, arr[i]);
        }

        long mid;
        while(start <= end){
            mid = (start + end) / 2;

            // 분배 가능한 경우
            if(isPossible(mid)){
                start = mid + 1;
                ans = Math.max(ans, mid);
            }else{
                end = mid - 1;
            }
        }
        bw.append(ans + " ");
        bw.flush();
        bw.close();
    }

    public static boolean isPossible(long number){
        int tmp = 0;

        for (int i = 0; i < n; i++) tmp += arr[i] / number;
        if(k <= tmp) return true;

        return false;
    }

}