import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		
		H += (T / 60);
		M += (T % 60);

		if (M > 59) {
			H++;
			M -= 60;
		}
		if (H > 23)
			H -= 24; //처음에는 0으로 변경해주었는데 만약 H += (T / 60)으로 인해 시간이 24을 초과한다면 오류 발생
        System.out.println(H + " " + M);
	}
}