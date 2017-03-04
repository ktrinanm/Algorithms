//Using e = 41:
//Write out the plain-text message. Then encrypt it.
//Find the inverse of e mod phi(n)
//Decode entire message using that inverse

import java.util.*;
import java.lang.*;

public class smallEncrypt
{
	public static void main (String [] args)
	{
		String plain = "PUBLICKEYCRYPTOGRAPHY";
		System.out.println(plain);

		int e = 41;
		int n = 2537;
		int d = modexp(e, order(e, phi(n))-1, phi(n));
		int p = phi(n);
		System.out.println("Public key: (" + e + ", " + n + ")");

		String numbers = toAscii(plain);
		System.out.println("Number blocks: " + numbers);

		String encrypted = modify(numbers, e, n);
		System.out.println("Encrypted blocks: " + encrypted);

		String decrypted = modify(encrypted, d, n);
		System.out.println("Decrypted blocks: " + decrypted);

		String letters = toChar(decrypted);
		System.out.println("Message: " + letters);
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

	public static int phi(int n)
	{
		int count = 0;
		for(int i = 1; i < n; i++)
		{
			if(gcd(i,n) == 1)
			{
				count++;
			}
		}
		return count;
	}

	public static int order(int a, int n)
	{
		int count = 0; 
		int power = 1;

		for(int i = 1; i < n; i++)
		{
			count++;
			power = (power*a)%n;
			if(power == 1)
			{
				return count;
			}
		}
		return -1;
	}

	public static String modify (String num, int e, int n)
	{
		String [] blocks = num.split(" ");
		String result = "", tmpStr;
		int temp = 0;

		for(int i = 0; i < blocks.length; i++)
		{
			temp = modexp(Integer.parseInt(blocks[i]), e, n);
			tmpStr = temp + " ";
			if(tmpStr.length() < 5)
			{
				int tmpLen = tmpStr.length();
				for(int j = 0; j < 5-tmpLen; j++)
				{
					tmpStr = "0" + tmpStr;
				}
			}
			result += tmpStr;
		}

		return result;
	}

	public static int modexp(int a, int b, int n)
	{
		String bin = Integer.toBinaryString(b);
		int modn = 1;
		for(int i = 0; i < bin.length(); i++)
		{
			modn = (modn*modn)%n;
			if(bin.charAt(i) == '1')
			{
				modn = (modn*a)%n;
			}
		}
		if(modn < 0)
		{
			modn += n;
		}

		return modn;
	}

	public static String toAscii (String plain)
	{
		String result = "";
		String temp = "";

		for(int i = 0; i < plain.length(); i++)
		{
			temp = (int)plain.charAt(i)-65 + "";
			if(temp.length() < 2)
			{
				temp = "0" + temp;
			}
			if(i%2 == 1)
			{
				temp += " ";
			}
			result += temp;
		}
		if(result.length()%5 != 4)
		{
			result += "23";
		}
		return result;
	}

	public static String toChar (String cipher)
	{
		String result = "";
		String temp = "";
		String [] blocks = cipher.split(" ");
		char ascii;

		for(int i = 0; i < blocks.length; i++)
		{
			temp = blocks[i].substring(0, 2);
			ascii = (char)(Integer.parseInt(temp)+65);
			result += ascii;
			temp = blocks[i].substring(2,4);
			ascii = (char)(Integer.parseInt(temp)+65);
			result += ascii;
		}
		
		return result;
	}
}
