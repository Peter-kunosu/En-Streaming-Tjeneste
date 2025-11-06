public class Movie extends Media{
    private int realeaseDate;

    public Movie(String title, float rating, String category, int realeaseDate) {
        super(title, rating, category);
        this.realeaseDate = realeaseDate;
    }

    public int getRealeaseDate() {
        return realeaseDate;
    }
}
