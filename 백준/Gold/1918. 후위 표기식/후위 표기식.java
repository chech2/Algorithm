import java.util.Scanner;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<String> operator = new Stack<>();
    static String[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.next().split("");

        for (int i = 0; i < input.length; i++) {
            String now = input[i];
            //연산자가 아닌 경우
            if(!(now.equals("+") || now.equals("-") || now.equals("*") || now.equals("/") || now.equals("(") || now.equals(")"))){
                sb.append(now);
            }
            //연산자인 경우
            else{
                if(operator.isEmpty()) operator.add(now);
                else{
                    if(now.equals(")")){
                        while (!operator.peek().equals("(")){
                            sb.append(operator.pop());
                        }
                        operator.pop();
                    }
                    else{
                        //앞의 연산자가 지금 연산자보다 큰 값이 아닐 때까지 출력
                        while(!operator.isEmpty() && priority(operator.peek()) != 2 &&  priority(operator.peek()) >= priority(now)){
                            sb.append(operator.pop());
                        }
                        operator.add(now);
                    }
                }
            }
        }

        while(!operator.isEmpty()){
            sb.append(operator.pop());
        }
        System.out.println(sb);
    }

    public static int priority(String now){
        if(now.equals("(")) return 2;
        else if(now.equals("*") || now.equals("/")) return 1;
        return 0;
    }

}