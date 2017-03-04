// Verifies Fermat's theorem that a in Zp*, where p is prime, a^(p-1) is congruent
// to 1 mod p

import java.util.*;

public class verifyFermat
{
	public static void main(String [] args)
	{
		int p = Integer.parseInt(args[0]);

		ArrayList<Integer> units = new ArrayList<Integer>();

		for(int i = 1; i < p; i++)
		{
			if(gcd(i, p) == 1)
			{
				units.add(i);
			}
		}

		for(Integer a: units)
		{
			long congruence = (long)Math.pow(a, p-1);
			System.out.println(a + "^(" + (p-1) + ") -> " + congruence
					+ " mod " + p + " -> " + congruence%p);
		}
	}
	 
	public static int gcd(int n, int m)
	{
		if( m == 0)
		{
			return n;
		}
		else 
		{
			return gcd(m, n%m);
		}
	}
}
