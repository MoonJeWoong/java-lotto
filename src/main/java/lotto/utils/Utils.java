package lotto.utils;

import lotto.validation.Validation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Utils {

    public static List<Integer> sortListNaturalOrder(List<Integer> list) {
        List<Integer> orderedList = new ArrayList<>(list);
        Collections.sort(orderedList);
        return orderedList;
    }

    public static int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static List<Integer> stringToIntegerList(String string) {
        Validation.validateListStringToInteger(Arrays.asList(string.split(",")));
        return Arrays.stream(stringToIntArray(string)).boxed().collect(Collectors.toList());
    }

    public static int stringToInteger(String string) {
        Validation.validateStringToInteger(string);
        return Integer.parseInt(string);
    }
}
