import java.io.*;
import java.util.*;

public class Main{

    static int n;
    static Queue<Integer> numbers;
    public static void main(String[] args) throws Exception{
        inputSetting();

        int now;
        while(1 < n){
            for(int i = 0; i < n; i++){
                now = numbers.poll();
                if((i + 1) % 2 == 1) continue;
                
                numbers.add(now);
            }
            n = numbers.size();
        }
        System.out.println(numbers.poll());
    }

    static void inputSetting() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numbers = new ArrayDeque<>();
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i < n + 1; i++) numbers.add(i);
    }
}