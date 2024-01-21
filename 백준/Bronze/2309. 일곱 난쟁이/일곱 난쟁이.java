import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    static int[] arr;
    static int sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        int start = 0;
        int end = 8;
        int now = 0;

        while(sum - now != 100){
            now = arr[start] + arr[end];
            if(100 < sum - now){
                start++;
            }else if(sum - now < 100){
                end--;
            }
        }

        for (int i = 0; i < 9; i++) {
            if(start == i || end == i) continue;
            bw.append(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}