import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static HashMap<Integer, String> map = new HashMap<>();
    static int result;
    public static void main(String[] args) throws Exception{
        map.put(1, "c=");
        map.put(2, "c-");
        map.put(3, "dz=");
        map.put(4, "d-");
        map.put(5, "lj");
        map.put(6, "nj");
        map.put(7, "s=");
        map.put(8, "z=");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = str.length();

        for (int i = 0; i < num; i = i + 2) {
            boolean  check = false;
            if(i + 1 < num & !check) {
                String tmp = Character.toString(str.charAt(i)) + Character.toString(str.charAt(i + 1));
                check = loop(tmp);
//                System.out.println(" 현재 문자: "+tmp +" i: "+ i  + " "+check);

            }
            if(i + 2 < num & !check) {
                String tmp2 = Character.toString(str.charAt(i)) + Character.toString(str.charAt(i + 1)) + Character.toString(str.charAt(i + 2));
                check = loop(tmp2);
                if(check){
                    i++;
                    continue;
                }
            }
            if(!check) {
                result++;
                i--;
            }

        }
        System.out.println(result);
    }

    public static boolean loop(String tmp) {
        for (String val : map.values()) {
            if(val.equals(tmp)) {
                result++;
                return true;
            }
        }
        return false;
    }

}