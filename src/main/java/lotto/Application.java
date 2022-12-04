package lotto;

import lotto.controller.Controller;
import lotto.utils.LottoNumberGenerator;
import lotto.utils.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = Controller.of(new InputView(), new OutputView(), new RandomLottoNumberGenerator());
        controller.run();
    }
}
