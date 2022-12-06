package lotto.model;

import lotto.validation.Validation;

import static lotto.model.LottoConstants.LOTTO_LAST_NUMBER;
import static lotto.model.LottoConstants.LOTTO_START_NUMBER;

import java.util.List;

public class LottoGame {
    private static final String DUPLICATED_NUMBER_IN_LIST_ERROR =
            "[ERROR] 보너스 번호는 로또 번호와 중복되어선 안됩니다. 재입력 해주십시오.\n";

    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoGame(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    public void validateBonusNumber(int bonusNumber) {
        Validation.validateNumberInRange(bonusNumber, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
        if(winningLotto.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATED_NUMBER_IN_LIST_ERROR);
        }
    }

    public LottoGameResult checkGameResult(List<Lotto> lotteries) {
        LottoGameResult result = new LottoGameResult();
        for (Lotto lotto : lotteries) {
            result.put(Rank.of(lotto.countCorrectLottoNumbers(winningLotto), lotto.contains(bonusNumber)));
        }
        return result;
    }
}
