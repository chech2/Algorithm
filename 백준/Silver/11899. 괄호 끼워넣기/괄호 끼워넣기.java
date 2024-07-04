import java.io.*;
import java.util.*;
public class Main {
    static String[] inputString;
    static Stack<String> stack = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        game();
    }

    public static void game(){
        stack.add(inputString[0]);

        for (int i = 1; i < inputString.length; i++) {
            if(!stack.isEmpty() && stack.peek().equals("(") && inputString[i].equals(")")) stack.pop();
            else {
                stack.add(inputString[i]);
            }
        }

        System.out.println(stack.size());
    }

    public static void input() throws Exception{
        inputString = br.readLine().split("");
    }

}