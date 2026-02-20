# Java 8 Interview Sample Coding Questions

## 1. Separate Odd And Even Numbers

``` java
listOfIntegers.stream()
    .collect(Collectors.partitioningBy(i -> i % 2 == 0));
```

## 2. Remove Duplicate Elements From List

``` java
listOfStrings.stream()
    .distinct()
    .collect(Collectors.toList());
```

## 3. Frequency Of Each Character In String

``` java
inputString.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.groupingBy(Function.identity(),
            Collectors.counting()));
```

## 4. Frequency Of Each Element In An Array

``` java
anyList.stream()
    .collect(Collectors.groupingBy(Function.identity(),
            Collectors.counting()));
```

## 5. Sort The List In Reverse Order

``` java
anyList.stream()
    .sorted(Comparator.reverseOrder())
    .forEach(System.out::println);
```

## 6. Join List Of Strings With Prefix, Suffix And Delimiter

``` java
listOfStrings.stream()
    .collect(Collectors.joining("Delimiter", "Prefix", "Suffix"));
```

## 7. Print Multiples Of 5 From The List

``` java
listOfIntegers.stream()
    .filter(i -> i % 5 == 0)
    .forEach(System.out::println);
```

## 8. Maximum & Minimum In A List

``` java
listOfIntegers.stream().max(Comparator.naturalOrder()).get();
listOfIntegers.stream().min(Comparator.naturalOrder()).get();
```

## 9. Merge Two Unsorted Arrays Into Single Sorted Array

``` java
IntStream.concat(Arrays.stream(a), Arrays.stream(b))
    .sorted()
    .toArray();
```

## 10. Anagram Program In Java 8

``` java
String s1 = Stream.of(s1.split(""))
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.joining());

String s2 = Stream.of(s2.split(""))
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.joining());
// If s1 and s2 are equal, then they are anagrams.
```

## 11. Merge Two Unsorted Arrays Without Duplicates

``` java
IntStream.concat(Arrays.stream(a), Arrays.stream(b))
    .sorted()
    .distinct()
    .toArray();
```

## 12. Sum Of All Digits Of A Number

``` java
Stream.of(String.valueOf(inputNumber).split(""))
    .collect(Collectors.summingInt(Integer::parseInt));
```

## 13. Three Max & Min Numbers From The List

``` java
// Min 3
listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);

// Max 3
listOfIntegers.stream()
    .sorted(Comparator.reverseOrder())
    .limit(3)
    .forEach(System.out::println);
```

## 14. Second Largest Number In An Integer Array

``` java
listOfIntegers.stream()
    .sorted(Comparator.reverseOrder())
    .skip(1)
    .findFirst()
    .get();
```

## 15. Sort List Of Strings By Length

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

## 17. Sum & Average Of All Elements Of An Array

``` java
Arrays.stream(inputArray).sum();
Arrays.stream(inputArray).average().getAsDouble();
```

## 18. Reverse Each Word Of A String

``` java
Arrays.stream(str.split(" "))
    .map(word -> new StringBuffer(word).reverse())
    .collect(Collectors.joining(" "));
```

## 19. Reverse An Integer Array

``` java
IntStream.rangeClosed(1, array.length)
    .map(i -> array[array.length - i])
    .toArray();
```

## 20. Sum Of First 10 Natural Numbers

``` java
IntStream.range(1, 11).sum();
```

## 21. Palindrome Program In Java 8

``` java
IntStream.range(0, str.length() / 2)
    .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
```

## 22. Find Strings Which Start With Number

``` java
listOfStrings.stream()
    .filter(str -> Character.isDigit(str.charAt(0)))
    .forEach(System.out::println);
```

## 23. Last Element Of An Array

``` java
listOfStrings.stream()
    .skip(listOfStrings.size() - 1)
    .findFirst()
    .get();
```

## 24. Find Duplicate Elements From An Array

``` java
Set<Integer> set = new HashSet<>();

listOfIntegers.stream()
    .filter(i -> !set.add(i))
    .collect(Collectors.toSet());
```

## 25. Age Of Person In Years

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
