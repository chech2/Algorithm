import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2, n));
    }
}