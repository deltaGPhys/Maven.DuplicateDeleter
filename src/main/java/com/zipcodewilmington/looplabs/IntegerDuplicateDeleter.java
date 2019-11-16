package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Arrays;

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
        return Arrays.stream(array).filter(y -> getOccurrence(y) < maxNumberOfDuplications).toArray(Integer[] :: new);
    }

    public Long getOccurrence(int x) {
        return Arrays.stream(array).filter(z -> z==x).count();
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return Arrays.stream(array).filter(y -> getOccurrence(y) != exactNumberOfDuplications).toArray(Integer[] :: new);
    }
}
