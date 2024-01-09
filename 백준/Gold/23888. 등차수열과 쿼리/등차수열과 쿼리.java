import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;
public class Main {
    static long a, d, gcdNum;
    static int queryCnt, maxIdx;
    static long[] arr, sum;
    static int[][] input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken()); // 초항
        d = Long.parseLong(st.nextToken()); // 공차
        queryCnt = Integer.parseInt(br.readLine()); //쿼리 개수
        input = new int[queryCnt][3]; // 연산 종류, 시작항, 끝항

        for (int i = 0; i < queryCnt; i++) {
            input[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
            maxIdx = Math.max(input[i][2], maxIdx);
        }

        arr = new long[maxIdx + 1]; // 등차수열 배열
        sum = new long[maxIdx + 1]; // 등차수열의 합 배열

        prefix(); // 등차수열과 등차수열의 합 배열 만들기
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(sum));

        gcdNum = gcd2();
        int start, end;
        for (int i = 0; i < queryCnt; i++) {
            start = input[i][1];
            end = input[i][2];

            if(input[i][0] == 1) {  // 수열의 합 구하기
                if(start == 0){
                    bw.write(sum[end] + "\n");
                }
                else{
                    bw.write((sum[end] - sum[start - 1]) + "\n");
                }
            }

            else {  // 수열에서 최대 공약수 찾기
                if(start == end) {
                    bw.write(arr[start] + "\n");
                }
                else {
                    bw.write(gcdNum + "\n");
                }
            }

        }
        bw.flush();
        bw.close();
    }

    public static void prefix(){
        arr[1] = a;
        sum[1] = a;
        for (int i = 2; i < maxIdx + 1; i++){
            arr[i] = arr[i - 1] + d;
            sum[i] = arr[i];
        }
        for (int i = 1; i < maxIdx + 1; i++) sum[i] += sum[i - 1];
    }

    public static long gcd(){
        long big = Math.max(a, d);
        long small = Math.min(a, d);

        // 큰 수를 작은 수로 모듈러
        long tmp;
        if(small == 0) return 0;
        while(big % small != 0) {
            tmp = big % small;
            big = small;
            small = tmp;
            if(small == 0) return big;
        }

        return small;
    }

    public static long gcd2(){
        long tmp;
        while(d != 0){
            tmp = a % d;
            a = d;
            d = tmp;

        }
        return a;
    }


}