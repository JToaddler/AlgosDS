package leetcode.stack;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemprature {

	public static void main(String[] args) {
		int[] temp = new int[100000];
		IntStream.range(0, 99999).forEach(a -> {
			temp[a] = 99;
		});
		temp[99999] = 100;
		System.out.println(Arrays.toString(temp));
		System.out.println(LocalDateTime.now());
		dailyTemperatures_BF(temp);
		System.out.println(LocalDateTime.now());
		dailyTemperatures_stack(temp);
		System.out.println(LocalDateTime.now());
	}

	// time limit exceeded exception - TC - O(N^2)
	public static int[] dailyTemperatures_BF(int[] temperatures) {
		int[] res = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			res[i] = findWarmerIndex(temperatures, i, temperatures[i]);
		}
		//System.out.println(Arrays.toString(res));
		return res;
	}

	public static int findWarmerIndex(int[] temperatures, int i, int temp) {
		for (int j = i + 1; j < temperatures.length; j++) {
			if (temp < temperatures[j])
				return j - i;
		}
		return 0;
	}
	
	/* Optimized 
	 * TC - O(2⋅N)= O(N)
	 * SP - O(N) 
	 */
	public  static int[] dailyTemperatures_stack(int[] temperatures) {
		int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int currDay = 0 ; currDay < temperatures.length; currDay++){
            int currTemp = temperatures[currDay];
            while(!stack.isEmpty() && temperatures[stack.peek()] < currTemp){
                int prevDay = stack.pop();
                res[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
		return res;
	}

}
