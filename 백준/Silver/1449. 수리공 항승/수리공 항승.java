import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
	
		int hole = sc.nextInt();
		int tape = sc.nextInt();
		int num = 0;
		int holes [] = new int [1001];
		
		for (int i = 0; i < hole; i++) {
			holes[sc.nextInt()] = 1;
		}
		
		for (int i = 0; i < 1001; i++) {
			if(holes[i] == 1) {
				num++;
				for (int j = i; j < i + tape && j < 1001; j++) {
					holes[j] = 0;

				}
			}		
		}
	System.out.println(num);
	}
}