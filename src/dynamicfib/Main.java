package dynamicfib;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input: ");
		String in = input.next();
		try {
			int n = Integer.parseInt(in);
			if (n < 0) {
				throw new NumberFormatException();
			}
			System.out.println(dynamicFibo(n));
			System.out.println(recursiveFibo(n));
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} finally {
			input.close();
		}
	}
	
	/*
	 * F(0) = 0, F(1) = 1 as initial conditions
	 */
	public static long dynamicFibo(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		long[] storage = new long[2];
		storage[0] = 0;
		storage[1] = 1;
		boolean use0 = true;
		for (int counter = 2; counter <= n; counter++) {
			if (use0) {
				storage[0] = storage[0] + storage[1];
				use0 = false;
			}
			else {
				storage[1] = storage[0] + storage[1];
				use0 = true;
			}
		}
		if (use0) {
			return storage[1];
		}
		else {
			return storage[0];
		}
	}
	
	public static long recursiveFibo(int n) {
		if (n == 0) {
			return 0L;
		}
		else if (n == 1) {
			return 1L;
		}
		else {
			return recursiveFibo(n - 1) + recursiveFibo(n - 2);
		}
	}

}
