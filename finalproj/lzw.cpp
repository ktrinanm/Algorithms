// An implementation of the Lempel-Ziv-Welch Algorithm
// Usage: lzw -c/-d filename

#include <iostream>
#include <fstream>
#include <unordered_map>
#include <cstdlib>
#include <iomanip>
#include <string>

using namespace std;

void compress(ifstream *, ofstream *);
void decompress(ifstream *, ofstream *);
const unsigned int MAX_CODE = 4097;

int main(int argc, char** argv)
{
	string infile;
	char flag = 'c';

	if(argc != 2 && argc != 3)
	{
		cout << "Number of arguments is not accepted." << endl;
		cout << "Usage: ./lzw [-c/-d] filename." << endl;
		return 1;
	}
	
	infile = argv[argc-1];

	if(argc == 3)
	{
		flag = argv[1][1];
	}

	ifstream in(infile, ifstream::in);
	ofstream out(infile + flag, ofstream::out | ofstream::binary);

	switch(flag)
	{
		case 'c':
		{
			compress(&in, &out);
			cout << "File " << infile << " compressed to "
				<< infile << flag << "." << endl;
			break;
		}
		case 'd':
			decompress(&in, &out);
			cout << "File " << infile << " decompressed to "
				<< infile << flag << "." << endl;
			break;
		default:
			cout << "Flag is not valid." << endl;
			return 1;
	}
}

void compress(ifstream *in, ofstream *out)
{
	//initializing the dictionary
	unordered_map<string, unsigned int> codes;

	for(int i = 0; i < 256; i++) //initialize dictionary 0-255
	{
		codes[string(1,i)] = i; //constructor size_t, char
	}

	unsigned int nextCode = 256;
	string currStr = "";
	char c;

	while((*in).get(c))
	{
		currStr += c;
		if(codes.find(currStr) == codes.end()) //iterator not found
		{
/*			if(nextCode <= MAX_CODE)
			{
			}
*/

			codes.insert(pair<string, const unsigned int>(currStr, nextCode++));
//			codes[currStr] = nextCode++;
			currStr.erase(currStr.size()-1); // remove c

			cout << currStr << ":\t";
			unsigned int code = codes[currStr] & 0xff;
			cout << (codes[currStr] & 0xff);
			cout << ((codes[currStr] >> 8) & 0xff);
//			cout.put(code);
//			cout.put((codes[currStr] >> 8 & 0xff));
			cout << endl;
//				<< codes[currStr] << endl;
			if(codes.size() > 65536)
			{
				cout << "The dictionary is too large!!" << endl;
			}
			
			(*out).put(codes[currStr] & 0xff);
			(*out).put((codes[currStr] >> 8) & 0xff);
//			(*out) << codes[currStr];
			currStr = c;
		}
	}

	if(currStr.size())
	{
		cout << currStr << ":\t" << codes[currStr] << endl;
		(*out).put(codes[currStr] & 0xff);
		(*out).put((codes[currStr] >> 8) & 0xff);
//		(*out) << codes[currStr];
	}
}

void decompress(ifstream *in, ofstream *out)
{
	unordered_map<uint16_t, string> strings(MAX_CODE);

	for(int i = 0; i < 256; i++) //initialize dictionary (backwards)
	{
		strings[i] = string(1,i);
	}

	string prevStr;
	uint16_t code;
	uint16_t nextCode = 256;
	char c;
	
	while((*in).get(c)) //dereference stream pointer
	{
		code = c;
		(*in).get(c);
		code |= (c & 0xff) << 8;
//
//		if(code > nextCode)
//		{
//			cout << "Error: " << nextCode << " "
//				<< code << endl;
//			continue;
//		}
//
//		(*out) << strings[code];
//		cout << code << ": " << strings[code] << endl;
//		if(prevStr.size())
//		{
//			strings[code] = prevStr + prevStr[0];
//		}
//
//		prevStr = strings[code];

		if(strings.find(code) == strings.end()) //not found
		{
			strings[code] = prevStr + prevStr[0];
		}

		(*out) << strings[code];
		cout << code << ":\t" << strings[code] << endl;
		
		if(prevStr.size())
		{
			strings[nextCode++] = prevStr + strings[code][0];
		}

		prevStr = strings[code];
	}
}
