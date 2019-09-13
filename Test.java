package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-23
 * Description:
 */
public class Test {
    public static void main(String[] args) {
//        Stream<List<Integer>> inputStream = Stream.of(
//                Arrays.asList(1),
//                Arrays.asList(2, 3),
//                Arrays.asList(4, 5, 6)
//        );
//        Stream<Integer> outputStream = inputStream.
//                flatMap((childList) -> childList.stream());
//        System.out.println(outputStream);
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
