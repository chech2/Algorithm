import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int T = 0; T < 10; T++) {
			int[] arr = new int [100];
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
            Arrays.sort(arr);
			for (int i = 0; i < cnt; i++) {
				if(arr[99] - arr[0] == 1 || arr[99] - arr[0] == 0) 
					break;
				arr[0]++;
				arr[99]--;
                Arrays.sort(arr);
			}
			System.out.printf("#%d %d\n",T + 1, arr[99] - arr[0]);
		}
	}
	}