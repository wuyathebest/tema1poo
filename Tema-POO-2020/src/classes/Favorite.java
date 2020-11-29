package classes;

import fileio.ActionInputData;
import fileio.UserInputData;
import org.json.JSONObject;

import java.util.List;

final public class Favorite extends Command {
    private String title;

    public Favorite(final ActionInputData input, final List<UserInputData> userInput) {
        super(input, userInput);
        this.title = input.getTitle();
    }


    public JSONObject execute() {
        int response = this.user.addFavorite(title);
        JSONObject result = new JSONObject();
        result.put("id", this.actionId);
        if (response == 0) {
            this.message = "error -> " + this.title + " is not seen";
        }
        if (response == 1) {
            this.message = "success -> " + this.title + " was added as favourite";
        }
        if (response == 2) {
            this.message = "error -> " + this.title + " is already in favourite list";
        }
        result.put("message", this.message);
        return result;
    }
}
