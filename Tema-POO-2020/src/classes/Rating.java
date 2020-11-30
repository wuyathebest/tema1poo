package classes;

import fileio.ActionInputData;
import fileio.UserInputData;
import org.json.JSONObject;

import java.util.List;

final public class Rating extends Command {
    private String title;
    private double grade;

    public Rating(final ActionInputData input, final List<UserInputData> userInput) {
        super(input, userInput);
        this.title = input.getTitle();
        this.grade = input.getGrade();
    }

    public JSONObject execute() {
        int response = user.addRating(title, grade);
        JSONObject result = new JSONObject();
        result.put("id", this.actionId);
        if (response == 0) {
            this.message = "error -> " + this.title + " has been already rated";
        }
        if (response == 1) {
            this.message = "success -> " + this.title + " was rated with " + this.grade
                    + " by " + this.username;
        }
        if (response == 2) {
                this.message = "error -> " + this.title + " is not seen";
        }
        result.put("message", this.message);
        return result;
    }
}