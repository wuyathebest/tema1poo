package classes;

import fileio.ActionInputData;
import fileio.UserInputData;
import org.json.JSONObject;

import java.util.List;

public abstract class Action {
    protected int actionId;
    private String actionType;
    protected String type;
    protected String username;
    abstract public JSONObject execute();
    protected User user;
    protected String message;

    private void findUser(final List<UserInputData> users) {
        int i;
        for (i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                this.user = new User(users.get(i));
            }
        }
    }

    public Action(final ActionInputData input, final List<UserInputData> userInput) {
        this.actionId = input.getActionId();
        this.actionType = input.getActionType();
        this.type = input.getType();
        this.username = input.getUsername();
        this.findUser(userInput);
    }
}
