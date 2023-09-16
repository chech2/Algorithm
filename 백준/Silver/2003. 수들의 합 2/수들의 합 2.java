import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, NUM, cnt, start, end, check;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        NUM = Integer.parseInt(st.nextToken());
        end = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        check = arr[start];
        while (true){
            if(check < NUM) {
                end++;
                if(N <= end) break;
                check += arr[end];
            }else if(NUM < check){
                check -= arr[start];
                start++;
            } else if (NUM == check) {
                cnt++;
                start++;
                end = start;
                if(N <= start || N <= end) break;
                check = arr[start];

            }
        }
        System.out.println(cnt);

    }


}