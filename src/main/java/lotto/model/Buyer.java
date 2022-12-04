package lotto.model;

import lotto.validation.Validation;

import static lotto.model.LottoConstants.LOTTO_LEAST_AMOUNT;
import static lotto.model.LottoConstants.LOTTO_MAX_AMOUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buyer {
    private static final int ROUND_CONSTANT_INT_TEN = 10;
    private static final double ROUND_CONSTANT_DOUBLE_TEN = 10.0;
    private static final double PERCENT = 100;

    private final ArrayList<Lotto> purchasedLotteries = new ArrayList<>();
    private final int purchaseAmount;

    public Buyer(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void buyLotteries(List<Lotto> lotteries){
        for(Lotto lotto : lotteries){
            buyLotto(lotto);
        }
    }

    public void buyLotto(Lotto lotto) {
        purchasedLotteries.add(lotto);
    }

    public List<Lotto> getPurchasedLotteries() {
        return Collections.unmodifiableList(purchasedLotteries);
    }

    public double getYield(long prizeSum) {
        double originYield = (prizeSum / (double) purchaseAmount) * PERCENT;
        return Math.round(originYield * ROUND_CONSTANT_INT_TEN) / ROUND_CONSTANT_DOUBLE_TEN;
    }

    public int countOfAvailableLotteries(){
        return purchaseAmount / LOTTO_LEAST_AMOUNT;
    }

    private void validatePurchaseAmount(int amount) {
        Validation.validateMultipleNumber(amount, LOTTO_LEAST_AMOUNT);
        Validation.validateExceedNumber(amount, LOTTO_MAX_AMOUNT);
    }
}
