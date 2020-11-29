package classes;

import fileio.ActionInputData;
import fileio.UserInputData;

import java.util.List;

public abstract class Command extends Action {

    public Command(final ActionInputData input, final List<UserInputData> userInput) {
        super(input, userInput);
    }
}
