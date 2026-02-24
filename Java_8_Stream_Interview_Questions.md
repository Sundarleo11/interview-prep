# 🚀 Java 8 Stream API -- Interview Coding Questions

## 📌 Table of Contents

1.  [Separate Odd and Even Numbers](#1-separate-odd-and-even-numbers)
2.  [Remove Duplicate Elements](#2-remove-duplicate-elements)
3.  [Frequency of Each Character in
    String](#3-frequency-of-each-character-in-string)
4.  [Frequency of Each Element in
    Array/List](#4-frequency-of-each-element-in-arraylist)
5.  [Sort List in Reverse Order](#5-sort-list-in-reverse-order)
6.  [Join Strings with Prefix, Suffix and
    Delimiter](#6-join-strings-with-prefix-suffix-and-delimiter)
7.  [Print Multiples of 5](#7-print-multiples-of-5)
8.  [Find Maximum and Minimum](#8-find-maximum-and-minimum)
9.  [Merge Two Unsorted Arrays into Sorted
    Array](#9-merge-two-unsorted-arrays-into-sorted-array)
10. [Anagram Program](#10-anagram-program)
11. [Merge Arrays Without
    Duplicates](#11-merge-arrays-without-duplicates)
12. [Sum of Digits of a Number](#12-sum-of-digits-of-a-number)
13. [Top 3 Maximum and Minimum
    Numbers](#13-top-3-maximum-and-minimum-numbers)
14. [Second Largest Number](#14-second-largest-number)
15. [Sort Strings by Length](#15-sort-strings-by-length)
16. [Common Elements Between Two
    Arrays](#16-common-elements-between-two-arrays)
17. [Sum and Average of Array](#17-sum-and-average-of-array)
18. [Reverse Each Word of String](#18-reverse-each-word-of-string)
19. [Reverse Integer Array](#19-reverse-integer-array)
20. [Sum of First 10 Natural
    Numbers](#20-sum-of-first-10-natural-numbers)
21. [Palindrome Program](#21-palindrome-program)
22. [Find Strings Starting with
    Number](#22-find-strings-starting-with-number)
23. [Last Element of Array/List](#23-last-element-of-arraylist)
24. [Find Duplicate Elements](#24-find-duplicate-elements)
25. [Calculate Age in Years](#25-calculate-age-in-years)
26. [Fibonacci Series](#26-fibonacci-series)

------------------------------------------------------------------------

## 1. Separate Odd and Even Numbers

``` java
        List<Integer> listOfIntegers = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        System.out.println("Original List:");
        System.out.println(listOfIntegers);

        // =====================================================
        // Method 1 : Using filter() Method
        // =====================================================

        // Even numbers
        List<Integer> evenNumbers = listOfIntegers.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        // Odd numbers
        List<Integer> oddNumbers = listOfIntegers.stream()
                .filter(i -> i % 2 != 0)
                .collect(Collectors.toList());

        System.out.println("\nUsing filter():");
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
       
         o/p -->Even Numbers: [10, 20, 30, 40]
         o/p-->Odd Numbers: [15, 25, 35]

        // =====================================================
        // Method 2: Using partitioningBy() Method
        // =====================================================

        Map<Boolean, List<Integer>> partitionedMap =
                listOfIntegers.stream()
                        .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        System.out.println("\nUsing partitioningBy():");
        System.out.println("Even Numbers: " + partitionedMap.get(true));
        System.out.println("Odd Numbers: " + partitionedMap.get(false));

       0/p
        Even Numbers: [10, 20, 30, 40]
        Odd Numbers: [15, 25, 35]

```

## 2. Remove Duplicate Elements

``` java
listOfStrings.stream()
    .distinct()
    .collect(Collectors.toList());
```

## 3. Frequency of Each Character in String

``` java
inputString.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.groupingBy(Function.identity(),
            Collectors.counting()));
```

## 4. Frequency of Each Element in Array/List

``` java
anyList.stream()
    .collect(Collectors.groupingBy(Function.identity(),
            Collectors.counting()));
```

## 5. Sort List in Reverse Order

``` java
anyList.stream()
    .sorted(Comparator.reverseOrder())
    .forEach(System.out::println);
```

## 6. Join Strings with Prefix, Suffix and Delimiter

``` java
listOfStrings.stream()
    .collect(Collectors.joining(",", "Prefix", "Suffix"));
```

## 7. Print Multiples of 5

``` java
listOfIntegers.stream()
    .filter(i -> i % 5 == 0)
    .forEach(System.out::println);
```

## 8. Find Maximum and Minimum

``` java
listOfIntegers.stream().max(Comparator.naturalOrder()).get();
listOfIntegers.stream().min(Comparator.naturalOrder()).get();
```

## 9. Merge Two Unsorted Arrays into Sorted Array

``` java
IntStream.concat(Arrays.stream(a), Arrays.stream(b))
    .sorted()
    .toArray();
```

## 10. Anagram Program

``` java
String s1Sorted = Stream.of(s1.split(""))
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.joining());

String s2Sorted = Stream.of(s2.split(""))
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.joining());

// Compare s1Sorted.equals(s2Sorted)
```

## 11. Merge Arrays Without Duplicates

``` java
IntStream.concat(Arrays.stream(a), Arrays.stream(b))
    .sorted()
    .distinct()
    .toArray();
```

## 12. Sum of Digits of a Number

``` java
Stream.of(String.valueOf(inputNumber).split(""))
    .collect(Collectors.summingInt(Integer::parseInt));
```

## 13. Top 3 Maximum and Minimum Numbers

``` java
// Min 3
listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);

// Max 3
listOfIntegers.stream()
    .sorted(Comparator.reverseOrder())
    .limit(3)
    .forEach(System.out::println);
```

## 14. Second Largest Number

``` java
listOfIntegers.stream()
    .sorted(Comparator.reverseOrder())
    .skip(1)
    .findFirst()
    .get();
```

## 15. Sort Strings by Length

``` java
listOfStrings.stream()
    .sorted(Comparator.comparing(String::length))
    .forEach(System.out::println);
```

## 16. Common Elements Between Two Arrays

``` java
list1.stream()
    .filter(list2::contains)
    .forEach(System.out::println);
```

## 17. Sum and Average of Array

``` java
Arrays.stream(inputArray).sum();
Arrays.stream(inputArray).average().getAsDouble();
```

## 18. Reverse Each Word of String

``` java
Arrays.stream(str.split(" "))
    .map(word -> new StringBuffer(word).reverse())
    .collect(Collectors.joining(" "));
```

## 19. Reverse Integer Array

``` java
IntStream.rangeClosed(1, array.length)
    .map(i -> array[array.length - i])
    .toArray();
```

## 20. Sum of First 10 Natural Numbers

``` java
IntStream.range(1, 11).sum();
```

## 21. Palindrome Program

``` java
IntStream.range(0, str.length() / 2)
    .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
```

## 22. Find Strings Starting with Number

``` java
listOfStrings.stream()
    .filter(str -> Character.isDigit(str.charAt(0)))
    .forEach(System.out::println);
```

## 23. Last Element of Array/List

``` java
listOfStrings.stream()
    .skip(listOfStrings.size() - 1)
    .findFirst()
    .get();
```

## 24. Find Duplicate Elements

``` java
Set<Integer> set = new HashSet<>();

listOfIntegers.stream()
    .filter(i -> !set.add(i))
    .collect(Collectors.toSet());
```

## 25. Calculate Age in Years

``` java
LocalDate birthDay = LocalDate.of(1985, 1, 23);
LocalDate today = LocalDate.now();
System.out.println(ChronoUnit.YEARS.between(birthDay, today));
```

## 26. Fibonacci Series

``` java
Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
    .limit(10)
    .map(f -> f[0])
    .forEach(i -> System.out.print(i + " "));
```
