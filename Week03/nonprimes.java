//For all ints n in the range [2, 1000], compute 2^(n-1) mod n
//How many non-primes did it detect?

import java.util.*;

public class nonprimes
{
	public static void main(String [] args)
	{
		int numnon = 0;

		for( int i = 2; i <= 1000; i++)
		{
			int modn = 1;

			for(int j = 1; j < i; j++)
			{
				modn = (modn*2)%i;
			}
			if(modn != 1)
			{
				numnon++;
			}
		}

		System.out.println("There are " + numnon + " non-primes in the range "
				+ "[2, 1000]");
	}
}
