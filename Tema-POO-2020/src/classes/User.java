package classes;

import fileio.UserInputData;

import java.util.ArrayList;
import java.util.Map;

final public class User {
    private String username;
    private String subscriptionType;
    private ArrayList<String> favoriteMovies;
    private Map<String, Integer> history;

    public ArrayList<String> getFavoriteMovies() {
        return favoriteMovies;
    }

    public String getUsername() {
        return username;
    }

    public Map<String, Integer> getHistory() {
        return history;
    }

    public User(final UserInputData input) {
        this.username = input.getUsername();
        this.subscriptionType = input.getSubscriptionType();;
        this.favoriteMovies = input.getFavoriteMovies();
        this.history = input.getHistory();
    }

    public int addFavorite(final String title) {
        boolean seen = history.containsKey(title);
        int result;
        if (!seen) {
            result = 0;
        } else {
            boolean hasFavorite = favoriteMovies.contains(title);
            if (!hasFavorite) {
                this.favoriteMovies.add(title);
                result = 1;
            } else {
                result = 2;
            }
        }
        return result;
    }

}
