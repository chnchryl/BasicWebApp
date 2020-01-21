package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {


    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public String process(String query) {
        List<String> splitQuery = Arrays.asList(query.split(("[\\p{Punct}\\s]+")));
        splitQuery.stream().map((x) -> x.toLowerCase()).collect(Collectors.toList());
        List<String> teamNameOutput = Arrays.asList("what", "is", "your", "team", "name");
        List<String> numbersLargest = Arrays.asList("numbers", "largest");
        List<String> plus = Arrays.asList("plus");
        List<String> mult = Arrays.asList("multiplied");
        List<String> squarecube = Arrays.asList("both", "square", "cube");
        List<String> eiffel = Arrays.asList("eiffel", "tower", "city");
        List<String> sum = Arrays.asList("sum");
        List<String> minus = Arrays.asList("minus");
        List<String> theresa = Arrays.asList("theresa", "may", "prime", "minister");


        for (String s : splitQuery){
            System.out.println(s);
        }

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("chicken")) {
            return "delish delis bok";
        }

        if (splitQuery.containsAll(teamNameOutput)) {
            return "chicken";
        }
        if (splitQuery.containsAll(numbersLargest)) {
            int number1 = Integer.parseInt(splitQuery.get(splitQuery.size() - 1));
            int number2 = Integer.parseInt(splitQuery.get(splitQuery.size() - 2));
            return Integer.toString(Math.max(number1, number2));

        }

        if (splitQuery.containsAll(plus)) {
            int summ = 0;

            for (String s : splitQuery){
                if(isNumeric(s)){
                    summ += Integer.parseInt(s);
                }
            }


            return Integer.toString(summ);

        }

        if (splitQuery.containsAll(mult)) {

            int prod = 1;

            for (String s : splitQuery){
                if(isNumeric(s)){
                    prod *= Integer.parseInt(s);
                }
            }


            return Integer.toString(prod);

        }

        if (splitQuery.containsAll(sum)) {

            int summ = 0;

            for (String s : splitQuery){
                if(isNumeric(s)){
                    summ += Integer.parseInt(s);
                }
            }


            return Integer.toString(summ);

        }

        if (splitQuery.containsAll(squarecube)) {


            for (String s : splitQuery){
                if(isNumeric(s)) {
                    int num = Integer.parseInt(s);
                    int x = (int) Math.sqrt(num);
                    if (Math.pow(x, 2) == num) {
                        int y = (int) Math.cbrt(num);
                        if (Math.round(y) == y) {
                            return Integer.toString(num);
                        }
                    }
                }
            }
            return "";

        }

        if (splitQuery.containsAll(minus)) {


            List<Integer> nums = new ArrayList<>();

            for (String s : splitQuery){
                if(isNumeric(s)) {
                    int num = Integer.parseInt(s);
                    nums.add(num);
                }
            }
            return Integer.toString(nums.get(0) - nums.get(1));

        }

        if(splitQuery.containsAll(eiffel)){
            return "Paris";
        }

        if(splitQuery.containsAll(theresa)){
            return "2016";
        }
            return "";

    }
}
