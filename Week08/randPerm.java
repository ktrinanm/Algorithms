//Input: an integer n
//Output: a random permutation of {1,2,...,n}

import java.util.*;

public class randPerm
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What is the size of the permutation?");
		int n = input.nextInt();

		int [] perm = randomPermutation(n);

		for(int i: perm)
		{
			System.out.print("  " + i);
		}
		System.out.println();
	}

	public static int[] randomPermutation(int n)
	{
		int [] perm = new int[n];

		for(int i = 0; i < n; i++)
		{
			perm[i] = i+1;
		}

		for(int i = 0; i < n; i++)
		{
			int swap = (int)(Math.random()*n);
			int temp = perm[i];
			perm[i] = perm[swap];
			perm[swap] = temp;
		}

		return perm;
	}
}
