package com.example.allPracticeProgram.creditSuisse;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String st = "shailesh\b \\nmunot \bneha \nThis is new line";

//System.out.println(s);


//String[] sp = s.split("\n");
//for(int i=0;i<s.length()-1;i++) {
//	String s2 = String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1));
//	if(s2.equals("\b")) {
//		System.out.println(s.substring(0,i-1));
//	}
	
	
	
//}
//for(String s1:sp) {
//	
//	System.out.printlnv


StringBuilder sb = new StringBuilder(st.length());

for (int i = 0; i < st.length(); i++) {
    char ch = st.charAt(i);
    if (ch == '\\') {
        char nextChar = (i == st.length() - 1) ? '\\' : st
                .charAt(i + 1);
        // Octal escape?
        if (nextChar >= '0' && nextChar <= '7') {
            String code = "" + nextChar;
            i++;
            if ((i < st.length() - 1) && st.charAt(i + 1) >= '0'
                    && st.charAt(i + 1) <= '7') {
                code += st.charAt(i + 1);
                i++;
                if ((i < st.length() - 1) && st.charAt(i + 1) >= '0'
                        && st.charAt(i + 1) <= '7') {
                    code += st.charAt(i + 1);
                    i++;
                }
            }
            sb.append((char) Integer.parseInt(code, 8));
            continue;
        }
        switch (nextChar) {
        case '\\':
            ch = '\\';
            break;
        case 'b':
            ch = '\b';
            break;
        case 'f':
            ch = '\f';
            break;
        case 'n':
            ch = '\n';
            break;
        case 'r':
            ch = '\r';
            break;
        case 't':
            ch = '\t';
            break;
        case '\"':
            ch = '\"';
            break;
        case '\'':
            ch = '\'';
            break;
        // Hex Unicode: u????
        case 'u':
            if (i >= st.length() - 5) {
                ch = 'u';
                break;
            }
            int code = Integer.parseInt(
                    "" + st.charAt(i + 2) + st.charAt(i + 3)
                            + st.charAt(i + 4) + st.charAt(i + 5), 16);
            sb.append(Character.toChars(code));
            i += 5;
            continue;
        }
        i++;
    }
    sb.append(ch);
}
System.err.println(sb.toString()); 
	}

}
