package com.technical.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static int maxValueWithIdentity(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (currentMax, nextElement) -> currentMax > nextElement ? currentMax : nextElement);
    }

    public static Optional<Integer> maxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce((currentMax, nextElement) -> currentMax > nextElement ? currentMax : nextElement);

    }

    public static Optional<Integer> minValueOptional(List<Integer> integerList) {
        return integerList.stream()
                // 6 -> nextElement
                // 7 -> nextElement
                // 8 -> nextElement
                // 9 -> nextElement
                // 10 -> nextElement
                // currentMin segura o valor máximo para cada elemento durante a iteração
                .reduce((currentMin, nextElement) -> currentMin < nextElement ? currentMin : nextElement);
    }

    public static Optional<Integer> minUsingMinStream(List<Integer> integerList) {
        return integerList.stream().min(Integer::compareTo);
    }

    public static Optional<Integer> maxUsingMinStream(List<Integer> integerList) {
        return integerList.stream().max(Integer::compareTo);
    }

    /*public static Optional<Integer> minUsingMinStream(List<Integer> integerList) {
    return integerList.stream()
                      .min((a, b) -> a.compareTo(b));
    }

    public static Optional<Integer> maxUsingMinStream(List<Integer> integerList) {
        return integerList.stream()
                          .max((a, b) -> a.compareTo(b));
    }
    */

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        // List<Integer> integerList = new ArrayList<>();
        System.out.println("maxValueWithIdentity: " + maxValueWithIdentity(integerList));
        System.out.println("maxValueOptional: " + maxValueOptional(integerList));
        System.out.println("maxUsingMinStream: " + maxUsingMinStream(integerList));
        System.out.println("minValueOptional: " + minValueOptional(integerList));
        System.out.println("minUsingMinStream: " + minUsingMinStream(integerList));


        Optional<Integer> maxValueOptional = maxValueOptional(integerList);

        if (maxValueOptional.isPresent()) {
            System.out.println(maxValueOptional.get());
        } else {
            System.out.println("No max value found");
        }


    }
}
