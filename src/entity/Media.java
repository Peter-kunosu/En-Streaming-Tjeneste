package entity;

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

    @Override
    public String toString() {
        return
                "| Title = " + title +
                " | Rating = " + rating +
                " | Category = " + category
                ;
    }
}
