// 
// computes a^b mod n
//

public class fastmodexp
{
	public static void main(String [] args)
	{
		int a = 7; 
		int b = 181;
		int n = 561;

		System.out.println(modexp(7, 181, 561));
	}

	public static int modexp (int a, int b, int n)
	{
		int d = 1;
		String bin = Integer.toBinaryString(b);
		System.out.println(bin);

		for(int i = 0; i < bin.length(); i++)
		{
			d = (d*d)%n;
			if(bin.charAt(i) == '1')
			{
				d = (d*a)%n;
			}
		}
		if(d < 0) 
		{
			d = d+n;
		}
		System.out.println(d);
		return d;
	}
}
