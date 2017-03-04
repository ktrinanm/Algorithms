// Finds the inverse of p
// inputs: p, n

import java.util.*;

public class inverses
{
	public static void main (String [] args)
	{
		int p = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);

		int phi_n = phiN(n);
		int order = order(p, phi_n);
		System.out.println("The order of " + p + ": " + order);

		System.out.println("The inverse of " + p + " is " + modexp(p, order-1, phi_n));
	}

	public static int phiN(int n)
	{
		int count = 0;
		for(int i = 1; i < n; i++)
		{
			if(gcd(i, n) == 1)
			{
				count++;
			}
		}
		return count;
	}

	public static int gcd(int n, int m)
	{
		if(m == 0)
		{
			return n;
		}
		return gcd(m, n%m);
	}	

	public static int modexp(int a, int b, int n)
	{
		int modexp = 1;
		String bin = Integer.toBinaryString(b);
		for(int i = 0; i < bin.length(); i++)
		{
			modexp = (modexp*modexp)%n;
			if(bin.charAt(i) == '1')
			{
				modexp = (modexp*a)%n;
			}
		}
		if(modexp < 0)
		{
			modexp = modexp + n;
		}

		return modexp;
	}


	public static int order (int p, int n)
	{
		int count = 0;
		int powered = 1;

		for(int i = 1; i < n; i++)
		{
			count++;
			powered = (powered*p)%n;
			if(powered == 1)
			{
				return count;
			}
		}
		return -1;
	}
}
