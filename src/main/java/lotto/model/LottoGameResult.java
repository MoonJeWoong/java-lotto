package lotto.model;

import java.util.HashMap;

public class LottoGameResult {
    private static final int COUNT_ZERO = 0;
    private static final int COUNT_ONE = 1;
    private static final int SUM_ZERO = 0;

    private final HashMap<Rank, Integer> lottoResult = new HashMap<>();

    public LottoGameResult() {
        lottoResult.put(Rank.FIRST, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.NO_RANK_ZERO, 0);
        lottoResult.put(Rank.NO_RANK_ONE, 0);
        lottoResult.put(Rank.NO_RANK_TWO, 0);
    }

    public void put(Rank rank){
        lottoResult.put(rank, lottoResult.getOrDefault(rank, COUNT_ZERO) + COUNT_ONE);
    }

    public int get(Rank rank){
        return lottoResult.get(rank);
    }

    public long getPrizeSum() {
        long sum = SUM_ZERO;
        for (Rank rank : lottoResult.keySet()) {
            sum += rank.getPrize() * lottoResult.get(rank);
        }
        return sum;
    }


}
