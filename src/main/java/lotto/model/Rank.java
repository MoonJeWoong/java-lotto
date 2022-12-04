package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    NO_RANK_ZERO(0, 0L, "0"),
    NO_RANK_ONE(1, 0L, "0"),
    NO_RANK_TWO(2, 0L, "0"),
    FIFTH(3, 5_000L, "5,000"),
    FOURTH(4, 50_000L, "50,000"),
    THIRD(5, 1_500_000L, "1,500,000"),
    SECOND(5, 30_000_000L, "30,000,000"),
    FIRST(6, 2_000_000_000L, "2,000,000,000");

    private static final int DETERMINED_SIZE = 1;
    private static final int INDEX_ZERO = 0;
    private static final int SIZE_ZERO = 0;
    private static final String NO_SUCH_RANK_ERROR = "[ERROR] 해당하는 랭크가 존재하지 않습니다. 관리자에게 문의주세요.";

    final private int count;
    final private long prize;
    final private String printablePrize;

    Rank(int count, long prize, String printablePrize) {
        this.count = count;
        this.prize = prize;
        this.printablePrize = printablePrize;
    }

    public static Rank of(int correctCount, boolean correctBonusNumber) {
        List<Rank> determinedRanks = Arrays.stream(values()).filter(rank -> rank.getCount() == correctCount)
                .collect(Collectors.toList());
        if(determinedRanks.size()==SIZE_ZERO){
            throw new IllegalArgumentException(NO_SUCH_RANK_ERROR);
        }
        if(determinedRanks.size()!=DETERMINED_SIZE){
            return determineSecondOrThird(correctBonusNumber);
        }
        return determinedRanks.get(INDEX_ZERO);
    }

    private static Rank determineSecondOrThird(boolean correctBonusNumber){
        if(correctBonusNumber){
            return SECOND;
        }
        return THIRD;
    }

    public int getCount() {
        return count;
    }

    public long getPrize() {
        return prize;
    }

    public String getPrintablePrize() {
        return printablePrize;
    }
}
