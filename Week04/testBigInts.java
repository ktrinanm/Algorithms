//Testing constructors and methods of the BigInteger class
//

import java.math.*;
import java.util.*;

public class testBigInts
{
	public static void main(String [] args)
	{
		Random rand = new Random();
		BigInteger p = new BigInteger(1024, 80, rand);
		BigInteger a = new BigInteger(1024, rand);
		BigInteger b = new BigInteger(1024, rand);
		BigInteger n = new BigInteger(1024, rand);

		System.out.println("p = " + p);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("n = " + n);
	
		System.out.println("\na+b = " + a.add(b));
		System.out.println("a*b = " + a.multiply(b));
		System.out.println("The bit length of n = " + n.bitLength());
		System.out.println("The bigger out of a and b is " + (a.compareTo(b) == -1 ? "b" : a.compareTo(b) == 0 ? "neither!" : "a"));
		System.out.println("a/b = " + a.divide(b));
		System.out.println("gcd(a,b) = " + a.gcd(b));
		System.out.println("p " + (p.isProbablePrime(90) ? "is" : "is not") + " probably prime.");
		System.out.println("a mod n = " + a.mod(n));
		System.out.println("a^-1 mod p = " + a.modPow(new BigInteger(-1 + ""), p));
		System.out.println("a^b mod n = " + a.modPow(b, n));
		System.out.println("a*b mod n = " + (a.multiply(b)).mod(n));
		System.out.println("The next prime after p is " + p.nextProbablePrime());
		System.out.println("q (a probably prime of bit length 1024 = " + BigInteger.probablePrime(1024, rand));
	}
}
