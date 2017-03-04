// Simulates the Rabin Miller process by:
// 	A. Generate BigInt n (approx 1024 bits). If even, add 1.
// 	B. Test n using fast pseudoprime test (2^(n-1)%n). If composite, add 2. repeat.
// 	C. Generate a random BigInt a (approx 1024 bits) less than n.
// 	D. Verify it is coprime to n. (Find gcd, if 1, coprime)
// 	E. Repeat until you get a number that passes the coprime test 100x.

import java.util.*;
import java.math.*;

public class rabinmiller
{
	public static void main(String [] args)
	{
		Random r = new Random();
		BigInteger one = BigInteger.ONE;
		BigInteger two = one.add(one);
		boolean notComposite = false;
		BigInteger n = new BigInteger("0");
		int j = 1;

		while(!notComposite)
		{
			//Step A
			n = new BigInteger(1024, r);

			if((n.mod(two)).compareTo(new BigInteger(0+"")) == 0)
			{
				n = n.add(one);	// if it's even, we know it's not prime, so add 1
			}

			//Step B
			while((fastPseudoPrimeTest(two, n.subtract(one), n)).compareTo(one) != 0)
			{
				n = n.add(two);
			}

			//Step C
			BigInteger a = new BigInteger(1024, r);

			while(a.compareTo(n) != -1)
			{
				a = a.divide(two);
			}

			int i = 0;
			notComposite = true;

			//Steps D and E
			while(notComposite && i < 100)
			{
				if(a.gcd(n).compareTo(one) != 0)
				{
					notComposite = false;
				}
				i++;
			}
		}
		System.out.println(n + "\tis probably prime.");
		System.out.println("n.isProbablePrime = " + (n.isProbablePrime(100) ? "true!" : "false.. :("));

		System.out.println("n's length: " + n.toString().length());
	}

	public static BigInteger fastPseudoPrimeTest (BigInteger a, BigInteger b, BigInteger n)
	{
		return a.modPow(b,n);
	}
}
