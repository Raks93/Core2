package homework.task2;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSumTwoNumbersEqualsNumber(new Integer[]{3, 4, 2, 7}, 10)));

    }

    public static Integer[] findSumTwoNumbersEqualsNumber (Integer[] array, Integer goal) {

        if (Objects.isNull(goal)) {
            return new Integer[]{0, 0};
        }
        Integer[] filterArray = Arrays.stream(array)
                .filter(Objects::nonNull)
                .toArray(Integer[]::new);

        for (int i = 0; i < filterArray.length - 1; i++) {
                for (int j = i + 1; j < filterArray.length; j++) {
                    if (filterArray[i] + filterArray[j] == goal) {
                        return new Integer[] {filterArray[i], filterArray[j]};
                    }
                }
            }


        return new Integer[]{0, 0};
    }
}