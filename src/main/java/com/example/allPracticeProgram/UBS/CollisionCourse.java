package com.example.allPracticeProgram.UBS;

public class CollisionCourse {

	public static void main(String[] args) {
		int[] arr = {8,3,6,3,2,2,4,8,1,6};
		int pos =3;
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(i<pos) {
				if(arr[i] > arr[pos]) {
					count++;
				}
			}
			else {
				if(arr[i] < arr[pos]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
