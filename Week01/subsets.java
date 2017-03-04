// Generates all subsets of a set
// usage java subsets n

public class subsets
{
	public static void main(String [] args)
	{
		int n = Integer.parseInt(args[0]);
		String [] powerset = subsets(n);

		for(String s: powerset)
		{
			System.out.println(s);
		}
	}

	public static String [] subsets(int n)
	{ 
		//because 2^n subsets
		String [] powerset = new String[(int)Math.pow(2,n)];
		int [] toN = new int[n]; // a set from 1 to n

		for(int i = 0; i < n; i++)
		{
			toN[i] = i+1;
		}

		for(int i = 0; i < powerset.length; i++)
		{
			String binCount = Integer.toBinaryString(i);
			char [] inSet = binCount.toCharArray(); //'1' means in set
			String set = "{";

			for(int j = 0; j < inSet.length; j++)
			{
				if(inSet[j] == '1')
				{
					set += toN[j+n-inSet.length] + ", ";
				}
			}

			if(!set.equals("{"))
			{
				set += "\b\b";
			}
			set += "}";
			powerset[i] = set;
		}

		return powerset;
	}
}
