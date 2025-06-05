import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr, cw, ccw;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        System.out.println(findMaxLen());
    }

    static int findMaxLen(){
        int answer = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                answer = Math.max(answer, Math.min(cw[j] - cw[i], cw[n] - (cw[j] - cw[i])));
            }
        }
        return answer;
    }

    static void inputSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        cw = new int[n + 1];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            cw[i + 1] += cw[i] + arr[i];
        }
    }
}