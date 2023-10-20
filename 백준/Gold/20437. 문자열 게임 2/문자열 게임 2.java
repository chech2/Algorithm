import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T, K, Minimum, Maximum;
    static char[] input;
    static int[]strAnalysisArr = new int[26];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input = br.readLine().toCharArray();
            K = Integer.parseInt(br.readLine());

            if(K == 1){
                System.out.println(1 + " " + 1);
                continue;
            }
            //입력 문자열 분석
            strAnalysis();
            find();

            if(Maximum == -1 || Minimum == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(Minimum + " " + Maximum);
        }

    }

    public static void find(){
        int startIdx;
        Minimum = Integer.MAX_VALUE;
        Maximum = -1;

        for (int start = 0; start < input.length; start++) {
            startIdx = input[start] - 'a';

            //전체 입력 문자의 개수가 K보다 작으면 더 볼 이유가 없음
            if(strAnalysisArr[startIdx] < K) continue;

            int cnt = 1;
            for (int end = start + 1; end < input.length; end++) {
                if(input[start] == input[end]) cnt++;
                if(cnt == K){
                    Minimum = Math.min(Minimum, end - start + 1);
                    Maximum = Math.max(Maximum, end - start + 1);
                    break;
                }
            }
        }

    }

    //문자열 분석 함수
    public static void strAnalysis(){
        Arrays.fill(strAnalysisArr, 0);
        for (int i = 0; i < input.length; i++) {
            int idx = input[i] - 'a';
            strAnalysisArr[idx]++;
        }
    }
}