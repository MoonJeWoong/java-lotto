package lotto.utils;

import java.util.List;

public interface LottoNumberGenerator {
    List<Integer> generate(int startNumber, int lastNumber, int length);
}
