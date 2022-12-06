package lotto.validation;

import java.util.HashSet;
import java.util.List;

public final class Validation {
    private static final String NUMBER_IN_RANGE_ERROR = "[ERROR] 입력 값의 범위는 %d부터 %d 사이의 숫자여야 합니다.\n";
    private static final String DUPLICATION_LIST_ERROR = "[ERROR] 입력 값들은 서로 중복되지 않아야 합니다.\n";
    private static final String LENGTH_ERROR = "[ERROR] 입력 값의 개수는 %d개 여야 합니다.\n";
    private static final String MULTIPLE_NUMBER_ERROR = "[ERROR] 입력 값은 %d의 배수여야 합니다.\n";
    private static final String EXCEED_ERROR = "[ERROR] 입력 값은 %d 이하의 값이어야 합니다.\n";
    private static final String STRING_TO_INTEGER_ERROR = "[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.\n";


    public static void validateListNumberInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        for (int number : numbers) {
            validateNumberInRange(number, startInclusive, endInclusive);
        }
    }

    public static void validateNumberInRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            throw new IllegalArgumentException(String.format(NUMBER_IN_RANGE_ERROR,startInclusive, endInclusive));
        }
    }

    public static void validateDuplicationList(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            throw new IllegalArgumentException(DUPLICATION_LIST_ERROR);
        }
    }

    public static void validateLengthOfList(List<Integer> list, int length) {
        if (list.size() != length) {
            throw new IllegalArgumentException(String.format(LENGTH_ERROR,length));
        }
    }

    public static void validateMultipleNumber(int dividend, int divisor) {
        if (dividend < divisor || dividend % divisor != 0) {
            throw new IllegalArgumentException(String.format(MULTIPLE_NUMBER_ERROR, divisor));
        }
    }

    public static void validateExceedNumber(int number, int limitNumber) {
        if (number > limitNumber) {
            throw new IllegalArgumentException(String.format(EXCEED_ERROR, limitNumber));
        }
    }

    public static void validateListStringToInteger(List<String> list) {
        for (String string : list) {
            validateStringToInteger(string);
        }
    }

    public static void validateStringToInteger(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(STRING_TO_INTEGER_ERROR);
        }
    }
}
