package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate(int startNumber, int lastNumber, int length){
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(startNumber, lastNumber, length));
    }
}
