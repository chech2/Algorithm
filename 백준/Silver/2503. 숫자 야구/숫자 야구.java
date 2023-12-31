import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, result;
    static int[][] inputNum;
    static int[][] inputInfo;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        inputNum = new int[n][3];
        inputInfo = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inputNum[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            inputInfo[i][0] = Integer.parseInt(st.nextToken());
            inputInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        int tmp;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if(i == j) continue;
                for (int k = 1; k < 10; k++) {
                    tmp = 0;
                    if(i == k || j == k) continue;
                    // 나올 수 있는 숫자: ijk, 물어본 숫자: inputNum[l]
                    for (int l = 0; l < n; l++) {
                        tmp += counting(i, j, k, inputNum[l], inputInfo[l]);
                    }
                    if(tmp == n) result++;
                }
            }
        }
        System.out.println(result);

    }

    public static int counting(int hundreds, int tens, int units, int[] compareNum, int[] info){
        int strike = 0;
        int ball = 0;


        // 백의 자리가 같은 경우
        if(hundreds == compareNum[0]) strike++;
        else if(hundreds == compareNum[1]) ball++;
        else if(hundreds == compareNum[2]) ball++;

        if(tens == compareNum[1]) strike++;
        else if(tens == compareNum[0]) ball++;
        else if(tens ==compareNum[2]) ball++;

        if(units == compareNum[2]) strike++;
        else if(units == compareNum[0]) ball++;
        else if(units ==compareNum[1]) ball++;

        if(strike == info[0] && ball == info[1]){
            return 1;
        }
        else return 0;
    }
}