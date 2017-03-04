// Wk 6 #8
// Output: list of # of permutations of sizes 1 to 100

import java.math.*;

public class numPermutations
{
	public static void main (String [] args)
	{
		BigInteger n;

		for(int i = 0; i < 100; i++)
		{
			n = new BigInteger("" + (i+1));
			System.out.println(n + "->" + bigFac(n));
		}
	}

	public static BigInteger bigFac(BigInteger n)
	{
		if(n.compareTo(new BigInteger("3")) == -1)
		{
			return n;
		}
		else
		{
			return n.multiply(bigFac(n.subtract(BigInteger.ONE)));
		}
	}
}
