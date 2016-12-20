package leeTs.Easy;

public class _204_Count_Primes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countPrimesBase(int n) {
		int result = 0;
		for(int i = 2; i < n; i ++) {
			if(isPrime(i))
				result ++;
		}
		return result;
	}
	
	public boolean isPrime(int number) {
		for(int i = 2; i * i <= number; i ++) { // The cost of sqrt is much expensive than multiple
			if(0 == number % i)
				return false;
		}
		return true;
	}
	
	public int countPrime(int n) {
		boolean[] isPrime = new boolean[n]; // Because they are all less than given n. 
		for(int i = 2; i < n; i ++)
			isPrime[i] = true;
		for(int i = 2; i * i < n; i ++) {// if i is marked, i * i is surely to be mapped
			if(!isPrime[i]) continue; // no left unmarked number for this potential sequence
			for(int j = i * i; j < n; j += i)// the number j = i * t (t < i) is surely already marked by former number head t
				isPrime[j] = false;
		}
		int result = 0;
		for(int i = 2; i < n; i ++)
			if(isPrime[i])
				result ++;
		return result;
	}
	
	public int countPrimeBetter(int n) {
		if(n < 3)
			return 0;
		else {
			int result = n / 2;
			boolean[] notPrime = new boolean[n]; // initial as false by default
			for(int i = 3; i * i < n; i += 2) {// skip the evens which are surely not primes !
				if(notPrime[i])// the potential sequence must have been processed
					continue;
				else {
					for(int j = i * i; j < n; j += 2 * i) {// skip the evens
						if(!notPrime[j]) { // check whether it is necessary, to be correct.
							notPrime[j] = true;
							result --;
						}
					}
				}
			}
			return result;
		}
	}
}
