package com.example.hellojava;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-05-15
 */
public class PayCalc {
    public static void main(String []args){
        Person me = new Person();
        me.setFirstName("JK");
        me.setLastName("LM");
        me.setAge(90);
        System.out.println(me.toString());

        Person you = new Person("Marco", "Hidalgo", 20);
        System.out.println(you.toString());

        Employee prof = new Employee();
        prof.setFirstName(("Adam"));
        prof.setLastName("Eve");
        prof.setAge(50);
        prof.setPay(20.50);
        System.out.println(prof.toString());

        FullTime fullTimeProf = new FullTime();
        fullTimeProf.setFirstName("Severus");
        fullTimeProf.setLastName("Snape");
        fullTimeProf.setAge(38);
        fullTimeProf.getBasicPay();
        fullTimeProf.getHoursWorked();
        fullTimeProf.getFinalPay();
        System.out.println(fullTimeProf.toString());

        PartTime partTimeProf = new PartTime();
        partTimeProf.setFirstName("Remus");
        partTimeProf.setLastName("Lupin");
        partTimeProf.setAge(38);
        partTimeProf.getBasicPay();
        partTimeProf.getHoursWorked();
        partTimeProf.getFinalPay();
        System.out.println(partTimeProf.toString());
    }
}

/*Experiment:

Add type of employee (full-time or part-time)
Add data member to indicate the basic pay of employee
(basic pay for part-time is $20, full-time is $50)
Add a variable to represent the number of hours the employee has worked.

add a method to calculate the final Pay for the employee considering
the number of hours they have worked and their status.
 */
