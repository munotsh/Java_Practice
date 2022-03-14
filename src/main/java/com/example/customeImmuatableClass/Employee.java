package com.example.customeImmuatableClass;

import java.util.ArrayList;
//How To create immutable class
//-	make class as final
//-	make variables as private final
//-	dont provide setters
//-	just provide getters
//
//benefits of immutable class.
// 1.	Immutable objects are thread-safe so you will not have any synchronization issues.
// 2.	Immutable objects are good Map keys and Set elements, since these typically do not change once created.
// 3.	Immutability makes it easier to write, use and reason about the code (class invariant is established once and then unchanged)
// 4.	Immutability makes it easier to parallelize your program as there are no conflicts among objects.
// 5.	The internal state of your program will be consistent even if you have exceptions.
// 6.	References to immutable objects can be cached as they are not going to change.

public final class Employee {
    private final String name;
    private final ArrayList<String> child;
    private final Company company;

    public Employee(String name, ArrayList<String> child, Company company) {
        this.name = name;
        this.company = company;

        ArrayList<String> temp = new ArrayList<String>();
        for(String s:child) {
            temp.add(s);
        }
        this.child = temp;
    }

    public String getName() {
        return name;
    }
    public ArrayList<String> getChild() {
        return (ArrayList<String>) child.clone();
    }
    public Company getCompany() {
        Company co = new Company(this.company.getName());
        return co;
    }
}
