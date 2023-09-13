import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, start, end, NUM, cnt;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        end = N - 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        NUM = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        while(true){
            if(end <= start) break;
            if(arr[start] + arr[end] == NUM){
                cnt++;
                start++;
            }else if(arr[start] + arr[end] < NUM) start++;
            else if(NUM < arr[start] + arr[end]) end--;
        }
        System.out.println(cnt);



    }

}