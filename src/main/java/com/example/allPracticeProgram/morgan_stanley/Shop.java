package com.example.allPracticeProgram.morgan_stanley;

import java.util.ArrayList;
import java.util.List;

public class Shop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> product = new ArrayList<String>();
		product.add("eggs");
		product.add("milk");
		product.add("cheese");
		List<Float> productPrice = new ArrayList<Float>();
		productPrice.add(2.89F);
		productPrice.add(3.29F);
		productPrice.add(5.79F);
		List<String> productSold = new ArrayList<String>();
		productSold.add("eggs");
		productSold.add("eggs");
		productSold.add("cheese");
		productSold.add("milk");
		List<Float> soldPrice = new ArrayList<Float>();
		soldPrice.add(2.89F);
		soldPrice.add(2.99F);
		soldPrice.add(5.97F);
		soldPrice.add(3.29F);
		
		int count =0;
		for (int i = 0; i < productSold.size(); i++) {
			if(!productPrice.get(product.indexOf(productSold.get(i))).equals(soldPrice.get(i))) {
			count++;
			}
		}
		
		System.out.println(count);
	}

}
