// Fast Modular Exponentiation with BigIntegers
//
// computes a^b mod n

import java.math.*;
import java.util.*;

public class bigIntFastModExp
{
	public static void main(String [] args)
	{
		for(int i = 0; i < 5; i++)
		{
			long start = System.currentTimeMillis();
			Random randGen = new Random();
			BigInteger a = new BigInteger(1024, randGen);
			BigInteger b = new BigInteger(1024, randGen);
			BigInteger n = new BigInteger(1024, randGen);

			System.out.println(a + "^" + b + " mod " + n);
			System.out.println("\t" + fastMod(a,b,n));
			long end = System.currentTimeMillis();
			System.out.println("\tTook " + (end-start) + " ms.");
		}
	}

	public static BigInteger fastMod(BigInteger a, BigInteger b, BigInteger n)
	{
		BigInteger d = BigInteger.ONE;
		String bin = b.toString(2);

		for(int i = 0; i < bin.length(); i++)
		{
			d = (d.multiply(d)).mod(n);
			if(bin.charAt(i) == '1')
			{
				d = (d.multiply(a)).mod(n);
			}
		}

		if(d.compareTo(new BigInteger("0")) == -1)
		{
			d = d.add(n);
		}

		return d;
	}
}
