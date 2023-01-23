import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int NewN =  (N % 10)*10 + ((N / 10) + (N % 10)) % 10 ;
	int tens;
	int units;
	int cnt = 1;
	while (N != NewN)
	{
		tens = NewN / 10;
		units = NewN % 10;
		NewN = units * 10 + (tens + units) % 10 ;
		cnt++;
	}
	System.out.println(cnt);
	}
}
