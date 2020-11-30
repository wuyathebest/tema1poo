package classes;

public class MovieRate {
    private String title;
    private double grade;

    public MovieRate(final String title, final double grade) {
        this.title = title;
        this.grade = grade;
    }

    public String getTitle() {
        return title;
    }

    public double getGrade() {
        return grade;
    }
}
