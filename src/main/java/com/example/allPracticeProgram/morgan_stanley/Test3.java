package com.example.allPracticeProgram.morgan_stanley;

public class Test3 extends parentUtil{
	

	public static void main(String[] args) {
	new Test3().callStuff();	
//		int x=0;
//		int y=0;
//		for(int z=0;z<5;z++) {
//			if((++x>2)&&(++y>2)) {
//				x++;
//			}
//		}
//		System.out.println(x+" "+y);
//		// TODO Auto-generated method stub
		
//		Test3 t = new Test3();
//		t.start();

		
		
	}

	 void callStuff() {
		System.out.println("this "+ this.dostuff());
		parentUtil p = new parentUtil();
		System.out.println("parent "+p.dostuff());
	}

//	 void start() {
//		String s1 = "slip";
//		String s2 =fix(s1);
//		System.out.println(s1+" "+s2);
//		
//	}
//
//	 String fix(String s1) {
//		 s1 = s1+"stream";
//		 System.out.println(s1+" ");
//		return "stream";
//	}

}
