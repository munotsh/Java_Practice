package com.example.allPracticeProgram.common;

public final class ImmutableClassEmployee {
		private final String pancardNumber;
		private final String name;
		private final Address address;
		
		public ImmutableClassEmployee(String pancardNumber,String name,Address address){  
		this.pancardNumber=pancardNumber;  
		this.name= name;
		this.address = address;
		}  
		
		
		public Address getAddress() {
			Address add = new Address(this.address.getCity());
			return add;
		}

		public String getPancardNumber(){  
		return pancardNumber;  
		}
		
		public String getName() {
			return name;
		}


}
