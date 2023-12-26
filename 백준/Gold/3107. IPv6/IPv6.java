import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] arr = new char[8][4];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = inputStrSetting(br.readLine().split(":"));


        int size;
        int i = 0;
        char [] nowToChar;
        for(String now: inputStr){
            size = 4 - now.length();
            for (int j = 0; j < size; j++) {
                arr[i][j] = '0';
            }
            nowToChar = now.toCharArray();
            for (char tmp : nowToChar){
                arr[i][size] = tmp;
                size++;
            }
            i++;
        }

        StringBuilder sb = print();
        System.out.println(sb);
    }


    public static String[] inputStrSetting(String[] input){
        String[] output = new String[8];

        Arrays.fill(output, "");
        if(input.length == 0) return output;
        //제일 앞쪽에 ::이 존재하는 경우
        if (input[0].equals("")) {
            for (int i = input.length - 1, j = 7; 1 < i ; i--, j--) {
                output[j] = input[i];
            }
        }
        //중간에 ::이 존재하는 경우
        else if(Arrays.stream(input).anyMatch(s -> s.equals(""))){
            int i = 0;
            // 0인 구간의 개수: 8 - input.length
            for (String now : input) {
                if(now.equals("")){
                    i += 8 - input.length + 1;
                }else {
                    output[i] = now;
                    i++;
                }
            }
        }
        else{
            for (int i = 0; i < input.length; i++) output[i] = input[i];
        }
        return output;
    }
    public static StringBuilder print(){
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 4; k++) {
                sb.append(arr[j][k]);
            }
            if(j != 7) sb.append(":");
        }
        return sb;
    }


}