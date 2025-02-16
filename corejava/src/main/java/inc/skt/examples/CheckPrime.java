package inc.skt.examples;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {

		System.out.print("Enter a number : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean res = checkPrime(num);
		
		System.out.println(num + " is a prime number : "+ res);
		sc.close();
	}

	private static boolean checkPrime(int num) {

		
		if(num == 0 || num == 1 || num < 0) {
			return false;
		}
		
		for(int i = 2; i<= num/2; i++) {
			if(num % i == 0) 
				return false;
		}
		
		return true;
	}

}
