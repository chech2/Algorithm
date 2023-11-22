import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> outputStr = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String[] inputStr = br.readLine().split("");
        String[] bomb = br.readLine().split("");
        int bombSize = bomb.length;
        for (int i = 0; i < inputStr.length; i++) {
            String now = inputStr[i];

            outputStr.add(now);
            //폭발 여부 확인
            if (outputStr.size() >= bombSize) {
                int outputStrSize = outputStr.size();
                boolean flag = true;
                for (int j = 0; j < bombSize; j++) {
                    if (!outputStr.get(outputStrSize - j - 1).equals(bomb[bombSize - j - 1])) {
//                        System.out.println(outputStr.get(outputStrSize - j - 1) + " >> " + bomb[bombSize - j - 1]);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bombSize; j++) {
                        outputStr.pop();
                    }
                }
            }
        }
        if (outputStr.size() == 0) {
            System.out.println("FRULA");
        } else {
            int size = outputStr.size();
            for (int i = 0; i < size; i++) {
                sb.append(outputStr.get(i));
            }
            System.out.println(sb);
        }
    }
}