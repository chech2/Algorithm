import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int tmp[] = new int[4];
		tmp[3] = B;
		for (int i = 2; -1 < i; i--) {
			tmp[i] = B % 10;
			B /= 10;
			System.out.println(A * tmp[i]);
		}
		System.out.println(A * tmp[3]);}}