package com.example.allPracticeProgram.amazon1;

public class Hurry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int n = 3;
//		int t = 16;
//		int[][] task = { { 2, 8 }, { 4, 5 }, { 5, 1 } };
		int n = 3;
		int t = 10;
		int[][] task = { { 1, 3 }, { 2, 2 }};
		int max = 0;
		for (int i = 0; i < task.length; i++) {
			int time = 0;
			int back = 0;
			int index = 0;
			int count = 0;

			for (int j = i; j < task.length; j++) {
//				System.out.println(task[j][0] + " = " + task[j][1]);
				time = time + (task[j][0] - index) + task[j][1];
				index = task[j][0];
				back = task[j][0];
				count++;
			}
			System.out.println();
			time = time + back;
			if (time <= t && count > max) {
				max = count;
				System.out.println("time = " + time);
				System.out.println("task = " + count);

			}

		}

	}

}
