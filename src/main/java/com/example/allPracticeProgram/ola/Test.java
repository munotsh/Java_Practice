package com.example.allPracticeProgram.ola;

public class Test {
	public static void main(String[] args) {
	 int half;
     String str1 = "Titanic";
     half = str1.length() / 2;
     String str1Part1 = str1.substring(0, half + 1);
     String str1Part2 = str1.substring(half + 1);
     System.out.println(str1Part1 + ", " + str1Part2);

     String str2 = "HelloWorld";
     half = str2.length() / 2;
     String str2Part1 = str2.substring(0, half);
     String str2Part2 = str2.substring(half);
     System.out.println(str2Part1 + ", " + str2Part2);

//     Scanner in = new Scanner(System.in);
//     do {
//         System.out.print("Enter a string: ");
//         String str = in.nextLine();
//         half = str.length() / 2;
//         System.out.println(str.length() % 2 == 1 ? str.substring(0, half + 1) + ", " + str.substring(half + 1)
//                 : str.substring(0, half) + ", " + str.substring(half));
//         System.out.print("Enter Y to continue or any input to exit: ");
//     } while (in.nextLine().toUpperCase().equals("Y"));
// }
}

}
