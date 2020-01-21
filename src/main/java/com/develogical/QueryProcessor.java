package com.develogical;

import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        String[] splitQuery = query.split(" ,./?");
        splitQuery = (String[]) Arrays.stream(splitQuery).map(String::toLowerCase).toArray();
        String[] teamNameOutput = {"what", "is", "your", "team", "name"};
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("chicken")) {
            return "delish delis bok";
        }


        if (Arrays.asList(splitQuery).containsAll(Arrays.asList(teamNameOutput))) {
            return "chicken";
        }
        return "";
    }
}
