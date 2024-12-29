package com.technical.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static int maxValue(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (x, y) -> x > y ? x : y);

    }

    public static Optional<Integer> maxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce((x, y) -> x > y ? x : y);

    }

    public static void main(String[] args) {

        //List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> integerList = new ArrayList<>();
        System.out.println(maxValue(integerList));

        Optional<Integer> maxValueOptional = maxValueOptional(integerList);

        if (maxValueOptional.isPresent()) {
            System.out.println(maxValueOptional.get());
        } else {
            System.out.println("No max value found");
        }


    }
}
