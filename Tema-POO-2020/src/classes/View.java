package classes;

import fileio.ActionInputData;
import fileio.UserInputData;
import org.json.JSONObject;

import java.util.List;

final public class View extends Command {
    private String title;

    public View(final ActionInputData input, final List<UserInputData> userInput) {
        super(input, userInput);
        this.title = input.getTitle();
    }

    public JSONObject execute() {
        JSONObject result = new JSONObject();
        result.put("id", this.actionId);
        this.user.addViews(title);
        this.message = "success -> " + this.title + " was viewed with total views of "
                + this.user.getHistory().get(title);
        result.put("message", this.message);
        return result;
    }
}
