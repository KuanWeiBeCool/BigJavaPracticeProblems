package Section8;

import java.util.Scanner;

public class MinimumElement {
	private static Scanner scanner = new Scanner(System.in);
//	public static void main(String[] args) {
//		int n = readInteger();
//		int[] array = readElements(n);
//		int min = findMin(array);
//		System.out.println("Min: " + min);
//	}
//	
	private static int readInteger() {
		System.out.println("How many elements? ");
		int n  = scanner.nextInt();
		return n;
	}
	
	private static int[] readElements(int n) {
		int[] array = new int[n];
		System.out.println("Start entering elements.");
		for (int i=0; i<n; i++) {
			array[i] = scanner.nextInt();
		}
		return array;
	}
	
	private static int findMin(int[] array) {
		int min = array[0];
		for (int i=0; i<array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

}
