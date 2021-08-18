package Section8;

import java.util.Scanner;

public class SortedArray {

	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int n = 5;
		int[] array = getIntegers(n);
		printArray(array);
		int[] sortedArray = sortIntegers(array);
		printArray(sortedArray);
		printArray(array);
	}
	
	private static int[] getIntegers(int n) {
		System.out.println("Enter " + n + " elements.");
		int[] array = new int[n];
		for (int i=0; i<n; i++) {
			array[i] = scanner.nextInt();
		}
		
		return array;
	}
	
	private static void printArray(int[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.println("Element " + i + " contents " + array[i]);
		}
	}
	
	private static int[] sortIntegers(int[] array) {
		int[] sortedArray = new int[array.length];
		for (int i=0; i<array.length; i++) {
			sortedArray[i] = array[i];
		}
		boolean flag = true;
		int temp;
		while (flag){
			flag = false;
			for (int i=0; i<sortedArray.length-1; i++) {
				if (sortedArray[i] < sortedArray[i+1]) {
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[i+1];
					sortedArray[i+1] = temp;
					flag = true;
				}
			}			
		}
		return sortedArray;
	}
}
