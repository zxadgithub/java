package com.zxa.enums;


import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

public enum  EnumTest {
    SCOUT,CARGO;

    @Override
    public String toString() {
        return super.toString();
    }



}

class EnumTestMain{
    public static Set<String> analyze(Class<?> enumClass){
       System.out.println("==========Analyzeing"+enumClass+"===========");
        System.out.println("Interface");
        for(Type t : enumClass.getGenericInterfaces()){
            System.out.println(t);
        }

        System.out.println("Base :" + enumClass.getSuperclass());

        System.out.println("Method:");
        Set<String> methods = new TreeSet<>();
        for(Method m : enumClass.getMethods()){
            methods.add(m.getName());
        }

        System.out.println(methods);

        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(EnumTest.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum):" + enumMethods.containsAll(enumMethods));

        System.out.println("Explore.removeAll(Enum):");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);


        //向上转型
        EnumTest[] vals = EnumTest.values();
        Enum e = EnumTest.CARGO;
//        e.values();
        for(Enum en : e.getClass().getEnumConstants()){
            System.out.println(en);
        }

    }

}