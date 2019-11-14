package com.zipcodewilmington.looplabs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by leon on 1/25/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying this class.
 */
public class IntegerDuplicateDeleterTest {

    private static Integer[] intArray;
    private static DuplicateDeleter<Integer> deleter;

    @Before
    public void setup() {
        this.intArray = new Integer[]{0, 0, 0, 1, 2, 2, 4, 4, 5, 5, 5, 6, 9, 9, 9};
        this.deleter = new IntegerDuplicateDeleter(intArray);
    }


    @Test
    public void testRemoveDuplicatesExactlyExactly() {
        Integer[] expected = new Integer[]{1, 2, 2, 4, 4, 6};
        Integer[] actual = deleter.removeDuplicatesExactly(3);
        TestUtils.assertArrayEquality(expected, actual);
    }


    @Test
    public void testRemoveDuplicatesExactly1() {
        Integer[] expected = new Integer[]{0, 0, 0, 1, 5, 5, 5, 6, 9, 9, 9};
        Integer[] actual = deleter.removeDuplicatesExactly(2);
        TestUtils.assertArrayEquality(expected, actual);
    }



    @Test
    public void testRemoveDuplicatesExactly2() {
        Integer[] expected = new Integer[]{0, 0, 0, 2, 2, 4, 4, 5, 5, 5, 9, 9, 9};
        Integer[] actual = deleter.removeDuplicatesExactly(1);
        TestUtils.assertArrayEquality(expected, actual);
    }


    @Test
    public void testRemoveDuplicatesExactly3() {
        Integer[] expected = new Integer[]{1, 2, 2, 4, 4, 6};
        deleter.removeDuplicates(3);
        deleter.removeDuplicatesExactly(2);
        deleter.removeDuplicatesExactly(1);

        Integer[] actual = deleter.removeDuplicatesExactly(3);
        TestUtils.assertArrayEquality(expected, actual);
    }


    @Test
    public void testRemoveDuplicates0() {
        Integer[] array = new Integer[]{0, 0, 0, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5};
        DuplicateDeleter<Integer> deleter = new IntegerDuplicateDeleter(array);
        Integer[] expected = new Integer[]{};
        Integer[] actual = deleter.removeDuplicates(0);
        TestUtils.assertArrayEquality(expected, actual);
    }


    @Test
    public void testRemoveDuplicates1() {
        Integer[] array = new Integer[]{0, 0, 0, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5};
        DuplicateDeleter<Integer> deleter = new IntegerDuplicateDeleter(array);
        Integer[] expected = new Integer[]{};
        Integer[] actual = deleter.removeDuplicates(1);
        TestUtils.assertArrayEquality(expected, actual);
    }


    @Test
    public void testRemoveDuplicates2() {
        Integer[] array = new Integer[]{0, 0, 0, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5};
        DuplicateDeleter<Integer> deleter = new IntegerDuplicateDeleter(array);
        Integer[] expected = new Integer[]{2};
        Integer[] actual = deleter.removeDuplicates(2);
        TestUtils.assertArrayEquality(expected, actual);
    }


    @Test
    public void testRemoveDuplicates3() {
        Integer[] array = new Integer[]{0, 0, 0, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5};
        DuplicateDeleter<Integer> deleter = new IntegerDuplicateDeleter(array);
        Integer[] expected = new Integer[]{1,1,2,4,4};
        Integer[] actual = deleter.removeDuplicates(3);
        TestUtils.assertArrayEquality(expected, actual);
    }


    @Test
    public void testRemoveDuplicates4() {
        Integer[] array = new Integer[]{0, 0, 0, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5};
        DuplicateDeleter<Integer> deleter = new IntegerDuplicateDeleter(array);
        Integer[] expected = new Integer[]{0,0,0,1,1,2,3,3,3,4,4};
        Integer[] actual = deleter.removeDuplicates(4);
        TestUtils.assertArrayEquality(expected, actual);
    }















