package inc.skt.statements;

import java.util.Scanner;

public class WhileDemo1 {

	public static void main(String[] args) {

		System.out.print("Enter the value of n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int res = 1;
		int i = 1;
		while (i <= n) {
			res = res * i;
			i++;
		}
		System.out.println("Multiplied value of first n numbers: " + res);
		sc.close();
	}

}
