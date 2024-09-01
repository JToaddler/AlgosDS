package leetcode.array;

public class MaxConsecutiveOnes_II_487 {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 1, 0, 1 };
		System.out.println(findMaxConsecutiveOnes_v1(arr));
	}

	public static int findMaxConsecutiveOnes_v1(int[] nums) {

		int right = 0;
		int left = 0;
		int numZero = 0;
		int max = 0;
		while (right < nums.length) {
			if (nums[right] == 0)
				numZero++;

			while (numZero == 2) {
				if (nums[left] == 0)
					numZero--;
				left++;
			}
			max = Math.max(max, right - left + 1);
			right++;
		}
		return max;
	}

	public int findMaxConsecutiveOnes_v2(int[] nums) {
		int k = 1;
		int numZero = 0;
		int longestSeq = 0;

		for (int left = 0, right = 0; right < nums.length; right++) {
			if (nums[right] == 0)
				numZero++;
			while (numZero > k) {
				if (nums[left++] == 0) {
					numZero--;
				}
			}
			longestSeq = Math.max(longestSeq, right - left + 1);
		}
		return longestSeq;
	}

}
