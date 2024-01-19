package com.example.allPracticeProgram.amazon1;

public class BeautifulNumbers {

	public static void main(String[] args) {

		int l = 31;
		int r = 32;
		long sum = 0;
		for (int i = l; i <= r; i++) {
			int result = i;
			while (result != 1 && result != 4) {
				result = isBeautifulNumber(result);
//				System.out.println(result);
			}
			if (result == 1) {
				sum += i;
			}
		}
		System.out.println(sum);

	}

	private static int isBeautifulNumber(int num) {
		int rem = 0, sum = 0;
		while (num > 0) {
			rem = num % 10;
			sum += (rem * rem);
			num = num / 10;
		}
		return sum;
	}
//	#Calculate sum of beautiful/happy numbers
//	def isHappyNumber(number):
//	    rem=sum=0
//	    while(number>0):
//	        rem=(int)(number%10)
//	        sum=sum+(rem*rem)
//	        number=(int)(number/10)
//	    return sum
//	num=[31,32]
//	sum=0
//	for i in num:
//	    result=i
//	    while(result !=1 and result !=4):
//	        result=isHappyNumber(result)
//	        print(result)
//	    if(result==1):
//	        sum=sum+i
//	        print(sum)
//	print(str(sum) + " sum of happy numbers")

}
