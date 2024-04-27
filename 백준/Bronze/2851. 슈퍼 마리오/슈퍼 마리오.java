import java.util.*;
import java.io.*;
public class Main {

    static int result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        System.out.println(input());
    }

    public static int input() throws Exception{
        int now, next;

        for (int i = 0; i < 10; i++) {
            now = Integer.parseInt(br.readLine());
            next = result + now;

            if(100 < next)
                if(Math.abs(100 - result) < Math.abs(100 - next)) return result;
                else return next;

            else if(next == 100) return next;
            result = next;

        }
        return result;
    }
}