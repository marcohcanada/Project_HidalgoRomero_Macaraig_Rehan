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
    }
}
