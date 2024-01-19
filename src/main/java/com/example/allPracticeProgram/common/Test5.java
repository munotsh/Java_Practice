package com.example.allPracticeProgram.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test5 {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		Employee e1 = new Employee(1, "Chandan", 1, 40000);
		Employee e2 = new Employee(2, "Arvind", 2, 10000);
		Employee e3 = new Employee(3, "Ajay", 3, 60000);
		Employee e4 = new Employee(4, "Rakesh", 4, 100000);
		Employee e5 = new Employee(5, "Chandan", 3, 50000);
		Employee e6 = new Employee(6, "Arvind", 4, 20000);
		Employee e7 = new Employee(7, "Ajay", 2, 70000);
		Employee e8 = new Employee(8, "Rakesh", 5, 100000);

		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		
		Comparator<Employee> com = (Employee i1, Employee i2)->{
			if(i1.getName().compareTo(i2.getName()) == 0){
				if(i1.getSalary() == i2.getSalary()) {
					return i1.getDid() - i2.getDid();
				}
				return i1.getSalary() - i2.getSalary();
			}
			return i1.getName().compareTo(i2.getName());
			
		};
		
//		list.sort((i1,i2) -> i1.getName().compareTo(i2.getName()));
		list.sort(com);
		list.forEach(i -> System.out.println(i.getName() +" "+i.getDid()+" "+i.getSalary()));
//		Collections.sort(list,((i1,i2) -> i1.));
	}

}

