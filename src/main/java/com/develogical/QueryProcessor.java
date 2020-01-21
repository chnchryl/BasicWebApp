package com.develogical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {

    public String process(String query) {
        List<String> splitQuery = Arrays.asList(query.split(("[\\p{Punct}\\s]+")));
        splitQuery.stream().map((x) -> x.toLowerCase()).collect(Collectors.toList());
        List<String> teamNameOutput = Arrays.asList("what", "is", "your", "team", "name");


        for (String s : splitQuery){
            System.out.println(s);
        }
        for (String q : teamNameOutput){
            System.out.println(q);
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
        return "";
    }
}
