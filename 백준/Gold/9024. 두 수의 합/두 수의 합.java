import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int[] s;
    static int k, n, T;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        testCase();
        for (int t = 0; t < T; t++) {
            setting();
            binarySearch();
        }
        System.out.println(sb);
    }

    public static void binarySearch(){
        int start = 0;
        int end = n - 1;
        int value = Integer.MAX_VALUE;
        int cnt = 0;
        int now;

        while(start < end){
            now = (s[start] + s[end]);

            if(Math.abs(now - k) < value){
                value = Math.abs(now - k);
                cnt = 1;
            }else if(Math.abs(now - k) == value){
                cnt++;
            }

            if(now < k) start++;
            else end--;
        }
        sb.append(cnt).append("\n");
    }


    public static void setting() throws Exception {
        strToken();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = new int[n];

        strToken();
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);
    }
    public static void testCase() throws Exception {
        strToken();
        T = Integer.parseInt(st.nextToken());
    }

    public static void strToken() throws Exception {
        st = new StringTokenizer(br.readLine());
    }
}