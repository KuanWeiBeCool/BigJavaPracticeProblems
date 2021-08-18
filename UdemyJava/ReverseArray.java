package Section8;

import java.util.Arrays;

public class ReverseArray {

//	public static void main(String[] args) {
//		int[] array1 = {1, 2, 3, 4, 5};
//		int[] array2 = {1, 2, 3, 4};
//		
//		reverse(array1);
//		reverse(array2);
//		System.out.println(Arrays.toString(array1));
//		System.out.println(Arrays.toString(array2));
//		
//	}
//	
	private static void reverse(int[] array) {
		int i = 0;
		int j = array.length - 1;
		int temp;
		while (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
	}

}
