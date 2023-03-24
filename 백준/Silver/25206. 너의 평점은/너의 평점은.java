import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static double num, sum, count;
	static HashMap<String, String> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		map.put("A+", "4.5");
		map.put("A0", "4.0");
		map.put("B+", "3.5");
		map.put("B0", "3.0");
		map.put("C+", "2.5");
		map.put("C0", "2.0");
		map.put("D+", "1.5");
		map.put("D0", "1.0");
		map.put("F", "0.0");
		map.put("P", "0.0");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 20; i++) {
			st.nextToken();
			num = Double.parseDouble(st.nextToken());
			String score = st.nextToken();
			if(!score.equals("P")) {
				count += num;
			}
			sum +=  Double.parseDouble(map.get(score)) * num;
			
			if(i < 19)st = new StringTokenizer(br.readLine());
		}
		System.out.println(sum / count);
	}
	
}