package inc.skt.statements;

import java.util.Scanner;

public class NumberOfPrimes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter value of i : ");
		int i = sc.nextInt();
		System.out.print("Enter value of j : ");
		int j = sc.nextInt();
		
		int n = 0;
		
		for( int k = i; k <= j; k++) {
			if(isPrime(k)) {
				System.out.println(k);
				n++;
			}
		}
		
		System.out.println("No. of primes between " + i + " and " + j + " are : " + n);
		sc.close();
	}
	
	private static boolean isPrime(int k) {
		
		if(k == 1 || k == 0) {
			return false;
		}
		
		for(int i = 2; i <= k-1; i++) {
			
			if(k % i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
