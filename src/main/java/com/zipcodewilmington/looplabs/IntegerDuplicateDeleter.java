package com.zipcodewilmington.looplabs;

import java.util.ArrayList;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] output = new Integer[array.length];
        int i = 0;
        int num;
        while (i < array.length) {
            num = countConsecutives(i);
            if (num < maxNumberOfDuplications) {
                output = addNtoArray(output, array[i], num);
            }
            i += num;
        }
        return trimArray(output);
    }

    public Integer[] trimArray(Integer[] arr) {
        Integer[] result = new Integer[getNonnullLength(arr)];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public int getNonnullLength(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return i;
            }
        }
        return arr.length;
    }

    public int countConsecutives(Integer indexToStart) {
        int result = 0;
        for (int i = 1; i <= array.length-indexToStart; i++) {
            if (i+indexToStart == array.length) {
                return i;
            }
            if (array[indexToStart+i] != array[indexToStart]) {
                return i;
            }
        }
        return result;
    }

    public Integer[] addNtoArray(Integer[] arr, Integer item, Integer N) {
        int added = 0;
        for (int i = 0; i < arr.length && added < N; i++) {
            if (arr[i] == null) {
                arr[i] = item;
                added++;
            }
        }
        return arr;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] output = new Integer[array.length];
        int i = 0;
        int num;
        while (i < array.length) {
            num = countConsecutives(i);
            if (num != exactNumberOfDuplications) {
                output = addNtoArray(output, array[i], num);
            }
            i += num;
        }
        return trimArray(output);
    }
}
