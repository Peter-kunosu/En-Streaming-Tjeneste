import java.util.ArrayList;

public class Media {

    private String title;
    private float rating;
    private String category;

    public Media(String title, float rating, String category) {
        this.title = title;
        this.rating = rating;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public float getRating() {
        return rating;
    }

    public String getCategory() {
        return category;
    }
}
