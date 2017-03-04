// Euclid's Algorithm
// Usage java gcd n m
// Prints out the group of units mod n

import java.util.*;

public class groupOfUnits
{
	public static void main(String [] args) 
	{
		for(int i = 4; i < 100; i++)
		{
			int n = i+1;
			System.out.println("Group of units mod " + n + "=");
			int size;
			int elem;
			ArrayList<Integer> units = new ArrayList<Integer>();

			for(int j = 1; j < n; j++)
			{
				if(gcd(j, n) == 1)
				{
					units.add(j);
				}
			}
			
			System.out.print("\t{ ");
			for(Integer a: units)
			{
				System.out.print(a + ", ");
			}
			System.out.print("\b\b }\n");
			System.out.println("phi(" + n + ") = " + units.size());
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
