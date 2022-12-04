package lotto.model;

import lotto.utils.Utils;
import lotto.validation.Validation;

import static lotto.model.LottoConstants.LOTTO_LAST_NUMBER;
import static lotto.model.LottoConstants.LOTTO_LENGTH;
import static lotto.model.LottoConstants.LOTTO_START_NUMBER;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Utils.sortListNaturalOrder(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countCorrectLottoNumbers(Lotto other) {
        return (int)this.numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(int number){
        return this.numbers.contains((number));
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLengthOfList(numbers, LOTTO_LENGTH);
        Validation.validateDuplicationList(numbers);
        Validation.validateListNumberInRange(numbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
    }

    @Override
    public String toString(){
        return numbers.toString();
    }
}
