import java.util.ArrayList;

public class Media {

    private String title;
    private double rating;
    private String category;

    public Media(String title, double rating, String category) {
        this.title = title;
        this.rating = rating;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Media{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", category='" + category + '\'' +
                '}';
    }
}
