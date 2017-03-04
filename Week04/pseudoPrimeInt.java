// Fast pseudoprime test with Integers
//
// Uses Eratosthenes sieve to compare the results of the a^(n-1)%n primality test

import java.util.*;

public class pseudoPrimeInt
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the highest number you'd like to use: ");
		int len = in.nextInt();
		int countWrong = 0;

		BitSet sieve = eratosthenes(len);

		for(int i = 1; i < len; i++)
		{
			int modulus = modexp(2, i, i+1);

			if(!sieve.get(i+1) && modulus == 1)
			{
				countWrong++;
			}
		}
		
		System.out.println("There were " + countWrong + " pseudoprimes calculated between 2 and " + len);
	}

	public static int modexp(int a, int b, int n)
	{
		long d = 1;
		String bin = Integer.toBinaryString(b);

		for(int i = 0; i < bin.length(); i++)
		{
			d = (d*d)%n;
			if(bin.charAt(i) == '1')
			{
				d = (d*a)%n;
			}
		}
		if(d < 0 )
		{
			d = d+n;
		}
		
		return (int)d;
	}

	public static BitSet eratosthenes(int length)
	{
		BitSet sieve = new BitSet(length);
		int last = (int) Math.sqrt(length);

		for(int i = 2; i < length; i++)
		{
			sieve.set(i);
		}

		for(int i = 2; i <= last; i++)
		{
			if(sieve.get(i))
			{
				for(int j = 2*i; j < length; j+=i)
				{
					sieve.clear(j);
				}
			}
		}

		return sieve;
	}
}
