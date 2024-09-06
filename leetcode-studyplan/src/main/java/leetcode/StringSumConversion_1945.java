package leetcode;

public class StringSumConversion_1945 {

	public static void main(String[] args) {
		// getLucky("leetcode", 1);
		char c = '0';
		System.out.println((int) c - '0');
		// solution("leetcode", 1);
	}

	public static int getLucky(String s, int k) {
		String numStr = "";
		int tot = 0;
		for (char c : s.toCharArray()) {
			int num = (int) c - 'a' + 1;
			numStr = numStr + num;
		}
		int count = 1;
		if (k == 1)
			return Integer.parseInt(numStr);
		int n = Integer.parseInt(numStr);

		while (count < k && n > 0) {
			tot = tot + n % 10;
			n = n / 10;
		}
		return tot;
	}

	public static int solution(String s, int k) {
		String numericString = "";
		for (char ch : s.toCharArray()) {
			numericString += Integer.toString(ch - 'a' + 1);
		}

		// Apply digit sum transformations k times
		while (k-- > 0) {
			int digitSum = 0;
			for (char digit : numericString.toCharArray()) {
				digitSum += digit - '0';
			}
			numericString = Integer.toString(digitSum);
		}

		// Convert the final string to integer and return
		System.out.println(numericString);
		return Integer.parseInt(numericString);
	}

}
