package com.example.customeImmuatableClass;

import java.util.ArrayList;

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