    @Test
    public void testRemoveDuplicatesExactlyIdempotence() {
        Integer[] input = RandomNumberFactory.createIntegers(0,50,150);
        DuplicateDeleter<Integer> deleter = new IntegerDuplicateDeleter(input);
        Integer[] expected = deleter.removeDuplicatesExactly(5);

        for (int i = 0; i < input.length; i++) {
            deleter.removeDuplicatesExactly(i);
        }

        Integer[] actual = deleter.removeDuplicatesExactly(5);

        Arrays.sort(input);
        System.out.println("Input:\n\t" + Arrays.toString(input));
        TestUtils.assertArrayEquality(expected, actual);
    }


    @Test
    public void testRemoveDuplicatesIdempotence() {
        Integer[] input = RandomNumberFactory.createIntegers(0,50,150);
        DuplicateDeleter<Integer> deleter = new IntegerDuplicateDeleter(input);
        Integer[] expected = deleter.removeDuplicates(5);

        for (int i = 0; i < input.length; i++) {
            deleter.removeDuplicates(i);
        }

        Integer[] actual = deleter.removeDuplicates(5);

        Arrays.sort(input);
        System.out.println("Input:\n\t" + Arrays.toString(input));
        TestUtils.assertArrayEquality(expected, actual);
    }

    @Test
    public void countConsecutivesTest() {
        Integer[] array = {1,1,1,2,2,3,3,3,3,4,5,6,6};
        Integer expected = 3;
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer actual = idd.countConsecutives(0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void countConsecutivesTest2() {
        Integer[] array = {1,1,1,2,2,3,3,3,3,4,5,6,6};
        Integer expected = 2;
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer actual = idd.countConsecutives(3);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void countConsecutivesTest3() {
        Integer[] array = {1,1,1,2,2,3,3,3,3,4,5,6,6};
        Integer expected = 4;
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer actual = idd.countConsecutives(5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void countConsecutivesTest4() {
        Integer[] array = {1,1,1,2,2,3,3,3,3,4,5,6,6};
        Integer expected = 2;
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer actual = idd.countConsecutives(11);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void countConsecutivesTest5() {
        Integer[] array = {1,1,1,2,2,3,3,3,3,4,5,6,7};
        Integer expected = 1;
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer actual = idd.countConsecutives(12);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addToArrayTest1() {
        Integer[] array = new Integer[5];
        array[0] = 1;
        array[1] = 1;
        array[2] = 1;
        Integer[] expected = {1,1,1,2,2};
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer[] actual = idd.addNtoArray(array,2,2);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void addToArrayTest2() {
        Integer[] array = new Integer[5];
        Integer[] expected = {1,1,1,null,null};
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer[] actual = idd.addNtoArray(array,1,3);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void addToArrayTest3() {
        Integer[] array = new Integer[10];
        Integer[] expected = {1,1,1,2,2,3,3,3,3,3};
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        array = idd.addNtoArray(array,1,3);
        array = idd.addNtoArray(array,2,2);
        Integer[] actual = idd.addNtoArray(array,3,5);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void addToArrayTest4() {
        Integer[] array = new Integer[5];
        Integer[] expected = {1,1,1,1,1};
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer[] actual = idd.addNtoArray(array,1,5);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void nonnullLengthTest() {
        Integer[] array = new Integer[]{1,1,1,1,1,null};
        int expected = 5;
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        int actual = idd.getNonnullLength(array);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void nonnullLengthTest2() {
        Integer[] array = new Integer[]{1,1,1,1,1,2,2,3,null,null,null,null};
        int expected = 8;
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        int actual = idd.getNonnullLength(array);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void nonnullLengthTest3() {
        Integer[] array = new Integer[]{null,null,null,null};
        int expected = 0;
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        int actual = idd.getNonnullLength(array);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void trimArrayTest() {
        Integer[] array = new Integer[] {1,1,1,2,null,null,null};
        Integer[] expected = {1,1,1,2};
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer[] actual = idd.trimArray(array);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void trimArrayTest2() {
        Integer[] array = {null,null,null,null,null};
        Integer[] expected = {};
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer[] actual = idd.trimArray(array);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void trimArrayTest3() {
        Integer[] array = {1,1,1,2,3,4,5,null,null,null};
        Integer[] expected = {1,1,1,2,3,4,5};
        IntegerDuplicateDeleter idd = new IntegerDuplicateDeleter(array);
        Integer[] actual = idd.trimArray(array);
        Assert.assertArrayEquals(expected,actual);
    }
}
