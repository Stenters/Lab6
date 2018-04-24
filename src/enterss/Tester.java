/*
 * CS2852
 * Spring 2017
 * Lab 6 - Recursion
 * Name: 
 * Created: 3/30/2017
 */
package enterss;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import enterss.ArrayList;
import enterss.LinkedList;

/**
 * Tests the ArrayList and LinkedList implementations for the
 * CS2852 Lab 6 assignment.
 */
public class Tester {
    private final static String[] EMPTY_STRINGS = {};
    private final static String[] STRINGS1 = {"this"};
    private final static String[] STRINGS2 = {"this", "will"};
    private final static String[] STRINGS3 = {"this", "will", "be"};
    private final static String[] STRINGS4 = {"this", "will", "be", "interesting"};
    private final static String[] STRINGS5 = {"this", null, "will", "be", "interesting"};

    private final static int[] EMPTY_INTS = {};
    private final static int[] INTS1 = {-1};
    private final static int[] INTS2 = {-1, 2};
    private final static int[] INTS3 = {-1, 2, 8};
    private final static int[] INTS4 = {-1, 2, 8, Integer.MAX_VALUE};

    /**
     * Calls all of the test methods
     * @param ignored Not used
     */
    public static void main(String[] ignored) {
        String description = "ArrayList constructor collection of Strings of size: ";
        test(description + 0, stringConstructor(EMPTY_STRINGS));
        test(description + 1, stringConstructor(STRINGS1));
        test(description + 2, stringConstructor(STRINGS2));
        test(description + 3, stringConstructor(STRINGS3));
        test(description + 4, stringConstructor(STRINGS4));
        test(description + 5, stringConstructor(STRINGS5));

        description = "ArrayList constructor collection of Integers of size: ";
        test(description + 0, intConstructor(EMPTY_INTS));
        test(description + 1, intConstructor(INTS1));
        test(description + 2, intConstructor(INTS2));
        test(description + 3, intConstructor(INTS3));
        test(description + 4, intConstructor(INTS4));

        description = "ArrayList.contains method checker";
        test(description, arrayListContainsTest());
        description = "ArrayList.indexOf method checker";
        test(description, arrayListIndexOfTest());
        description = "LinkedList.contains method checker";
        test(description, linkedListContainsTest());
        description = "LinkedList.indexOf method checker";
        test(description, linkedListIndexOfTest());
        description = "LinkedList.get method checker";
        test(description, linkedListGetTest());
        description = "LinkedList.size method checker";
        test(description, linkedListSizeTest());
    }

    /**
     * Displays an error if the test fails
     * @param description Description of the test
     * @param passed true if the test passed
     */
    private static void test(String description, boolean passed) {
        if(!passed) {
            System.out.println("Test failed: " + description);
        }
    }

    private static boolean arrayListContainsTest() {
        Collection<String> input = new java.util.ArrayList<>();

        List<String> emptyList = new ArrayList<>(input);
        input.add(STRINGS1.toString());
        List<String> oneList = new ArrayList<>(input);
        Collections.addAll(input,STRINGS5);
        List<String> list = new ArrayList<>(input);
        boolean passed = true;

        if (!list.contains("this")){
            passed = false;
        } else if (!list.contains("interesting")){
            passed = false;
        } else if (emptyList.contains(null)){
            passed = false;
        } else if (list.contains("hello")){
            passed = false;
        } else if (!oneList.contains(STRINGS1.toString())){
            passed = false;
        } else if (!list.contains(null)){
            passed = false;
        } else if (list.contains("")){
            passed = false;
        }

        return passed;
    }

