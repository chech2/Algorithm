import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, l;
    static int[] cuttingCnt, knife, ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        knife = new int[m + 2]; // 칼 위치
        cuttingCnt = new int[n]; // 자르는 횟수
        ans = new int[n];

        knife[0] = 0;
        knife[m + 1] = l;
        for (int i = 1; i < m + 1; i++) {
            knife[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            cuttingCnt[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            bw.append(binarySearch(cuttingCnt[i]) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int binarySearch(int cnt){
        int start = 0;
        int end = l;
        int maxValue = 0;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (checkCutting(cnt, mid)) {
                start = mid + 1;
                maxValue = Math.max(maxValue, mid);
            } else {
                end = mid - 1;
            }
        }
        return maxValue;
    }

    public static boolean checkCutting(int cnt, int mid){
        int pre = knife[0];
        for (int i = 1; i < m + 2; i++) {
           if(mid <= knife[i] - pre){
                cnt--;
                pre = knife[i];
            }
        }
        if(cnt < 0) return true;
        return false;
    }
}