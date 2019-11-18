package rocks.zipcode.io.quiz3.generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author leon on 09/12/2018.
 */
public class ArrayUtility<T> {
    private final T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public T findOddOccurringValue() {
        T value = null;
        for (int i = 0; i < array.length; i++) {
            if(getNumberOfOccurrences(array[i]) %2 != 0){
                value = array[i];
                break;
            }
        }
        return value;
    }

    public T findEvenOccurringValue() {
        T value = null;
        for (int i = 0; i < array.length; i++) {
            if(getNumberOfOccurrences(array[i]) %2 == 0){
                value = array[i];
                break;
            }
        }
        return value;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        return filter(value->value.equals(valueToEvaluate)).length;
    }

    public T[] filter(Function<T, Boolean> predicate) {
        List<T> list = Arrays.stream(array)
                .filter(value -> predicate.apply(value))
                .collect(Collectors.toList());
        return list.toArray((T[]) Array.newInstance(array.getClass().getComponentType(), list.size()));
    }
}
