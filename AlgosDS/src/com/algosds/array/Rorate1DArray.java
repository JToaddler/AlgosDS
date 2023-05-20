package com.algosds.array;

/**
 * 
 * Time complexity: O(N) Auxiliary Space: O(D) 
 * 
 * 2 ways to solve this problem
 * 
 * a) Temp array & start iteration from index till end of array (index -> length) And (0 to index +1)
 * b) In place rotation. shift 1 -> 0, 2-> 1, 3-> 2......n -> n-1,0 -> n
 * 
 * @author Anto
 *
 */
public class Rorate1DArray {

	public static int[] rotateArrayUsingTempArray(int[] array, int index) {

		int[] temp = new int[array.length];
		// Copy sub array 1 - after index
		for (int i = index, j = 0; i < array.length; i++, j++) {
			temp[j] = array[i];
		}
		// Copy sub array 2 - before index
		for (int i = 0, j = index + 1; i < index; i++, j++) {
			temp[j] = array[i];
		}
		return temp;
	}

	public static int[] rotateArrayByIndex(int[] array, int index) {

		for (int i = 0; i < index; i++) {
			rotateArrayByOne(array);
		}
		print(array);
		return array;
	}

	public static int[] rotateArrayByOne(int[] array) {

		int start = array[0];
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = start;
		return array;
	}

	public static void print(int[] letters) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < letters.length; i++) {
			sb.append(letters[i] + ", ");
		}
		System.out.println(sb.toString());

	}

	public static void main(String[] args) {

		int[] intArray = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int[] intArray2 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		
		int shiftPosition = 3;
		// rotateArrayUsingTempArray(intArray, shiftPosition);
		// rotateArrayByOne(intArray);
		print(intArray2);
		rotateArrayByIndex(intArray2, 5);
	}
}
