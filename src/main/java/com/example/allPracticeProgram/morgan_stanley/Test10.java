package com.example.allPracticeProgram.morgan_stanley;

public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int s = 200;
int e = 400;

for(int i=s;i<=e;i++) {
	int it =0;
	int sum =0;
	if(i%100==0) {
		it = i/100;
		sum = i;
		System.out.println(sum);
	for(int j=1;j<=it;j++) {
		sum = sum + i;
		if(sum%i==0)
		System.out.print(sum);	
	}
	
	}
}
	}

}
