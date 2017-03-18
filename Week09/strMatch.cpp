//Input: Text array T, pattern P 
// Output: shift of every occurence of P 

#include <iostream>
#include <fstream>

using namespace std;

void findMatch(string, string);
string fileToString(string);

int main()
{
	string fname = "wonderland.txt";
	string toFind = "jabberwocky";
	string file = fileToString(fname);
	findMatch(file, toFind);
}

void findMatch(string textArray, string pattern)
{
	int n = textArray.length();
	int m = pattern.length();
	int numMatch = 0;
	bool matches;

	for(int i = 0; i < n-m; i++)
	{
		matches = true;
		for(int j = 0; j < m; j++)
		{
			if(pattern[j] != textArray[i+j])
			{
				matches = false;
				break;
			}
		}
		if(matches == true)
		{
			numMatch++;
			cout << "\"" << pattern << "\"" << " was found at " << i << endl;
		}
	}

	cout << "There were " << numMatch << " matches to \"" << pattern << "\" found in the file" << endl;
}

string fileToString(string filename)
{
	string result = "";
	string line;
	ifstream infile(filename.c_str());

	if(infile.is_open())
	{
		while(getline(infile, line))
		{
			result += line;
		}

		infile.close();
	}

	return result;
}