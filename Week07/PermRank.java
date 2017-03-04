// Usage: determines the lexicographic ranking of the permutation
// Input: a perm P of {1, 2, ... n}
// Output: rank in lex ordered list

public class PermRank
{
	public static void main(String [] args)
	{
		String perm = (args[0].replace("{", "")).replace("}", "");
		String [] numStr = perm.split(",");
		int [] nums = new int[numStr.length];

		for(int i = 0; i < numStr.length; i++)
		{
			nums[i] = Integer.parseInt(numStr[i]);
		}

		System.out.println("The rank of " + args[0] + " is " + rank(nums));
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