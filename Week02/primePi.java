// Eratosthenes seive

import java.util.*;

public class primePi
{
	public static void main(String [] args)
	{
		double start, end;
		start = System.currentTimeMillis();
		int size = Integer.parseInt(args[0]);
		BitSet sieve = new BitSet(size);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int last = (int)Math.sqrt(size);
		
		// initialize bitset
		for(int i = 2; i <= size; i++)
		{
			sieve.set(i);
		}
		
		// Sieving process
		for(int i = 2; i <= last; i++)
		{
			if(sieve.get(i))
			{
				for(int j = 2*i; j <= size; j+=i)
				{
					sieve.clear(j);
				}
			}
		}
		
		//Go through the bitset and add primes to the ArrayList
		for(int i = 2; i <= size; i++)
		{
			if(sieve.get(i))
			{
				primes.add(i);
			}
		}
		
		System.out.println("The number of primes less than or " 
			+ "equal to " + size + " is " + primes.size());
		
		end = System.currentTimeMillis();
		System.out.println("\nprimePi took " + (end-start) +
				" milliseconds.");
	}
}
