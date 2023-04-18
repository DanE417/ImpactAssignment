package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author DanE
 */
class Produce implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {

        // Initialize an empty HashSet to hold the collected integers, without duplicates
        Set<Integer> noDuplicates = new HashSet<>();

        // Split the input string into a delimted list of strings, seperated by commas
        String[] numberStrings = input.split(",");

        // Iterate over the array of strings, parsing each string as an integer and adding it to the list
        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString.trim());
                noDuplicates.add(number);
            } catch (NumberFormatException e) {
                // Ignore any non-integer values in the input string
            }
        }
        
        // Convert to an ArrayList to work with instead of a HashSet
        List<Integer> numbers = new ArrayList<>(noDuplicates);
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        // Sort the collection of integers in ascending order
        List<Integer> sortedNumbers = new ArrayList<>(input);
        Collections.sort(sortedNumbers);

        // Initialize a list to hold the ranges of consecutive integers
        List<String> ranges = new ArrayList<>();

        // Iterate over the sorted list of integers, grouping consecutive integers into ranges
        int start = sortedNumbers.get(0);
        int end = start;
        for (int i = 1; i < sortedNumbers.size(); i++) {
            int current = sortedNumbers.get(i);
            if (current == end + 1) {
                end = current;
            } else {
                if (start == end) {
                    ranges.add(Integer.toString(start));
                } else {
                    ranges.add(start + "-" + end);
                }
                start = current;
                end = current;
            }
        }
        if (start == end) {
            ranges.add(Integer.toString(start));
        } else {
            ranges.add(start + "-" + end);
        }

        // Combine the ranges into a comma-delimited string
        return String.join(", ", ranges);
    }

}

public class Main {

    public static void main(String[] args) {
//        Produce p = new Produce();
//        System.out.println(p.summarizeCollection(p.collect("1,3,4,5,1,9,3,4,8")));
    }
}
