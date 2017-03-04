// For n in [5, 1000] compute the ratio of #'s that pass Fermat's test over
// n-1. 
// In every case of a prime, it should detect it. Does it?
// When n is composite, verify that the ratio is <= 1/2 except for 1 case. Which case?

import java.util.*;

public class fermatRatio
{
	public static void main(String [] args)
	{
		int numPass, modn = 1, weirdRat = 0;

		for(int n = 5; n <= 1000; n++)
		{
			numPass = 0;

			for(int i = 1; i < n; i++)
			{
				modn = 1;
				for(int j = 1; j < n; j++)
				{
					modn = (modn*i)%n;
				}
				if(modn == 1)
				{
					numPass++;
				}
			}
			double ratio = (double)numPass/(n-1);
			System.out.println("Ratio of " + n + ": " + ratio);
			if(ratio != 1 && ratio > 0.5)
			{
				weirdRat = n;
			}
		}

		System.out.println("The weird number is " + weirdRat);
	}
}
