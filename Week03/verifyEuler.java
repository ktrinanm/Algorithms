// Verifies the Euler Generalization for n
// input: n, output a^phi(n) modulus n
// Will be used on Z12*, Z15*, and Z20*

import java.util.*;

public class verifyEuler
{
	public static void main(String [] args)
	{
		int n = Integer.parseInt(args[0]);
		ArrayList<Integer> units = new ArrayList<Integer>();

		for(int i = 1; i < n; i++)
		{
			if(gcd(i, n) == 1)
			{
				units.add(i);
			}
		}

		System.out.println("Phi(" + n + ") -> " + units.size());

		for(Integer a: units)
		{
			long toPhi = (long) Math.pow(a, units.size());
			System.out.println("\t" + a +"^" + units.size() + " mod " 
					+ n + " -> " + toPhi + " mod " + n 
					+ " - > " + (toPhi%n));
		}
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
}
