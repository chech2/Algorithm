import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        char[] s = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());

        System.out.println(s[n - 1]);
    }
}