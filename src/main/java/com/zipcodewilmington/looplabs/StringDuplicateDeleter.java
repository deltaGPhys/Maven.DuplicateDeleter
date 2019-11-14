package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] output = new String[array.length];
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

    public String[] trimArray(String[] arr) {
        String[] result = new String[getNonnullLength(arr)];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public int getNonnullLength(String[] arr) {
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

    public String[] addNtoArray(String[] arr, String item, Integer N) {
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
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] output = new String[array.length];
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
