package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutChicken() throws Exception {
        assertThat(queryProcessor.process("what is your team name"), containsString("chicken"));
    }

    @Test
    public void largestNum() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest 23 44"), containsString("44"));
    }

    @Test
    public void sum() throws Exception {
        assertThat(queryProcessor.process("what is 3 plus 5"), containsString("8"));
    }
}
