// Fermat's Theorem is a primality test: 
// let n = 943 and a = 767
// If 943 were prime, 767^942 should be congruent to 1 mod 943.
// Show that it is not

import java.util.*;

public class primality
{
	public static void main(String [] args)
	{
		int n = 943, a = 767, modn = 1;

		for( int i = 1; i < n; i++) // goes from 1 to 942
		{
			modn = (modn*a)%n;
		}

		System.out.println(a + "^(" + (n-1) + ") -> " + modn + " mod " + n);
	}
}
