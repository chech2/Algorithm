import java.io.*;

public class Main {

    static int n, sum;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        System.out.println(findMaxLen());
    }

    static int findMaxLen(){
        int answer = -1;
        int r, l, min, now;
        r = 0;
        l = 0;
        now = arr[0];

        while(l <= r && r < n){
            min = Math.min(now, sum - now);
            answer = Math.max(min, answer);

            if(min == now) now += arr[++r];
            else now -= arr[l++];
        }
        return answer;
    }

    static void inputSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
    }
}