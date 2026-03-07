import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] pollution = br.readLine().toCharArray();

        System.out.println(findOrigin(pollution));
    }

    private static int findOrigin(char[] pollution){
        int origin = 0;
        int digit = 0;

        while(origin++ <= 30000){
            String originStr = Integer.toString(origin);

            for(int i = 0; i < originStr.length(); i++){
                if(pollution[digit] == originStr.charAt(i)) digit++;
                if(digit == pollution.length) return origin;
            }
        }
        return origin;
    }
}