import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int [] arr =new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		int max =Arrays.stream(arr).max().getAsInt(); //무슨 것인지 적기!
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			double test  = (((double)arr[i] / max)) * 100.0;
			sum += test;
		}
		System.out.println(sum / N);
	}
	}
