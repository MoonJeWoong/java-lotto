package lotto.model;

import java.util.Arrays;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    private static final String commandErrorMessage = "[ERROR] 입력 값은 R / Q 중 하나로만 가능합니다. 다시 입력해주세요.";

    private String command;

    RetryCommand(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static RetryCommand of(String command){
        return Arrays.stream(values())
                .filter(value -> value.getCommand().equals(command))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(commandErrorMessage));
    }
}
