package com.jetbrains;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        test(arr);

        arr.forEach(System.out::println);


    }

    public static void test(ArrayList<Integer> arr) {
        arr.set(0,1232);
        arr.set(1,12512);
    }


}
