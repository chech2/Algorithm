import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static char[][] arr = new char[5][15];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char tmp[] = br.readLine().toCharArray();
            int size = tmp.length;
            for (int j = 0; j < size; j++) arr[i][j] = tmp[j];
            for (int j = size; j < 15; j++) arr[i][j] = '>';
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if(arr[j][i] == '>') continue;
                sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);
    }

}