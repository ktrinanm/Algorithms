// The BigInteger methods are object methods

import java.math.*;
import java.util.*;

public class staticMethods
{
	public static void main(String[] args)
	{
		BigInteger one = BigInteger.ONE;
		BigInteger p, q, n, phi_n, e, d;

		n = randomInteger(300);
		System.out.println(n);

		p = randomPrime(300);
		System.out.println(p);

		q = randomPrime(300);
		System.out.println(q);

		System.out.println("\np*q = " + multiply(p, q));
		System.out.println("gcd(p,n) = " + gcd(p,n));
		System.out.println("Inverse of p mod n = " + inverseModM(p,n));
		System.out.println("p^q mod n = " + modExp(p,q,n));
	}

	// Return a random integer approx. n digits in length
	public static BigInteger randomInteger(int ndigits)
	{
		Random rand = new Random();
		//basically take the log of 10 dividided by the log of 2
		int len = (int)(3.32*(double)ndigits); // length in bits
		return new BigInteger(len, rand); // most will be the avg of 10^n
	}

	// Return a random prime approx. ndigits in length
	public static BigInteger randomPrime(int ndigits)
	{
		BigInteger p = randomInteger(ndigits);
		return p.nextProbablePrime();
	}

	public static BigInteger multiply (BigInteger a, BigInteger b)
	{
		return a.multiply(b);
	}

	public static BigInteger gcd (BigInteger a, BigInteger b)
	{
		return a.gcd(b);
	}

	public static BigInteger inverseModM (BigInteger a, BigInteger m)
	{
		return a.modInverse(m);
	}

	public static BigInteger modExp (BigInteger a, BigInteger b, BigInteger n)
	{
		return a.modPow(b,n);
	}
}
	/*
	 * NOTES:
	 *
	 * 2^10 binary -> decimal digits
	 * log10/log2
	 *
	 * Chance that a number of length 300 is prime -> 1/700
	 *
	 */
