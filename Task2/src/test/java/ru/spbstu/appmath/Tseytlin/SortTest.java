package ru.spbstu.appmath.Tseytlin;

import static java.lang.Math.abs;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.lang.String;
import java.util.Random;



@RunWith(Parameterized.class)
public class SortTest <T> {
    private static final BubbleSort Bubble_Sort = new BubbleSort();
    private Sort<T> sort;
    private T[] input;
    private final Comparator<T> comparator;

    private static final Comparator<Double> DOUBLE_COMPARATOR_FIRST = new Comparator<Double>() {
        public int compare(final Double o1, final Double o2) {
            return o1.compareTo(o2);
        }
    };

    private static final Comparator<Double> DOUBLE_COMPARATOR_SECOND = new Comparator<Double>() {
        public int compare(final Double o1, final Double o2) {
            return o2.compareTo(o1);
        }
    };

    private static final Comparator<Human> HUMAN_COMPARATOR_NAME = new Comparator<Human>() {
        public int compare(final Human h1, final Human h2) {
            String tmp = h1.getName();
            return tmp.compareTo(h2.getName());
        }
    };

    private static final Comparator<Human> HUMAN_COMPARATOR_AGE = new Comparator<Human>() {
        public int compare(final Human o1, final Human o2) {
            Integer tmp = o1.getAge();
            return tmp.compareTo(o2.getAge());
        }
    };

    private static <T> boolean testOrder(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i],array[i + 1]) > 0)
                return false;
        }
        return true;
    }

    private static <T> boolean hasEachElementOf(T[] input, T[] result) {
        for (T element : input) {
            int counter = 0;
            for (int j = 0; j < result.length; j++) {
                if (element.equals(input[j]))
                    counter--;
                if (element.equals(result[j]))
                    counter++;
            }
            if(counter != 0)
                return false;
        }
        return true;
    }

    public static Double[] randomDoubleData() {
        Random rand = new Random();
        Double[] data = new Double[(abs(rand.nextInt(100)) + 1)];
        for(int i = 0; i < data.length; i++ )
            data[i] = rand.nextDouble();
        return data;
    }
    public static Human[] randomHumanData() {
        String[] names = new String[]{"Lenny", "Sanny", "Egen", "David", "Isac", "Andry", "Max", "Nicketas", "Bobby", "Slavin", "John"};
        Random rand = new Random();
        Human[] data = new Human[(abs(rand.nextInt(100)) + 1)];
        for(int i = 0; i < data.length; i++ )
            data[i] = new Human(names[rand.nextInt(names.length)], (rand.nextInt(99) + 1));
        return data;
    }

    private static final Object[][] TEST_DATA = {
            {Bubble_Sort, randomDoubleData(), DOUBLE_COMPARATOR_FIRST},//0
            {Bubble_Sort, new Double[]{1.,1.,1.,1. }, DOUBLE_COMPARATOR_SECOND},//1
            {Bubble_Sort, new Double[]{}, DOUBLE_COMPARATOR_FIRST},//2
            {Bubble_Sort, new Double[]{131.4, 224.0, 23.0, 352.5}, DOUBLE_COMPARATOR_SECOND},//3
            {Bubble_Sort, randomHumanData(), HUMAN_COMPARATOR_AGE},
            {Bubble_Sort, new Human[]{new Human("Leo",3), new Human ("San",1), new Human ("Nick",2),//5
                    new Human ("Ivanov",103)}, HUMAN_COMPARATOR_AGE},
            {Bubble_Sort, new Human[]{new Human("Nadya",32), new Human ("Anya",24), new Human ("Dasha",14),//6
                    new Human ("Ivanov",103)}, HUMAN_COMPARATOR_NAME}
    };



    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TEST_DATA);
    }

    public SortTest(Sort<T> sort, T[] input, Comparator<T> comparator) {
        this.sort = sort;
        this.input = input;
        this.comparator = comparator;
    }

    @Test
    public void test() {
        T[] result = sort.sort(input, (Comparator<T>) comparator);
        Assert.assertTrue(testOrder(result, comparator));
        Assert.assertEquals("Result array length should be equal to original", input.length, result.length);
        Assert.assertTrue(hasEachElementOf(input, result));
    }
}
