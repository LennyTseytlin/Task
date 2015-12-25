package ru.spbstu.appmath.Tseytlin;

import ru.spbstu.appmath.Tseytlin.Sort;

import java.util.Arrays;
import java.util.Comparator;


public class BubbleSort<T> implements Sort<T> {
    private static <T> void BubbleSort(T[] array, int left, int right, Comparator<T> comparator) {
        boolean swapped = true;
        int j = 0;
        T tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (comparator.compare(array[i] , array[i + 1])>0) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public T[] sort(T[] array, Comparator<T> comparator) {
        T[] result = Arrays.copyOf(array, array.length);
        BubbleSort(result, 0, array.length - 1, comparator);
        return result;
    }
}
