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
        assertThat(queryProcessor.process("what is the sum of 3, 5, 5"), containsString("13"));

    }

    @Test
    public void mul() throws Exception {
        assertThat(queryProcessor.process("what is 3 multiplied by 5"), containsString("15"));
        assertThat(queryProcessor.process("sdfsdfsdf what is 3 multiplied by 5"), containsString("15"));

    }

    @Test
    public void cubeSquare() throws Exception {
        assertThat(queryProcessor.process("which of the following is both cube and a square: 23, 34, 64"), containsString("64"));
    }

    @Test
    public void eiffel() throws Exception {
        assertThat(queryProcessor.process("which city has the eiffel tower"), containsString("Paris"));
    }
}
