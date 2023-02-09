
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int total = 0;
		
		char[] arr =  sc.next().toCharArray();
		for (int i = 0; i < N; i++) {
			if(arr[i]=='P') {
			int start =Math.max(i - M, 0);
			int end =Math.min(i + M, N - 1);
			for (int j = start; j <= end; j++) {
				if(arr[j] == 'H') {
					total++;
					arr[j] = 0;
					break;
				}
			}
		}}
		System.out.println(total);

	}

}