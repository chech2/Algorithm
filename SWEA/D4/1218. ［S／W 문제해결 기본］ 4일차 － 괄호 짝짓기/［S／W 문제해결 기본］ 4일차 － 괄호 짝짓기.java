import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Stack<String> stk = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int tclen = sc.nextInt();
			int result = 1;
			String[] now =  sc.next().split("");
			for (int i = 0; i < tclen; i++) {
				switch (now[i]) {
					case ")": 
						if(!stk.pop().equals("("))
							result = 0;
						break;
					case "]": 
						if(!stk.pop().equals("["))
							result = 0;
						break;
					case "}":
						if(!stk.pop().equals("{"))
							result = 0;
						break;
					case ">": 
						if(!stk.pop().equals("<"))
							result = 0;
						break;
					default:
						stk.push(now[i]);
				}
				if(result == 0) 
					break;
			}
			System.out.printf("#%d %d\n", t, result);
			
			
		}
		
		
		
	}

}