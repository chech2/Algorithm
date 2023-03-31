import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [] arr, memo;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new int[N];
        st = new StringTokenizer(br.readLine());
        Arrays.fill(memo, -1);

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int memoIdx = 0;
        for (int i = 0; i < N; i++) {
            int idx = Arrays.binarySearch(memo, 0, memoIdx, arr[i]);
            if(idx < 0) idx = Math.abs(idx) - 1;
            if(idx == memoIdx) memoIdx++;
            memo[idx] = arr[i];
        }
        System.out.println(memoIdx);

        }

}