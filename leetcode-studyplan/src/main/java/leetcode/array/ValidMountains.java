package leetcode.array;

/**
 * https://leetcode.com/problems/valid-mountain-array/description/
 * 
 * @author
 *
 */
public class ValidMountains {

	public static void main(String[] args) {
		int[] arr = { 0, 3, 2, 1 };
		System.out.println(validMountainArray(arr));
	}

	public static boolean validMountainArray(int[] arr) {

		if (arr == null || arr.length < 3)
			return false;

		int start = arr[0];
		int peak = 0;
		for (; peak < arr.length - 1 && arr[peak] < arr[peak + 1]; peak++) {
		}
		if (start > peak)
			return false;
		int end = peak;
		for (; end < arr.length - 1 && arr[end] > arr[end + 1]; end++) {
		}

		return arr[peak] > arr[end] && end + 1 == arr.length;
	}
}