package leetcode.array;

public class FindNumers {

	public static void main(String[] args) {
		int[] nums = { 12, 345, 2, 6, 7896 };
		findNumbers(nums);
		findNumbers_str(nums);
	}

	public static int findNumbers(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			System.out.println(Math.log10(nums[i]));
			int digitCount = (int) Math.floor(Math.log10(nums[i])) + 1;
			if (digitCount % 2 == 0)
				count += 1;
		}
		return count;
	}

	public static int findNumbers_str(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (String.valueOf(nums[i]).length() % 2 == 0)
				count = count + 1;
		}
		System.out.println(count);
		return count;
	}

}
