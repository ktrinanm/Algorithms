// Eratosthenes seive

import java.util.*;

public class eratosthenes
{
	public static void main(String [] args)
	{
		BitSet sieve = new BitSet(8192);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int size = sieve.size();
		int last = (int)Math.sqrt(size);
		
		// initialize bitset
		for(int i = 2; i < size; i++)
		{
			sieve.set(i);
		}
		
		// Sieving process
		for(int i = 2; i <= last; i++)
		{
			if(sieve.get(i))
			{
				for(int j = 2*i; j < size; j+=i)
				{
					sieve.clear(j);
				}
			}
		}
		
		//Go through the bitset and add primes to the ArrayList
		for(int i = 2; i < size; i++)
		{
			if(sieve.get(i))
			{
				primes.add(i);
			}
		}
		
		for(Integer p : primes)
		{
			System.out.println(p);
		}
		
		System.out.println("The number of primes less than or " 
			+ "equal to " + size + " is " + primes.size());
	}
}