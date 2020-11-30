package classes;

import fileio.UserInputData;

import java.util.ArrayList;
import java.util.Map;

final public class User {
    private String username;
    private String subscriptionType;
    private ArrayList<String> favoriteMovies;
    private Map<String, Integer> history;
    private ArrayList<MovieRate> ratedMovies = new ArrayList<>();

    public ArrayList<MovieRate> getRatedMovies() {
        return ratedMovies;
    }

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

    public int addRating(final String title, final double grade) {
        boolean seen = this.history.containsKey(title);
        int response = 1;
        if (seen) {
            for (int i = 0; i < this.ratedMovies.size(); i++) {
                if (this.ratedMovies.get(i).getTitle().equals(title)) {
                    response = 0;
                    break;
                }
            }
            if (response == 1) {
                this.ratedMovies.add(new MovieRate(title, grade));
            }
        } else {
            response = 2;
        }
        return response;
    }

    public void addViews(final String title) {
        boolean seen = history.containsKey(title);
        if (seen) {
            history.put(title, history.get(title) + 1);
        } else {
            history.put(title, 1);
        }
    }
}
