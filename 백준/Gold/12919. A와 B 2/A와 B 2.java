import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int result;

    static Queue<String> input = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmpS = br.readLine();
        String tmpT = br.readLine();
        input.offer(tmpT);

        while (!input.isEmpty()){
            String now = input.poll();

            int size = now.length();
            if(size == tmpS.length()){
                if(now.equals(tmpS)){
                    result = 1;
                    break;
                }
                else continue;
            }
            if(now.charAt(0) == 'B'){
                StringBuilder tmp = new StringBuilder(now.substring(1));
                input.offer(tmp.reverse().toString());
            }
            if(now.charAt(size - 1) == 'A'){
                input.offer(now.substring(0, size - 1));
            }
        }
        System.out.println(result);
    }
}