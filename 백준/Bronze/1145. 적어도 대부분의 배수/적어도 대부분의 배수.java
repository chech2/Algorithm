import java.util.*;
import java.io.*;
public class Main {
    static int ans, maxv, minv;
    static int[] arr;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        tmp();
        System.out.println(ans);
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        maxv = arr[2] * arr[3] * arr[4];
        minv = arr[0];
    }

    public static void tmp(){
        int cnt;
        for (int i = minv; i <= maxv; i++) {
            cnt = 0;
            for (int j = 0; j < 5; j++) {
                if(i % arr[j] == 0) cnt++;
            }
            if(2 < cnt) {
                ans = i;
                break;
            }
        }
    }
}