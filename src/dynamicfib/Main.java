package dynamicfib;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input: ");
		String in = input.next();
		try {
			System.out.println(dynamicFibo(Integer.parseInt(in)));
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} finally {
			input.close();
		}
	}
	
	/*
	 * F(0) = 0, F(1) = 1 as initial conditions
	 */
	public static int dynamicFibo(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else if (n < 0) {
			return -1;
		}
		int[] storage = new int[n + 1];
		storage[0] = 0;
		storage[1] = 1;
		for (int counter = 2; counter <= n; counter++) {
			storage[counter] = storage[counter - 1] + storage[counter - 2];
		}
		return storage[n];
	}

}
