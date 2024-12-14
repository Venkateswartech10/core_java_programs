package com.venkat.java.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCountDemo {
    public static void main(String[] args) {
        String input = "Venkateswar";
        System.out.println("************** Approach -1 ****************");
        //Without using Java 8
        //First convert string into character array by toCharArray()
        //to iterate one by one char & put them in a map.
        char[] charArray = input.toCharArray();
        //Create an empty hashMap
        HashMap<Character, Integer> map = new HashMap<>();
        //Start for loop to iterate character array
        for (char c : charArray) {
            //check if already char inserted into map or not
            //If inserted , get the existing count & increase the count by 1
            //else insert the char & count 1 into the Map
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        //Print the map object
        System.out.println(map); //{a=2, r=1, s=1, t=1, e=2, V=1, w=1, k=1, n=1}

        System.out.println("************** Approach -2 ****************");
        //Using java 8
        //split the string with "" so that it will give char[]
        //convert char[] to stream by Arrays.stream(char[])
        //collect each character & its count with groupingBy(Function.identity , Collectors.counting)
        Map<String, Long> map1 = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map1); // {a=2, r=1, s=1, t=1, e=2, V=1, w=1, k=1, n=1}

        System.out.println("************** Approach -3 ****************");
        //Using Java 8
        //codePoints() convert string to int stream
        //Map that integer to Object & parse char to String
        //collect each character & its count with groupingBy(Function.identity , Collectors.counting)
        Map<String, Long> map2 = input.codePoints()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map2); // {a=2, r=1, s=1, t=1, e=2, V=1, w=1, k=1, n=1}

    }


}
