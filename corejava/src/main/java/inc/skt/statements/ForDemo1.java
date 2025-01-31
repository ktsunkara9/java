package inc.skt.statements;

import java.util.Scanner;

public class ForDemo1 {

	public static void main(String[] args) {

		System.out.print("Enter the value of n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		System.out.println("Sum of first n Numbers: " + sum);
		sc.close();
	}

}
