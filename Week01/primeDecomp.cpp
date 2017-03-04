#include <iostream>
#include <cmath>
#include <vector>
#include <cstring>

using namespace std;

int main() 
{
	int n;
	bool isPrime = true;

	cout << "Please input a number to find the prime decomposition of: ";
	cin >> n;

	int last = (int)sqrt(n);
	bool *sieve = new bool[last];
	memset(sieve, 1, last);
	vector<int> primes, primeFact;

	for(int i = 1; i < last; i++)
	{
		if(sieve[i])
		{
			for(int j = 2*(i+1); j < last; j+=(i+1))
			{
				sieve[j-1] = 0;
			}
		}
	}

	for(int i = 1; i < last; i++)
	{
		if(sieve[i])
		{
			primes.push_back(i+1);
		}
	}

	for(int i = 0; i < primes.size(); i++)
	{
		if(n%primes[i] == 0)
		{
			isPrime = false;
			primeFact.push_back(primes[i]);
			n/=primes[i];
		}
	}

	if(isPrime)
	{
		cout << "It is prime." << endl;
	}
	else
	{

		for(int i = 0; i < primeFact.size(); i++)
		{
			cout << primeFact[i] << ", ";
		}
		cout << endl;
	}
}

