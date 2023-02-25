import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//cPl 구하기
public class Main {
    static int L;
    static int C;
    static char input[];
    static char result[];
    static StringBuilder sb = new StringBuilder();
    static char[] Vowel = {'a','e','i','o','u'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); //완성된 문자열의 길이
        C = Integer.parseInt(st.nextToken()); //주어지는 문자열의 개수
        input = new char[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);

        perm(0, 0);
        System.out.print(sb);
    }

    private static boolean check() {
        int ConsonantNum = 0; //자음 2이상
        int VowelNum = 0;  //모음 1이상

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < 5; j++) {
                if (Vowel[j] == result[i]) {
                    VowelNum++; //모음인 경우 ++
                    break;
                } else if (j == 4)//4까지 왔는데 아직도 for문이 안끝났다 == 모음 아니다
                    ConsonantNum++;
            }
        }
        if (VowelNum < 1 || ConsonantNum < 2) return false;
        return true;
    }

    private static void perm(int cnt, int flag) {
        if(cnt == L) {
            if(!check()) return;
            for (int i = 0; i < L; i++){
                sb.append(result[i]);
//                    if(result[i - 1] - '0' > result[i] - '0') return;
            }
            sb.append("\n");
//                System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < C; i++){
            if((flag & (1 << i)) != 0) continue;
            if(cnt != 0 && result[cnt - 1] > input[i]) continue;
            result[cnt] = input[i];
            perm(cnt + 1, flag | (1 << i));

        }

    }
}