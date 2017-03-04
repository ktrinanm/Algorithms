// Arithmetic in the group of units mod n
// Prints the size of the group of units of n (phi(n))

import java.util.*;

public class verifyPhi
{
	public static void main(String [] args) 
	{
		int [] primes = new int [] {2,3,5,7,11,13,17,19,23,29};
		
		System.out.println("Size of groups of units for primes:");
/*
		for(int a: primes)
		{
			System.out.printf("\tSize of group of units mod  %02d: %02d"
					+ "\n",
					a, findsGroupOfUnits(a));
		}
*/
		for(int i = 0; i < primes.length-1; i++)
		{
			for(int j = i+1; j < primes.length; j++)
			{
				int size = findsGroupOfUnits(primes[i]*primes[j]);
				System.out.printf("\tSize of group of units mod "
						+ primes[i]*primes[j]
						+ " (" + primes[i] + "*" + primes[j]
						+ "): %03d (%02d*%02d)\n", size, 
						findsGroupOfUnits(primes[i]), 
						size/findsGroupOfUnits(primes[i]));

			}
		}
	}

	public static int findsGroupOfUnits(int a)
	{
		int n = a;
		int size;
		int elem, ord;
		ArrayList<Integer> units = new ArrayList<Integer>();
		ArrayList<Integer> roots = new ArrayList<Integer>();

		for(int i = 1; i < n; i++)
		{
			if(gcd(i, n) == 1)
			{
				units.add(i);
			}
		}
		
		Iterator<Integer> it = units.iterator();
		while(it.hasNext())
		{
			elem = it.next();
			ord = order(elem, n);
			//System.out.println(elem + " " + ord);
		}
		return units.size();
	}

	public static int gcd(int n, int m)
	{
		if(m == 0)
		{
			return n;
		}
		else
		{
			return gcd(m, n%m);
		}
	}
	
	public static int order (int m, int n)
	{
		int count = 0;
		int power = 1;

		for(int i = 1; i < n; i++)
		{
			++count;
			power = (power*m)%n;
			if(power == 1)
			{
				return count;
			}
		}
		return -1;
	}

	public static int inverse(int m, int n)
	{
		return (int)Math.pow(m, order(m,n)-1)%n;
	}
}
