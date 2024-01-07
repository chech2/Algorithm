import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, maxBracket;
    static long result;
    static int[] visited;
    static char[] input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        maxBracket = (getOperCnt() - 1) / 2 + 1; //최대 괄호 개수
        visited = new int[maxBracket];
        result = Long.MIN_VALUE;
        if(N == 1) System.out.println(input[0]);
        else if(N == 3) System.out.println(resultCal(input)); // 연산자가 1개인 경우, 입력 배열 그대로 사용
        else{
            settingBracket();
            System.out.println(result);
        }

    }
    public static void settingBracket(){
        for (int i = 1; i <= maxBracket; i++) {
            combi(0, 0, i);
        }

    }

    public static void makeFormula(int cnt){
        char[] tmp = new char[N + cnt];
        for (int i = 0, j = 0, k = 0; i < tmp.length; i++) {
            if(k == 0 && i == visited[k]){ //괄호 집어넣어야 됨
                tmp[i] = '(';
                if(k < cnt - 1) k++;
            }else if(k != 0 && visited[k] + k < tmp.length - 3 && i == visited[k] + k){
                tmp[i] = '(';
                if(k < cnt - 1) k++;
            }else if (j < N){
                tmp[i] = input[j];
                j++;
            }
        }
        result = Math.max(resultCal(tmp), result);

    }

    public static void combi(int start, int cnt, int stop){

        if(cnt == stop){ // stop개수만큼의 괄호 추가
            return;
        }

        for (int i = start; i < N - 2; i += 2) {
            visited[cnt] = i;
            if(i + 4 < N - 2) combi(i + 4, cnt + 1, stop);
            if(cnt + 1 == stop) makeFormula(stop);
        }

    }


    public static boolean opercheck(char oper){ //연산자인지 확인
        if(oper == '+' || oper == '-' || oper == '/' || oper == '*') return true;
        return false;
    }
    public static int getOperCnt(){ //연산자 개수 세기
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(opercheck(input[i])) ans++;
        }
        return ans;
    }

    public static long cal(char oper, long num1, long num2){

        if(oper == '+') return  num1 + num2;
        else if (oper == '-') return  num1 - num2;
        else if (oper == '*') return  num1 * num2;
        else return  num1 / num2;
    }

    public static long resultCal(char[] tmpFormula){
        long ans = 0;
        for (int i = 0; i < tmpFormula.length - 1; i++) {
            //괄호인 경우
            if(tmpFormula[i] == '(') {
                if(i != 0) {
                    ans = cal(tmpFormula[i - 1], ans, cal(tmpFormula[i + 2], tmpFormula[i + 1] - '0', tmpFormula[i + 3] - '0'));
                }
                // 배열의 제일 처음 인덱스에 괄호가 나온 경우
                else {
                    ans = cal(tmpFormula[i + 2], tmpFormula[i + 1] - '0', tmpFormula[i + 3] - '0');
                }
                i += 3;
            }
            //괄호가 아닌 경우
            else {
                if(i == 0 && !opercheck(tmpFormula[i]))
                    ans = tmpFormula[i] - '0';
                // 지금 인덱스 = 연산자, 다음 인덱스 = 숫자 ==> 바로 연산 가능
                else if(i != tmpFormula.length && tmpFormula[i + 1] != '(' && opercheck(tmpFormula[i]))
                    ans = cal(tmpFormula[i], ans, tmpFormula[i + 1] - '0');
                // 지금 인덱스 = 연산자, 다음 연산자 = 괄호인 경우 ==> 바로 연산 불가능
                else continue;

            }
        }

        return ans;
    }
}