package inc.skt.statements;

import java.util.Scanner;

public class SwitchDemo2 {

	public static void main(String[] args) {

		System.out.print("Enter a month number: ");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();

		switch (ch) {
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println("Summer");
			break;
		case 7:
		case 8:
		case 9:
		case 10:
			System.out.println("Monsoon");
			break;
		case 11:
		case 12:
		case 1:
		case 2:
			System.out.println("Winter");
			break;
		default:
			System.out.println("Enter a valid month");
		}
		sc.close();
	}

}
