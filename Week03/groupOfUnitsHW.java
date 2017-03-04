// Arithmetic in the group of units mod n

import java.util.*;

public class groupOfUnitsHW
{
	public static void main(String [] args) 
	{
		int n = Integer.parseInt(args[0]);
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
/*
		for(Integer a: units)
		{
			System.out.println(a);
		}

		System.out.println("\n" + order(17, 81));
*/		

		//System.out.println("\n" + units.size());
		
		Iterator<Integer> it = units.iterator();
		while(it.hasNext())
		{
			elem = it.next();
			ord = order(elem, n);
			System.out.println(elem + " " + ord);
/*
			if(ord == units.size())
			{
				roots.add(elem);
				//System.out.println(elem);
			}
*/			
		}

		System.out.println("INVERSES:");

		for(Integer a: units)
		{
			System.out.println("Inverse of " + a + " is " 
					+ inverse(a,n));
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
