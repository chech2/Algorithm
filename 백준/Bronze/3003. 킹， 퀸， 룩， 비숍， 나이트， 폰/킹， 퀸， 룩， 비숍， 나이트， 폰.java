
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] standard = {1 ,1, 2, 2, 2, 8};
		for (int i = 0; i < standard.length; i++) {
			System.out.println(standard[i] - sc.nextInt());
		}
		
	}

}
