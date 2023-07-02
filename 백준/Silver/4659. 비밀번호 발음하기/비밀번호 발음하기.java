import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int start, consonant, vowel;
    static boolean vowelcontain;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String str = br.readLine();
            char[] input = str.toCharArray();

            //종료조건
            if(str.equals("end")) break;

            start = 0;
            consonant = 0;
            vowel = 0;
            vowelcontain = false;

            if(isvowel(input[0])){
                vowel++;
                vowelcontain = true;
            }else consonant++;

            for (int i = 1; i < input.length; i++) {
                char now = input[i];


                //같은 글자가 연속으로 오는 경우의 수
                if((input[i - 1] == now && now != 'e') && (input[i - 1] == now && now != 'o')){
                    vowelcontain = false;
//                    System.out.println("여기?? " + now +" " + input[i - 1] + " " + (now != 'e') + " " + (now != 'o'));
                    break;
                }

                //3개 연속 모음 || 자음인지 확인 시작
                if(isvowel(now)){
                    vowel++;
                    vowelcontain = true;
                }else consonant++;


                if(i >= 3){
                    if(isvowel(input[start])) vowel--;
                    else consonant--;
                    start++;
                }
                if(vowel >= 3 || consonant >= 3){
//                    print(str, false);
                    vowelcontain = false;
//                    System.out.println("여기?? " + input[i- 2] + input[i - 1] + input[i]);
//                    System.out.println("여기?? " + input[start] + input[start + 1] + input[start + 2]);
                    break;
                }

//                System.out.println(i+"번: " + " " + now + " "  + vowel +" " + consonant + " start: " + input[start]);
            }

            if(!vowelcontain) print(str, false);
            else print(str, true);

        }
    }

    static boolean isvowel(char now){
        if(now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u'){
            return true;
        }
        return false;
    }

    static void print(String now, boolean ans){
        if(ans)
            System.out.println("<" + now + "> is acceptable.");
        else
            System.out.println("<" + now + "> is not acceptable.");
    }
}