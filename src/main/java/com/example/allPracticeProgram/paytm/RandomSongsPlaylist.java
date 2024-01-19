package com.example.allPracticeProgram.paytm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSongsPlaylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> pl= new ArrayList<String>();
		for(int i=0;i<100;i++) {
			pl.add("S"+i);
		}
		int lastIndex=pl.size()-1;
		while(lastIndex>=0) {
		int index=randomIndex(lastIndex);
		lastIndex=playSongAndShuffle(pl,index,lastIndex);
		}
		

	}

	private static int playSongAndShuffle(List<String> pl,int index, int lastIndex) {
		// TODO Auto-generated method stub
		try {
		String s1=pl.get(index);
		String s2=pl.get(lastIndex);
		pl.add(lastIndex, s1);
		pl.add(index, s2);
		System.out.println(s1);
		lastIndex--;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Songs list exausted");
			lastIndex--;
		}
		return lastIndex;
	}

	private static int randomIndex(int lastIndex) {
		// TODO Auto-generated method stub
		int idx=-1;
		if(lastIndex>0) {
		Random random=new Random();
		idx= random.nextInt(lastIndex);
		}
		
		return idx ;
		
		
	}

}
