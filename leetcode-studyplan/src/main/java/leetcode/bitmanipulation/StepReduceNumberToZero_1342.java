package leetcode.bitmanipulation;

public class StepReduceNumberToZero_1342 {

	public int numberOfSteps(int num) {
		int temp = num;
		int count = 0;
		while (temp > 0) {
			temp = temp % 2 == 0 ? temp / 2 : temp - 1;
			count++;
		}
		System.out.println("Number of steps :" + count);
		return count;
	}

	public static void main(String[] args) {
		StepReduceNumberToZero_1342 obj = new StepReduceNumberToZero_1342();
		obj.numberOfSteps(4);
	}
}
