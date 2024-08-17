public class Test {

	public static void main(String[] args) {
		
		System.out.println(solution(10));
	}

	public static int solution(int N) {
		int max_count = 0;
		String bStr = Integer.toBinaryString(N);
		System.out.println(bStr);
		String[] segments = bStr.replaceAll("0+$","").split("1");
		if (segments.length == 1)
			return 0;
		for (String gap : segments) {
			if (gap.length() > 0 && gap.length() > max_count) {
				max_count = gap.length();
			}
		}
		return max_count;
	}

}
