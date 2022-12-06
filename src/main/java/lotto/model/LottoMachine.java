package lotto.model;

import lotto.utils.LottoNumberGenerator;

import static lotto.model.LottoConstants.LOTTO_LAST_NUMBER;
import static lotto.model.LottoConstants.LOTTO_LENGTH;
import static lotto.model.LottoConstants.LOTTO_START_NUMBER;

import java.util.ArrayList;

public class LottoMachine {

    private static final int COUNT_ZERO = 0;

    private LottoNumberGenerator generator;

    public static LottoMachine from(LottoNumberGenerator generator){
        return new LottoMachine(generator);
    }

    private LottoMachine(LottoNumberGenerator generator){
        this.generator = generator;
    }

    public ArrayList<Lotto> publishLotteries(int count) {
        ArrayList<Lotto> lotteries = new ArrayList<>();
        for (; count > COUNT_ZERO; count--) {
            lotteries.add(generateLottoNumber());
        }
        return lotteries;
    }

    private Lotto generateLottoNumber() {
        return new Lotto(generator.generate(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_LENGTH));
    }
}
