package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoGameResult;
import lotto.model.Rank;

public class OutputView {

    private static final long PRIZE_ZERO = 0L;

    public void purchaseComplete(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public void winningStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public void showRankResult(LottoGameResult result) {
        for (Rank rank : Rank.values()) {
            showSingleRankResult(result, rank);
        }
    }

    private void showSingleRankResult(LottoGameResult result, Rank rank) {
        if (rank.getPrize()==PRIZE_ZERO) {
            return;
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    rank.getCount(), rank.getPrintablePrize(), result.get(rank));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getCount(), rank.getPrintablePrize(), result.get(rank));
    }

    public void showYieldResult(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }
}
