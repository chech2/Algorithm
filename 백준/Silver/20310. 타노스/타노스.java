import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        char[] origin = inputSetting();
        String[] halfRemove = removeZeroAndOneHalf(origin);
        Arrays.sort(halfRemove);

        System.out.println(String.join("", halfRemove));
    }

    private static String[] removeZeroAndOneHalf(char[] origin){
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < origin.length; i++) {
            if(map.containsKey(origin[i])) map.put(origin[i], map.get(origin[i]) + 1);
            else map.put(origin[i], 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getKey() == '0' || entry.getKey() == '1') entry.setValue(entry.getValue() / 2);

            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString().split("");
    }

    private static char[] inputSetting() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine().toCharArray();
    }
}
