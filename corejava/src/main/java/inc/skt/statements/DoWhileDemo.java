package inc.skt.statements;

import java.util.Scanner;

public class DoWhileDemo {

	public static void main(String[] args) {
		
		System.out.println("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		do {
			System.out.println("Do While Executes atleast once");
			n++;
		} while(n<1);
		sc.close();

	}

}
