import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if(input[0] * i + input[1] * j == input[2] && input[3] * i + input[4] * j == input[5]){
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }
    }
}