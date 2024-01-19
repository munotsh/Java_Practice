package com.example.allPracticeProgram.jpmc;

public class CirculerToolsArray {

	public static void main(String[] args) {
		String[] s = { "abc", "xxx", "YYY", "zzz", "ccc" };
		int startingIndex = 2;
		String targetTool = "xx";

		int clockwiseCount = clockwise(s, startingIndex, targetTool);
		int anitClockwiseCount = Anitclockwise(s, startingIndex, targetTool);

		System.out.println(Math.min(anitClockwiseCount, clockwiseCount));
	}

	private static int Anitclockwise(String[] s, int startingIndex, String targetTool) {
		int count = 0;
		int end = 0;
		for (int i = startingIndex; i >= end; i--) {
			if (s[i].equals(targetTool)) {
				break;
			}
			count++;
			if (i == 0) {
				i = s.length;
				end = startingIndex + 1;
			}
		}

		return count;
	}

	private static int clockwise(String[] s, int startingIndex, String targetTool) {
		int end = s.length - 1;
		boolean flag = true;
		int count = 0;

		for (int i = startingIndex; i <= end; i++) {
			if (s[i].equals(targetTool)) {
				break;
			}
			count++;
			if (i == end && flag) {
				i = -1;
				end = startingIndex - 1;
				flag = false;
			}
		}
		return count;
	}

}
