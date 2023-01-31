import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] arr = new int[10];
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			set.add(Integer.parseInt(br.readLine()) % 42);
		}
		System.out.println(set.size());
	}

}
