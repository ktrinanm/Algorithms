//Usage: Generates a random permutation of 100 things and finds its rank
//Input: none
//Output: A random permtation and its rank

public class genAndRank
{
	public static void main(String [] args)
	{
		int [] randPerm = randomPermutation(100);

		for(int i : randPerm)
		{
			System.out.print("  " + i);
		}
		System.out.println();

		int rankPerm = rank(randPerm);

		System.out.println("The rank of the random permuation is: " + rankPerm);
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

	public static int rank(int [] nums)
	{
		int rank = 0;
		int n = nums.length;

		for(int i = 0; i < n-1; i++)
		{
			int count = 0;
			for(int j = i+1; j < n; j++)
			{
				if(nums[j] < nums[i])
				{
					count++;
				}
			}

			rank += count*factorial(n-i);
		}

		return rank;
	}

	public static int factorial(int n)
	{
		if(n < 3)
		{
			return n;
		}
		else 
		{
			return n*factorial(n-1);
		}
	}
}
