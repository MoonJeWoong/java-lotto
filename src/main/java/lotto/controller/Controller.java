package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoGameResult;
import lotto.model.LottoMachine;
import lotto.model.RetryCommand;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class Controller {
    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;
    private Buyer buyer;

    public static Controller of(InputView inputView, OutputView outputView, LottoNumberGenerator generator){
        return new Controller(inputView, outputView, generator);
    }

    private Controller(InputView inputView, OutputView outputView, LottoNumberGenerator generator){
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = LottoMachine.from(generator);
    }

    public void run() {
        do{
            beforeLottoGame();
            playLottoGame();
        } while(canGameContinue());
    }

    private void beforeLottoGame() {
        buyer = initBuyer();
        List<Lotto> publishedLotteries = lottoMachine.publishLotteries(buyer.countOfAvailableLotteries());
        buyer.buyLotteries(publishedLotteries);
        showBuyingResult();
    }

    private Buyer initBuyer(){
        try{
            return new Buyer(inputView.readAmount());
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
            return initBuyer();
        }
    }

    private void playLottoGame(){
        LottoGame lottoGame = initLottoGame();
        LottoGameResult result = lottoGame.checkGameResult(buyer.getPurchasedLotteries());
        showGameResult(result);
    }

    private LottoGame initLottoGame() {
        try{
            return new LottoGame(getWinningLotto(), inputView.readBonusNumber());
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
            return initLottoGame();
        }
    }

    private void showGameResult(LottoGameResult result) {
        outputView.winningStatistics();
        outputView.showRankResult(result);
        outputView.showYieldResult(buyer.getYield(result.getPrizeSum()));
    }

    private void showBuyingResult() {
        outputView.purchaseComplete(buyer.countOfAvailableLotteries());
        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            outputView.printLotto(lotto);
        }
    }

    private Lotto getWinningLotto() {
        try{
            return new Lotto(inputView.readWinningNumbers());
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
            return getWinningLotto();
        }
    }

    private boolean canGameContinue(){
        return inputView.readRetryCommand().equals(RetryCommand.RETRY);
    }
}
