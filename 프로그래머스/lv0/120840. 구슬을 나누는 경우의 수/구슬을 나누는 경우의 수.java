import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Solution {
 public static BigInteger fa(BigInteger n){
		BigInteger result = new BigInteger("1");
		BigInteger one = new BigInteger("1");

		for (int i = 1; i <= n.intValue(); i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
    
	public static int solution(int balls, int share) { //balls중 share
		BigInteger Bigballs = new BigInteger(String.valueOf(balls));
		BigInteger Bigbal_sh = new BigInteger(String.valueOf(balls - share));
		BigInteger Bigshare = new BigInteger(String.valueOf(share));
		
		Bigballs = fa(Bigballs);
		Bigbal_sh = fa(Bigbal_sh);
		Bigshare = fa(Bigshare);
      
		return Bigballs.divide(Bigbal_sh.multiply(Bigshare)).intValue();

	}
}

