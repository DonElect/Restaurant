package com.donatus.implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Lamdas{
    public static void main(String[] args) {

        int[] arr = {3, 2, 6, 4, 7, 2, 7};
        System.out.println(Arrays.toString(arr));
         arr = Arrays.stream(arr).map(n-> n*2).toArray();
        System.out.println(Arrays.toString(arr));
//        System.out.println(oddOrEven.test(4));
//        System.out.println(isVowel.test("A"));
//        System.out.println(randomizer.get());
//        Map<String, Integer> clientList = new HashMap<>();
//        clientList.put("Emma", 1_000_000);
//        clientList.put("Onyeka", 1_000);
//        clientList.put("Mike", 2_000_000);
//        clientList.put("Gerald", 1_500_000);
//        clientList.put("Tina", 3_000_000);
//
//        printCustomers.accept(clientList);
//
//        printSomething.accept("Nigeria", 200_000_000);
//        String result = statement.apply("Ben", 15);
//        String result1 = statement.apply("Mike", 17);
//        System.out.println(result);
//        System.out.println(result1);
//        int result1 = test1.apply("Donatus");
//        int result2 = function("Donatus");
//        System.out.println(result1);
//        System.out.println(result2);
    }

//    static Predicate<Integer> oddOrEven = n-> n%2 == 0;
//    static Predicate<String> isVowel = name-> "aeiou".contains(name.toLowerCase());
//    static Supplier<Integer> randomizer = () -> (int)(Math.random()*100);
//    static Consumer<Map<String, Integer>> printCustomers = custListMap ->{
//        for (Map.Entry<String, Integer> cust : custListMap.entrySet()){
//            System.out.printf("%-12s %-12s \n", cust.getKey(), cust.getValue());
//        }
//    };
//
//    static BiConsumer<String, Integer> printSomething = (country, population)->{
//        System.out.println("My country is "+country+". We are "+population+" in number");
//    };


//    static String statementImperative(String name, int age){
//        return "Hello, My name is "+name+". I am "+age+"years old.";
//    }
//
//    static BiFunction<String, Integer, String> statement = (name, age) ->{
//        return "Hello, My name is "+name+". I am "+age+"years old.";
//    };
//    static int function(String name){
//        return name.length();
//    }
//
//    // Functions
//    static Function<String, Integer> test1 = String::length;
}
