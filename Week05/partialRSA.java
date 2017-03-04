// Stage 1

import java.math.*;
import java.util.*;
import java.io.*;

public class partialRSA
{
	public static void main(String[] args)
	{
		//Randomly generate primes elsewhere and save them.
		String s = fileToString("cs-description.txt");  //needs to be found from 2420
		ArrayList<String> sBlocks = toStringBlocks(s); // needs to be written //convert string to 200 symbol blocks
		//You will have to play around to get the right p and q
		ArrayList<BigInteger> plaintext = toBigIntBlocks(sBlocks); // makes 600 digit blocks
		
		BigInteger p = new BigInteger("3362327510949069277068784884690918449394539504808263321788430077271677416931013117369850269412222256384749071065459306702751619930023594674393016835264405631481906230323611361394143348296585061174935105765653584098580467800741631535708893553561022682073748350336883374620504601626861443840177540197751");
		BigInteger q = new BigInteger("281333344708466996369222542624189842205042006818321754789752441165074558579896197113794968264053774765459740024062484640941468064588529738912956332676988612044265834581230173365857230794208116776031207537198467051593714547703844957235121014710878472594892451536753038441077793343874062281175054427453"); //ditto, 2nd prime
		BigInteger n = p.multiply(q); // Store here the product of the 2 primes.
		BigInteger e = new BigInteger("65537"); // nice because only 2 bits
		// 2^16  + 1 10000000000000001 (2 1's in it)
		
		/*BigInteger lessN = new BigInteger("" + (long)355);

		while(lessN.toString().length() != 600)
		{
			lessN = lessN.multiply(new BigInteger("" + 1000)).add(new BigInteger(""+355));
		}

		System.out.println(lessN);
		System.out.println(lessN.toString().length());

		while(n.toString().length() != 600 || n.compareTo(lessN) != 1)
		{
			p = randomPrime(300);
			q = randomPrime(300);
			n = p.multiply(q);
		}*/

	
		BigInteger one = BigInteger.ONE;
		BigInteger phi_n = (p.subtract(one)).multiply(q.subtract(one));
		BigInteger d = e.modInverse(phi_n); //decrypting exponent: inverse of e mod phi_n

		String a = "27615887459063843766779648204866194360687419289615975357345892098007272739715188584518943137128028481318710741686908923385248853867093255126670441155741068182555965642686516146309952192824451262817201106628679596315102228315882472016674068431345971047565251048236257374375879665554055482114367723735568118346448005673049303772885008572241891155684323709782005071240841629701178581172006114412576213423466635072805992444806632256673278788617068111282162338093494381296978761931359260533782205311156118820956309988735378852535328835310197037903333632884471871880556053541870202385817726048221692467620\n255661881920072174726578482991352507844096225644329825498031074895973268274114692310795014928407111661320119185225147778982844063252254492859809201860541244290407188994963902098592871923234259967732990087493926966986431360052399594239287102438007715873023665148920113651173824099053643940236141096934511624963348953310857855154282714224812706204667662011062808769938347507606083052937030990156738689414693195096354562592904972377693715743557639720642249948094029427990103132177368258342229496743536746851651186278184131996965824861934114208718079289472529773688633084908627606247953761950847588195691\n181824504018722945017709380576929876306656806963207251891929589795229949853444132213864190625253276125454247740064208824981369688585492829000151028914711130596557122284841730459198834464324979842668668595892688291447427552407105205761478555126426202273373337980246873722190650345961598990112289385467982483819070733185950736808985930364144843755846431204497020631931694799147061030216394589385131939210396027507674249681316424115890348788001021215853302701485671289124211924091062018758595890845955828554675176558697989150373263153439321256124839955622387451546831113891718607118535875164632948157490\n736083252042765376387046372362416018099372889817255372760981126089312009993014479365401592491177259926988622161705869209702468158698112983089843318918318754798208501859821003521643884553597181274279533366851246097312082683632672280546265541857649824731626524108861766863775871348861920974444176554043776435119010348269575584546343729093101512776944220167622593221714270099869573900068529270817212759967098234815269736695730568173332288320264166330488959984097335062677880923578350261215079699472514234659726392076500256899729701983194489874064531951725743984141015963475795044888871611854978738508257";
		String [] biArr = a.split("\n");
		ArrayList<BigInteger>  cyphText = new ArrayList<BigInteger>(); // To put the cyphertext  --Will have to write this method

		for(int i = 0; i < biArr.length; i++)
		{
			cyphText.add(new BigInteger(biArr[i]));
		}
		
		ArrayList<BigInteger> decryptText = decipher(cyphText, d, n); // Write this method
		// ArrayList<String> decipherToString = plainToStringBlocks(decryptText); //Turns the text into size 200 blocks

		//Optional: smash together
	}

	//Takes an ArrayList of String blocks and converts each block to a 600 digit string
	// block. Check that the length is 600
	public static ArrayList<BigInteger> toBigIntBlocks(ArrayList<String> strBlocks)
	{
		String temp = "";
		String bigIntStr = "";
		Iterator<String> it = strBlocks.iterator();
		ArrayList<BigInteger> bigIntBlock = new ArrayList<BigInteger>();

		while(it.hasNext())
		{
			temp = it.next();

			for(int i = 0; i < temp.length(); i++)
			{
				char a = temp.charAt(i);
				String b = toPaddedAscii(a);
				bigIntStr = bigIntStr.concat(b);
			}

			if(bigIntStr.length() != 600)
			{
				System.out.println("*************WARNING!!!! BigIntBlock not 600 len!!");
			}

			bigIntBlock.add(new BigInteger(bigIntStr));
			bigIntStr = "";
		}

		return bigIntBlock;
	}

	//Takes one character and returns a 3 digit String (ascii value plus 100)
	public static String toPaddedAscii(char c)
	{
		int a = (int)c + 100;
		String result = a+"";

		return result;
	}

	// Takes a string and parses it into 200 character substrings. stores into arraylist
	public static ArrayList<String> toStringBlocks(String s)
	{
		ArrayList<String> blocks = new ArrayList<String>();

		for(int i = 0; i < s.length()/200; i++)
		{
			blocks.add(s.substring(i*200, (i+1)*200));
		}
		if(s.length()%200 != 0)
		{
			String temp = (s.substring(200*(s.length()/200), s.length()));
			
			while(temp.length() != 200)
			{
				temp += "X";
			}
			blocks.add(temp);
		}

		return blocks;
	}

	// Takes a filename and reads in the file, then converts it to a string
	public static String fileToString(String filename)
	{
		String result = "";
		try
		{
			FileInputStream file = new FileInputStream(filename);
			byte [] b = new byte[file.available()];
			file.read(b);
			file.close();
			result = new String(b);
		}
		catch(Exception e)
		{
			System.out.println("oops");
		}

		return result;
	}

	// Return a random integer approx. n digits in length
	public static BigInteger randomInteger(int ndigits)
	{
		Random rand = new Random();
		//basically take the log of 10 dividided by the log of 2
		int len = (int)(3.32*(double)ndigits); // length in bits
		return new BigInteger(len, rand); // most will be the avg of 10^n
	}

	// Return a random prime approx. ndigits in length
	public static BigInteger randomPrime(int ndigits)
	{
		BigInteger p = randomInteger(ndigits);
		return p.nextProbablePrime();
	}

	//hw
}
	/*
	 * NOTES:
	 *
	 * 2^10 binary -> decimal digits
	 * log10/log2
	 *
	 * Chance that a number of length 300 is prime -> 1/700
	 *
	 */
