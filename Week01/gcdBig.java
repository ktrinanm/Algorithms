// Euclid's Alg
// Usage java gcd n m     BIG INTEGERS

import java.math.*;

public class gcdBig
{
	public static void main(String [] args)
	{
		BigInteger n = new BigInteger(args[0]);
		BigInteger m = new BigInteger(args[1]);
		System.out.println(euclid(n,m));
	}

	public static BigInteger euclid(BigInteger n, BigInteger m)
	{
		if(m.equals((new BigInteger("" + 0 + ""))))
		{
			return n;
		}
		else
		{
			return euclid(m, n.mod(m));
		}
	}
}
