/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author DanE
 */
public class ProduceTest {

    public ProduceTest() {
    }

    @Test
    public void testCollectWithValidInput() {
        Produce summarizer = new Produce();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> actual = summarizer.collect(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCollectWithEmptyInput() {
        Produce summarizer = new Produce();
        String input = "";
        Collection<Integer> expected = Arrays.asList();
        Collection<Integer> actual = summarizer.collect(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCollectWithNonNumericInput() {
        Produce summarizer = new Produce();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31,abc";
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> actual = summarizer.collect(input);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void testSummarizeCollectionWithValidInput() {
        Produce summarizer = new Produce();
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String actual = summarizer.summarizeCollection(input);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void testSummarizeCollectionWithSingleInput() {
        Produce summarizer = new Produce();
        Collection<Integer> input = Arrays.asList(1);
        String expected = "1";
        String actual = summarizer.summarizeCollection(input);
        Assertions.assertEquals(expected, actual);
    }
}
