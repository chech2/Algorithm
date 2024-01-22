import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, b, result; // 횡단보도 개수, 원하는 비교 답, 고장난 신호등의 개수
    static boolean[] isBroken; // 신호등의 고장 여부
    static int [] fixCnt, lightOn; //수리해야 하는 신호등의 개수
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        lightOn = new int[n + 1];
        fixCnt = new int[n + 1];
        isBroken = new boolean[n + 1];
        result = 100001;

        for (int i = 0; i < b; i++) {
            isBroken[Integer.parseInt(br.readLine())] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            if(isBroken[i]){
                fixCnt[i] = fixCnt[i - 1] + 1;
                lightOn[i] = lightOn[i - 1];
            }else {
                lightOn[i] = lightOn[i - 1] + 1;
                fixCnt[i] = fixCnt[i - 1];
            }
        }

        int start = 0;
        int end = k;
        int fix;
        while(end < n + 1){
            fix = fixCnt[end] - fixCnt[start];
            result = Math.min(result, fix);
            start++;
            end++;
        }
        System.out.println(result);
    }

}