    private static boolean arrayListIndexOfTest() {
        Collection<String> input = new java.util.ArrayList<>();

        List<String> emptyList = new ArrayList<>(input);
        input.add(STRINGS1.toString());
        List<String> oneList = new ArrayList<>(input);
        Collections.addAll(input,STRINGS5);
        input.add("will");
        List<String> list = new ArrayList<>(input);

        boolean passed = true;

        if (list.indexOf("this") != 1){
            passed = false;
        } else if (list.indexOf("interesting") != 5) {
            passed = false;
        } else if (emptyList.indexOf(null) != -1){
            passed = false;
        } else if (list.indexOf("hello") != -1){
            passed = false;
        } else if (oneList.indexOf(STRINGS1.toString()) != 0){
            passed = false;
        } else if (list.indexOf("will") != 3) {
            passed = false;
        }

        return passed;
    }

    private static boolean linkedListContainsTest() {
        Collection<String> input = new java.util.ArrayList<>();

        List<String> emptyList = new LinkedList<>(input);
        input.add(STRINGS1.toString());
        List<String> oneList = new LinkedList<>(input);
        Collections.addAll(input,STRINGS5);
        input.add("will");
        List<String> list = new LinkedList<>(input);

        boolean passed = true;

        if (!list.contains("interesting")){
            passed = false;
        } else if (!list.contains("this")) {
            passed = false;
        } else if (!oneList.contains(STRINGS1.toString())){
            passed = false;
        } else if (emptyList.contains(null)){
            passed = false;
        } else if (list.contains("hello")){
            passed = false;
        } else if (!list.contains(null)){
            passed = false;
        } else if (list.contains("")){
            passed = false;
        }

        return passed;
    }

    private static boolean linkedListIndexOfTest() {
        Collection<String> input = new java.util.ArrayList<>();

        List<String> emptyList = new LinkedList<>(input);
        input.add(STRINGS1.toString());
        List<String> oneList = new LinkedList<>(input);
        Collections.addAll(input,STRINGS5);
        input.add("will");
        List<String> list = new LinkedList<>(input);

        boolean passed = true;

        if (list.indexOf("this") != 1){
            passed = false;
        } else if (list.indexOf("hello") != -1){
            passed = false;
        } else if (list.indexOf("interesting") != 5){
            passed = false;
        } else if (emptyList.indexOf(null) != -1){
            passed = false;
        } else if (oneList.indexOf(STRINGS1.toString()) != 0){
            passed = false;
        } else if (list.indexOf("will") != 3) {
            passed = false;
        }
        return passed;
    }

    private static boolean linkedListGetTest() {
        Collection<String> input = new java.util.ArrayList<>();

        Collections.addAll(input,STRINGS5);
        input.add("will");
        List<String> list = new LinkedList<>(input);

        boolean passed = true;

        if (!list.get(0).equals("this")){
            passed = false;
        } else if (list.get(1) != (null)){
            passed = false;
        }
        return passed;
    }

    private static boolean linkedListSizeTest() {
        Collection<String> input = new java.util.ArrayList<>();
        List<String> list = new LinkedList<>(input);

        int size = 1;
        boolean passed = true;
        for (String s : STRINGS5) {
            list.add(s);
            size++;
            if (list.size() != size) {
                passed = false;
            }
        }

        list.remove(null);
        size--;
        if (list.size() != size){
            passed = false;
         }

        return passed;
    }


    /**
     * Tests the constructor that accepts a collection of elements.
     * After the ArrayList is instantiated, the size is compared with
     * the size of the collection.
     * @param strings An array of Strings to be added to the ArrayList
     * @return true if test passed
     */
    private static boolean stringConstructor(String[] strings) {
        Collection<String> input = new java.util.ArrayList<>();
        Collections.addAll(input, strings);
        List<String> list = new ArrayList<>(input);
        return list.size()==input.size();
    }

    /**
     * Tests the constructor that accepts a collection of elements.
     * After the ArrayList is instantiated, the size is compared with
     * the size of the collection.
     * @param numbers An array of ints to be added to the ArrayList
     * @return true if test passed
     */
    private static boolean intConstructor(int[] numbers) {
        Collection<Integer> input = new java.util.ArrayList<>();
        for(int number : numbers) {
            input.add(number);
        }
        List<Integer> list = new ArrayList<>(input);
        return list.size()==input.size();
    }
}
