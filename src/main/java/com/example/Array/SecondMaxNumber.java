package goldmanSachs;

public class SecondMaxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {3,2,4,6,10,1};
		int max = 0;
		int sMax =0;
		for(Integer i:arr) {
			if(max<i) {
				sMax = max;
				max = i;
			}
		}
		System.out.println(sMax);

	}

}
