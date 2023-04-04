import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String[] in;
    static int[] number, addoperator, suboperator;
    static int result;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine().split("-");

        sum();
        sub();
    }
    static void sum(){
        number = new int[in.length];

        boolean flag = false;
        for (int i = 0; i < in.length; i++) {
            int tmp1 = 0;
            int tmp2 = 0;
            for (int j = 0; j < in[i].length(); j++) {
                if(in[i].charAt(j) != '+'){
                    if(!flag)
                        tmp1 = tmp1 * 10 + in[i].charAt(j) - '0';
                    if(flag)
                        tmp2 = tmp2 * 10 + in[i].charAt(j) - '0';
                }else if(in[i].charAt(j) == '+') {
                    if (flag) {
                        tmp1 += tmp2;
                        tmp2 = 0;
                        flag = false;
                    }
                    flag = true;
                }
            }
            number[i] = tmp1 + tmp2;
        }
    }

    static void sub(){
        int result = 0;
        for (int i = 0; i < number.length ; i++) {
            if(i == 0)
                result += number[i];
            else
                result -= number[i];
        }
        System.out.println(result);

    }
}