package lotto.view;

import lotto.model.RetryCommand;
import lotto.utils.Utils;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputView {
    public int readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try{
            return Utils.stringToInteger(readLine().trim());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readAmount();
        }
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        try{
            return Utils.stringToIntegerList(readLine().trim());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readWinningNumbers();
        }
    }

    public int readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try{
            return Utils.stringToInteger(readLine().trim());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readBonusNumber();
        }
    }

    public RetryCommand readRetryCommand(){
        System.out.println("\n게임 재시작을 원하시면 R, 종료를 원하시면 Q를 입력해 주세요.");
        try{
            return RetryCommand.of(readLine().trim());
        } catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
            return readRetryCommand();
        }
    }
}
