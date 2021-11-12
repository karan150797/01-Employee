package com.company;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Employee> list = new ArrayList<Employee>();
        populate(list);
        System.out.println("Employee List");
        System.out.println(list);

        Predicate<Employee> designationManager = employee -> employee.designation.equals("Manager");
        System.out.println("Managers Information");
        display(designationManager, list);

        Predicate<Employee> cityBanglore = employee -> employee.city.equals("Banglore");
        System.out.println("Employees in Banglore city are:");
        display(cityBanglore, list);

        Predicate<Employee> salarylessthan50000 = employee -> employee.salary < 50000;
        System.out.println("Employees with Salary less than 50000 are:");
        display(salarylessthan50000, list);

        System.out.println("All Banglore Managers:");
        display(designationManager.and(cityBanglore), list);

        System.out.println("All Managers or Employees with Salary less than 50000 are:");
        display(designationManager.or(salarylessthan50000), list);

        System.out.println("All Employees who are not Managers are :");
        display(designationManager.negate(), list);
    }

    public static void populate(ArrayList<Employee> list){
        list.add(new Employee("Durga", "CEO", 100000, "Banglore"));
        list.add(new Employee("Sunny", "Manager", 75000, "Hyderabad"));
        list.add(new Employee("Bunny", "Manager", 75000, "Banglore"));
        list.add(new Employee("Ravi", "HR", 75000, "Hyderabad"));
        list.add(new Employee("Shiva", "Lead", 60000, "Banglore"));
        list.add(new Employee("Ram", "Lead", 60000, "Hyderabad"));
        list.add(new Employee("Kavish", "Developer", 50000, "Banglore"));
        list.add(new Employee("Vicky", "Developer", 50000, "Banglore"));
        list.add(new Employee("Rohit", "Developer", 50000, "Hyderabad"));
        list.add(new Employee("Dhruv", "Developer", 30000, "Hyderabad"));
        list.add(new Employee("Vikas", "Developer", 40000, "Banglore"));
        list.add(new Employee("Rishi", "Developer", 40000, "Hyderabad"));
        list.add(new Employee("Anushka", "Developer", 30000, "Hyderabad"));
        list.add(new Employee("Kiara", "Developer", 30000, "Banglore"));
        list.add(new Employee("Abhi", "Developer", 40000, "Hyderabad"));
    }

    public static void display(Predicate<Employee> p, ArrayList<Employee> list){
        for (Employee e:list) {
            if(p.test(e)){
                System.out.println(e);
            }
        }
    }
}
