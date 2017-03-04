// Big integer version of the fast pseudoprime test

import java.math.*;
import java.util.*;

public class bigIntPseudoPrime
{
	public static void main(String [] args)
	{
		Random r = new Random();
		BigInteger one = BigInteger.ONE;
		BigInteger two = one.add(one);
		BigInteger a = new BigInteger(100, r);

		BigInteger mod = two.modPow(a.subtract(one), a);

		if(mod.compareTo(one) == 0)
		{
			System.out.println(a + " is probably prime!!!");
		}
		else
		{
			System.out.println(a + " is probably not prime...");
		}
	}
}
