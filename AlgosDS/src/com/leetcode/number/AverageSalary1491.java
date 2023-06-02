package com.leetcode.number;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * 
 * 
 * @author Anto
 *
 */
public class AverageSalary1491 {

	public static void main(String[] args) {
		int[] salary = { 48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000, 77000, 33000,
				28000, 4000, 54000, 67000, 6000, 1000, 11000 };
		Arrays.sort(salary);
		System.out.println("Average salary : " + average(salary));
	}

	public static double average(int[] salary) {
		Arrays.sort(salary);
		double sum = 0;
		double count = 0; //
		for (int i = 1; i < salary.length - 1; i++) {
			sum = sum + salary[i];
			count++;
		}
		return sum / count;
	}

}
