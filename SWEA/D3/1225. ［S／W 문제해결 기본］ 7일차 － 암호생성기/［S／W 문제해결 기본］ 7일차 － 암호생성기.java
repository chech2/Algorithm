import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++){
			Queue<Integer> q = new ArrayDeque<>();
			sc.nextInt();
			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}

			int tmp;
			int cnt = 1;
			while(true) {
				tmp = q.poll();
				tmp -= cnt++;
				if(tmp <= 0) {
					q.offer(0);
					break;
				}
				if(cnt == 6) cnt = 1;
				q.offer(tmp);
			}
			System.out.printf("#%d ", t);
			for (int i = 0; i < 8; i++) {
				System.out.printf("%d ",q.poll());
			}
			System.out.println();
			
		}
		
	}

}