import java.io.*;
import java.util.*;

public class Main {
    static final Character ONE = '1';
    static final Character TWO = '2';
    static final Character ZERO = '0';

    public static void main(String[] args) throws Exception{
        char[] origin = inputSetting();
        ArrayList<Character> list = removeZeroAndOneHalf(origin);
        System.out.println(makingNewStr(list));
    }
    
    private static ArrayList<Character> removeZeroAndOneHalf(char[] origin){
        ArrayList<Character> list = new ArrayList<>();

        int zero = 0;
        int one = 0;
        for (int i = 0; i < origin.length; i++) {
            if(origin[i] == ONE){
                one++;
            } else {
                zero++;
            }
            list.add(origin[i]);
        }
        one /= 2;
        zero /= 2;
        for (int i = list.size() - 1; 0 <= i; i--) {
            if(0 < zero && list.get(i) == ZERO){
                list.set(i, TWO);
                zero--;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if(0 < one && list.get(i) == ONE){
                list.set(i, TWO);
                one--;
            }
        }
        return list;
    }
    
    private static String makingNewStr(ArrayList<Character> list ){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != TWO){
                sb.append(list.get(i));
            }
        }
        
        return sb.toString();
    }
    
    private static char[] inputSetting() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine().toCharArray();
    }
}
