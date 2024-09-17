package leetcode.array;

public class SmallestGreaterChar_744 {
	public static void main(String[] args) {

		char[] arr = { 'a', 'c', 'f', 'j', 'z' };
		char re = nextGreatestLetter(arr, 'd');
		System.err.println("Result " + re);
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		int index = binarySearch(letters, target);
		System.out.println(" BS index " + index);
		int resultIndex = (index == -1 || index == letters.length) ? 0 : index;
		return letters[resultIndex];
	}

	public static int binarySearch(char[] letters, char target) {
		int left = 0, right = letters.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (letters[mid] > target) {
				right = mid - 1;
			} else
				left = mid + 1;
		}

		return left;
	}
}
