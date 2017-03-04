// Slow exponentiation
// compute a^b mod n
// Complexity: This approach is linear in the exponent.

public class modularexp
{
	public static void main (String[] args)
	{
		int a = 7;
		int b = 181;
		int n = 561;

		for(int i = 1; i < 181; i++)
		{
			a = (7*a)%n;		// Did this b times. Linear in b
		}

		System.out.println(a);
	}
}
