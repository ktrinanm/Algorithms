// Slow exponentiation
// compute a^b mod n
// Complexity: This approach is linear in the exponent.

import java.util.*;

public class slowExpHW
{
	public static void main (String[] args)
	{
		double start, end;

		Scanner input = new Scanner(System.in);
		System.out.println("Please input the variables for the equation "
				+ " a^b%n.");

		System.out.print("a: ");
		long a = input.nextInt();

		System.out.print("b: ");
		long b = input.nextLong();

		System.out.print("n: ");
		long n = input.nextInt();

		long amodn = 123456789;

		start = System.currentTimeMillis();
		for(long i = 1; i < b; i++)
		{
			a = (amodn*a)%n;		// Did this b times. Linear in b
		}

		System.out.println(a);

		end = System.currentTimeMillis();
		System.out.println("This took " + (end-start) + " ms.");
	}
}
